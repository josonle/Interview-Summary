package cn.sheep.cmcc.service;

import cn.sheep.cmcc.beans.MinuteKpiVo;

public interface IMinuteService {
    /**
     *
     * 根据日期和时间获取获取数据
     * @param date
     * @param hourMinutes
     * @return
     */
  public   MinuteKpiVo findBy(String date, String hourMinutes);
}
