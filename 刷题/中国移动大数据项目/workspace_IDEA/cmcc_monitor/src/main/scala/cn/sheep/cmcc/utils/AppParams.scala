package cn.sheep.cmcc.utils

import com.typesafe.config.{Config, ConfigFactory}
import org.apache.kafka.common.serialization.StringDeserializer

/**
  * ZhangJunJie
  * 2018/10/16 9:58
  * Describe：
  **/

object AppParams {

  /**
    * 解析application.conf配置文件
    * 加载resource下面的配置文件，默认规则：application.conf->application.json->application.properties
    */
  private lazy val config: Config = ConfigFactory.load()

  /**
    * 返回订阅的主题
    */
  val topic = config.getString("kafka.topic").split(",")

  /**
    * kafka集群所在的主机和端口
    */
  val borkers = config.getString("kafka.broker.list")

  /**
    * 消费者的ID
    */
  val groupId = config.getString("kafka.group.id")

  /**
    * kafka的相关参数
    */
  val kafkaParams = Map[String, Object](
    "bootstrap.servers" -> borkers,
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> groupId,
    "auto.offset.reset" -> "earliest",
    "enable.auto.commit" -> "false"
  )

  /**
    * redis服务器地址
    */
  val redisHost = config.getString("redis.host")

  /**
    * 将数据写入到哪个库
    */
  val selectDBIndex = config.getInt("redis.db.index")

  /**
    * 省份code和省份名称的映射关系
    */
  import scala.collection.JavaConversions._
  val pCode2PName  = config.getObject("pcode2pname").unwrapped().toMap

//    def main(args: Array[String]): Unit = {
//    val configObject = config.getObject("pcode2pname")
//
//    import scala.collection.JavaConversions._
//    val map: Map[String, AnyRef] = configObject.unwrapped().toMap
//
//    map.foreach(println)
//  }
}
