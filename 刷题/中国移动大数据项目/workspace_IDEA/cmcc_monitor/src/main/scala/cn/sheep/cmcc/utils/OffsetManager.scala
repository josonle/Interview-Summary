package cn.sheep.cmcc.utils

import org.apache.kafka.common.TopicPartition
import org.apache.spark.streaming.kafka010.OffsetRange
import scalikejdbc._
import scalikejdbc.config._

/**
  * ZhangJunJie
  * 2018/10/17 16:30
  * Describe：
  **/
object OffsetManager {
  DBs.setup()

  /**
    * 获取自己存储的偏移量信息，MySql
    * @return
    */
  def getMydbCurrentOffset: Map[TopicPartition, Long] = {
    DB.readOnly(implicit session =>
      SQL("select * from streaming_offset where groupId=?").bind(AppParams.groupId)
        .map(rs =>
          (
            new TopicPartition(rs.string("topicName"), rs.int("partitionId")),
            rs.long("offset")
          )
      ).list().apply().toMap
    )
  }

  /**
    * 持久化存储当前批次的偏移量
    * @param offsetRanges
    */
  def saveCurrentOffset(offsetRanges: Array[OffsetRange])={
    DB.localTx(implicit session =>{
      offsetRanges.foreach(or => {
        SQL("replace into streaming_offset values(?,?,?,?)")
          .bind(or.topic, or.partition, or.untilOffset, AppParams.groupId)
          .update()
          .apply()
      })
    })
  }
}
