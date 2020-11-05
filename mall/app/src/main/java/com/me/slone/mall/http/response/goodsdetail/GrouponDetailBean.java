package com.me.slone.mall.http.response.goodsdetail;

/**
 * Author：diankun
 * Time：20-11-5 下午3:03
 * Description: 团购拼团
 */
public class GrouponDetailBean {

    /**
     * "id": 5,
     * "goodsId": 1110019,
     * "goodsName": "宠物合金钢安全除菌指甲护理组合",
     * "picUrl": "http://yanxuan.nosdn.127.net/1e7e392b6fc9da99dc112197b7444eec.png",
     * "discount": 30,
     * "discountMember": 30,
     * "expireTime": "2022-03-03 00:00:00",
     * "status": 0,
     * "addTime": "2020-11-03 10:33:01",
     * "updateTime": "2020-11-03 10:33:01",
     * "deleted": false
     */
    private int id;
    private int goodsId;
    private String goodsName;
    private String picUrl;
    private int discount;
    private int discountMember;
    private String expireTime;
    private int status;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setDiscountMember(int discountMember) {
        this.discountMember = discountMember;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public int getDiscount() {
        return discount;
    }

    public int getDiscountMember() {
        return discountMember;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public int getStatus() {
        return status;
    }

    public String getAddTime() {
        return addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
