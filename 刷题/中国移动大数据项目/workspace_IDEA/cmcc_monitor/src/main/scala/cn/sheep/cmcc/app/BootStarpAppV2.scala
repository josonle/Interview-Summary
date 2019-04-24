package cn.sheep.cmcc.app

import cn.sheep.cmcc.utils.{AppParams, KpiTools, OffsetManager}
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.SparkConf
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * ZhangJunJie
  * 2018/10/16 17:58
  * Describe：中国移动实时监控平台（优化版）
  **/

object BootStarpAppV2 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf()
    sparkConf.setAppName("中国移动运营实时监控平台-Monitor") //如果在集群上运行的话，需要去掉：sparkConf.setMaster("local[*]")
    sparkConf.setMaster("local[*]") //将rdd以序列化格式来保存以减少内存的占用
    //默认采用org.apache.spark.serializer.JavaSerializer
    //这是最基本的优化
    sparkConf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer") //rdd压缩
    sparkConf.set("spark.rdd.compress", "true") //batchSize = partitionNum * 分区数量 * 采样时间
    sparkConf.set("spark.streaming.kafka.maxRatePerPartition", "10000") //优雅的停止
    sparkConf.set("spark.streaming.stopGracefullyOnShutdown", "true")
    val ssc = new StreamingContext(sparkConf, Seconds(2))

    /**
      * 提取数据库中存储的偏移量
      */
    val currOffset = OffsetManager.getMydbCurrentOffset

    /**
      * 广播省份映射关系
      */
    val pcode2PName: Broadcast[Map[String, AnyRef]] = ssc.sparkContext.broadcast(AppParams.pCode2PName)

    /** 获取kafka的数据
      * LocationStrategies：位置策略，如果kafka的broker节点跟Executor在同一台机器上给一种策略，不在一台机器上给另外一种策略
      * 设定策略后会以最优的策略进行获取数据
      * 一般在企业中kafka节点跟Executor不会放到一台机器的，原因是kakfa是消息存储的，Executor用来做消息的计算，
      * 因此计算与存储分开，存储对磁盘要求高，计算对内存、CPU要求高
      * 如果Executor节点跟Broker节点在一起的话使用PreferBrokers策略，如果不在一起的话使用PreferConsistent策略
      * 使用PreferConsistent策略的话，将来在kafka中拉取了数据以后尽量将数据分散到所有的Executor上 */
    val stream: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream(ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](AppParams.topic, AppParams.kafkaParams, currOffset)
    )

    /**
      * 数据处理
      */
    stream.foreachRDD(rdd=>{
      val offsetRanges: Array[OffsetRange] = rdd.asInstanceOf[HasOffsetRanges].offsetRanges

      val baseData = KpiTools.baseDataRDD(rdd)

      /**
        * 计算业务概况
        */
      KpiTools.kpi_general(baseData)
      KpiTools.kpi_general_hour(baseData)

      /**
        * 业务质量
        */
      KpiTools.kpi_quality(baseData, pcode2PName)

      /**
        * 实时充值情况分析
        */
      KpiTools.kpi_realtime_minute(baseData)

      /**
        * 存储偏移量
        */
      OffsetManager.saveCurrentOffset(offsetRanges)
    })

    ssc.start()
    ssc.awaitTermination()
  }
}
