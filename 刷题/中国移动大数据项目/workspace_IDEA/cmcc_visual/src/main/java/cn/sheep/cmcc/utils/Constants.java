package cn.sheep.cmcc.utils;

/**
 * redis数据库key值前缀
 */
public class Constants {
    /**
     * key的前缀
     */
    public static final String MAP_PRFIX="C-";
    /**
     * 每分钟充钱笔数和金额的前缀
     */
    public static final String MINUTES_PREFIX="D-";
    //每分钟的充值成功笔数
    public static final String MINUTES_FIELD_C_PREFIX="C:";
    //每分钟充值金额
    public static final String MINUTES_FIELD_M_PREFIX="M:";

}
