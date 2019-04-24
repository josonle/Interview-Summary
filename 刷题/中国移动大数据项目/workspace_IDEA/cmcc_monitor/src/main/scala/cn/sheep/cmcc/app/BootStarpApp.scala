package cn.sheep.cmcc.app

import java.text.SimpleDateFormat

import cn.sheep.cmcc.utils.{AppParams, Jpools}
import com.alibaba.fastjson.JSON
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONException
import redis.clients.jedis.JedisPool;

/**
  * ZhangJunJie
  * 2018/10/16 15:58
  * Describe：
  **/

object BootStarpApp {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf()
    sparkConf.setAppName("中国移动运营实时监控平台-Monitor")
    //如果在集群上运行的话，需要去掉：sparkConf.setMaster("local[*]")
    sparkConf.setMaster("local[*]")
    //将rdd以序列化格式来保存以减少内存的占用
    //默认采用org.apache.spark.serializer.JavaSerializer
    //这是最基本的优化
    sparkConf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    //rdd压缩
    sparkConf.set("spark.rdd.compress", "true")
    //batchSize = partitionNum * 分区数量 * 采样时间
    sparkConf.set("spark.streaming.kafka.maxRatePerPartition", "100")
    //优雅的停止
    sparkConf.set("spark.streaming.stopGracefullyOnShutdown", "true")
    val ssc = new StreamingContext(sparkConf, Seconds(2))

    /** 获取kafka的数据
      * LocationStrategies：位置策略，如果kafka的broker节点跟Executor在同一台机器上给一种策略，不在一台机器上给另外一种策略
      * 设定策略后会以最优的策略进行获取数据
      * 一般在企业中kafka节点跟Executor不会放到一台机器的，原因是kakfa是消息存储的，Executor用来做消息的计算，
      * 因此计算与存储分开，存储对磁盘要求高，计算对内存、CPU要求高
      * 如果Executor节点跟Broker节点在一起的话使用PreferBrokers策略，如果不在一起的话使用PreferConsistent策略
      * 使用PreferConsistent策略的话，将来在kafka中拉取了数据以后尽量将数据分散到所有的Executor上
      */
    val stream: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream(ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](AppParams.topic, AppParams.kafkaParams))


    /**
      * 数据处理
      */
    stream.foreachRDD(rdd=>{
      //取得所有充值通知日志
      val baseData: RDD[JSONObject] = rdd.map(cr => JSON.parseObject(cr.value()))
          .filter(obj=> obj.getString("serviceName").equalsIgnoreCase("reChargeNotifyReq")).cache()
      /**
        * 获取到充值成功的订单笔数
        * 回忆：
        *   wordcount flatMap->map->reduceByKey
        *   hadoop spark hadoop
        */
      val totalSucc =  baseData.map(obj=>{
        val reqId = obj.getString("requestId")
        //获取日期
        val day = reqId.substring(0, 8)
        //取出该条充值是否成功的标志
        val result = obj.getString("bussinessRst")
        val flag = if(result.equals("0000")) 1 else 0
        (day, flag)
      }).reduceByKey(_+_)
      totalSucc.foreach(println)

      /**
        * 获取充值成功的订单金额
        */
      val totalMoney = baseData.map(obj=>{
        val reqId = obj.getString("requestId")
        //获取日期
        val day = reqId.substring(0, 8)
        //取出该条充值是否成功的标志
        val result = obj.getString("bussinessRst")
        val fee = if(result.equals("0000")) obj.getString("chargefee").toDouble  else 0
        (day, fee)
      }).reduceByKey(_+_)
      totalMoney.foreach(println)

      //总订单量
      /*val total = baseData.count()*/

      /**
        * 获取充值成功的充值时长
        */
        val totalTime = baseData.map(obj=>{
          var reqId = obj.getString("requestId")
        //获取日期
        val day = reqId.substring(0, 8)
        //取出该条充值是否成功的标志
        val result = obj.getString("bussinessRst")
        //时 间 格 式 为: yyyyMMddHHmissSSS(( 年月日时分秒毫秒)
        //获取起始时间与结束时间
        val endTime = obj.getString("receiveNotifyTime")
        val startTime =  reqId.substring(0, 17)
        val format = new SimpleDateFormat("yyyyMMddHHmmssSSS")
        val cost =  if(result.equals("0000")) format.parse(endTime).getTime - format.parse(startTime).getTime else 0
        (day, cost)

      }).reduceByKey(_+_)
      totalTime.foreach(println)


      //将充值成功的订单数写入到Redis
      totalSucc.foreachPartition(itr =>{
        val jedis = Jpools.getJedis
        itr.foreach(tp=>{
          jedis.incrBy("CMCC"+tp._1, tp._2)
        })
      })
    })

    //启动程序
    ssc.start()
    //等待程序被中断
    ssc.awaitTermination()
  }
}
