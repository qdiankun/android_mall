package com.me.slone.mall.http.response.cart;

import java.util.List;

/**
 * Author：diankun
 * Time：20-12-2 上午11:32
 * Description:
 */
public class CheckedGoodsBean {

    /**
     *                 "id": 16,
     *                 "userId": 6,
     *                 "goodsId": 1152161,
     *                 "goodsSn": "1152161",
     *                 "goodsName": "竹语丝麻印花四件套",
     *                 "productId": 239,
     *                 "price": 459,
     *                 "number": 2,
     *                 "specifications": [
     *                     "标准"
     *                 ],
     *                 "checked": true,
     *                 "picUrl": "http://yanxuan.nosdn.127.net/977401e75113f7c8334c4fb5b4bf6215.png",
     *                 "addTime": "2020-11-30 15:29:58",
     *                 "updateTime": "2020-12-02 11:07:49",
     *                 "deleted": false
     */
    private int id;
    private int userId;
    private int goodsId;
    private String goodsSn;
    private String goodsName;
    private int productId;
    private int price;
    private int number;
    private List<String> specifications;
    private boolean checked;
    private String picUrl;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSpecifications(List<String> specifications) {
        this.specifications = specifications;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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

    public int getUserId() {
        return userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public int getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public List<String> getSpecifications() {
        return specifications;
    }

    public boolean isChecked() {
        return checked;
    }

    public String getPicUrl() {
        return picUrl;
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
