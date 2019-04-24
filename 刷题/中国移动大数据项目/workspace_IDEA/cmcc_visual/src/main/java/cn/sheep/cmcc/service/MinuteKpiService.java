package cn.sheep.cmcc.service;

import cn.sheep.cmcc.beans.MinuteKpiVo;
import cn.sheep.cmcc.utils.Constants;
import cn.sheep.cmcc.utils.Jpools;
import redis.clients.jedis.Jedis;

public class MinuteKpiService implements  IMinuteService {

    @Override
    public MinuteKpiVo findBy(String day, String hourMinutes) {
        MinuteKpiVo vo = new MinuteKpiVo();
        //获取数据
        Jedis jedis=Jpools.getJedis();
        //获取最近一分钟的充值金额
        //获取最近一分钟的充值笔数
        String money =jedis.hget(Constants.MINUTES_PREFIX+day,Constants.MINUTES_FIELD_M_PREFIX+hourMinutes);
        String counts = jedis.hget(Constants.MINUTES_PREFIX+day,Constants.MINUTES_FIELD_C_PREFIX+hourMinutes);

        vo.setCount(counts);
        vo.setMoney(money);
        System.out.println(day+" "+vo.getCount()+":"+ vo.getMoney());
        return vo;
    }
}
