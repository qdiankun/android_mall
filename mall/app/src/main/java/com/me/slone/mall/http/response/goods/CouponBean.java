package com.me.slone.mall.http.response.goods;

/**
 * Author：diankun
 * Time：20-11-2 上午11:22
 * Description:r
 *
 */
public class CouponBean {

    /**
     * "id": 1,
     * "name": "限时满减券",
     * "desc": "全场通用",
     * "tag": "无限制",
     * "discount": 5,
     * "min": 99,
     * "days": 10
     */

    private int id;
    private String name;
    private String desc;
    private String tag;
    private int discount;
    private int min;
    private int days;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getTag() {
        return tag;
    }

    public int getDiscount() {
        return discount;
    }

    public int getMin() {
        return min;
    }

    public int getDays() {
        return days;
    }
}
