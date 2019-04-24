package cn.sheep.cmcc.beans;

/**
 * 充值量分布业务实体类
 */
public class MapVo {
    //省份
    private String name;
    //订单成功数量
    private int value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
