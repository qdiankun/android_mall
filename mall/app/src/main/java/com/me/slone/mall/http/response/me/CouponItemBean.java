package com.me.slone.mall.http.response.me;

/**
 * Author：diankun
 * Time：20-12-1 上午10:14
 * Description:
 */
public class CouponItemBean {

    /**
     * "id": 10,
     * "cid": 2,
     * "name": "限时满减券",
     * "desc": "全场通用",
     * "tag": "无限制",
     * "min": 99,
     * "discount": 10,
     * "startTime": "2020-12-01 09:34:18",
     * "endTime": "2020-12-11 09:34:18",
     * "available": false
     */
    private int id;
    private int cid;
    private String name;
    private String desc;
    private String tag;
    private int min;
    private int discount;
    private String startTime;
    private String endTime;
    private boolean available;

    public int getId() {
        return id;
    }

    public int getCid() {
        return cid;
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

    public int getMin() {
        return min;
    }

    public int getDiscount() {
        return discount;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public void setMin(int min) {
        this.min = min;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
