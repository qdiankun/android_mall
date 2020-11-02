package com.me.slone.mall.http.response.goods;

/**
 * Author：diankun
 * Time：20-11-2 上午11:24
 * Description:
 */
public class GroupBean {

    /**
     * "id": 1110016,
     * "name": "天然硅胶宠物除毛按摩刷",
     * "brief": "顺滑平面，猫狗通用，去除死毛",
     * "picUrl": "http://yanxuan.nosdn.127.net/3bd73b7279a83d1cbb50c0e45778e6d6.png",
     * "counterPrice": 59,
     * "retailPrice": 39,
     * "grouponPrice": 0,
     * "grouponDiscount": 39,
     * "grouponMember": 2,
     * "expireTime": "2020-12-31 00:00:00"
     */

    private int id;
    private String name;
    private String brief;
    private String picUrl;
    private int counterPrice;
    private int retailPrice;
    private int grouponPrice;
    private int grouponDiscount;
    private int grouponMember;
    private String expireTime;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setCounterPrice(int counterPrice) {
        this.counterPrice = counterPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }

    public void setGrouponPrice(int grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public void setGrouponDiscount(int grouponDiscount) {
        this.grouponDiscount = grouponDiscount;
    }

    public void setGrouponMember(int grouponMember) {
        this.grouponMember = grouponMember;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrief() {
        return brief;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public int getCounterPrice() {
        return counterPrice;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public int getGrouponPrice() {
        return grouponPrice;
    }

    public int getGrouponDiscount() {
        return grouponDiscount;
    }

    public int getGrouponMember() {
        return grouponMember;
    }

    public String getExpireTime() {
        return expireTime;
    }
}
