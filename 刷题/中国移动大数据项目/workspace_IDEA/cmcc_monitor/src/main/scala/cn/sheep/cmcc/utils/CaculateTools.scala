package cn.sheep.cmcc.utils

import java.text.SimpleDateFormat

import org.apache.commons.lang3.time.FastDateFormat

/**
  * ZhangJunJie
  * 2018/10/16 17:41
  * Describe：中国移动实时监控平台（优化版）
  **/
object CaculateTools {

  // 非线程安全的
  //private val format = new SimpleDateFormat("yyyyMMddHHmmssSSS")
  // 线程安全的DateFormat
  private val format: FastDateFormat = FastDateFormat.getInstance("yyyyMMddHHmmssSSS")

  /**
    * 计算时间差
    * @param startTime
    * @param endTime
    * @return
    */
  def caculateTime(startTime:String, endTime:String):Long = {
    val start = startTime.substring(0, 17)
    format.parse(endTime).getTime - format.parse(start).getTime
  }
}
