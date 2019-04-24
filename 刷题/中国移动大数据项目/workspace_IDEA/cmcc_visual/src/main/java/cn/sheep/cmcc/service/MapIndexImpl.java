package cn.sheep.cmcc.service;

import cn.sheep.cmcc.beans.MapVo;
import cn.sheep.cmcc.utils.Constants;
import cn.sheep.cmcc.utils.Jpools;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapIndexImpl implements IMapIndexService{
    @Override
    public List<MapVo> findAllBy(String day) {
        List<MapVo> list=new ArrayList<MapVo>();
        //从redis中获取数据
        Jedis jedis= Jpools.getJedis();
        Map<String, String> all = jedis.hgetAll(Constants.MAP_PRFIX + day);
        //数据封装

        for(Map.Entry<String,String> entry:all.entrySet()){
            MapVo map = new MapVo();
            map.setName(entry.getKey());
            map.setValue(Integer.parseInt(entry.getValue()));
            list.add(map);
        }
        return list;
    }
}
