package com.me.slone.mall.bean;

/**
 * Author：diankun
 * Time：20-12-4 下午5:07
 * Description:
 */
public class OrderStatus {

    private int vaule;
    private String name;

    public OrderStatus(int value, String name) {
        this.vaule = value;
        this.name = name;
    }

    public void setVaule(int vaule) {
        this.vaule = vaule;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVaule() {
        return vaule;
    }

    public String getName() {
        return name;
    }
}
