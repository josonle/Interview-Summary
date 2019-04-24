package cn.sheep.cmcc.beans;

public class MinuteKpiVo {
    private String money;
    private String count;
    public MinuteKpiVo(String money,String counts){
        this.money=money;
        this.count=count;
    }
    public  MinuteKpiVo(){

    }
    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
