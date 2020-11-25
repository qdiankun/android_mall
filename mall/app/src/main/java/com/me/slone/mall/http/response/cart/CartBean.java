package com.me.slone.mall.http.response.cart;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-24 下午4:17
 * Description:
 */
public class CartBean {

    /**
     *                 "id": 2,
     *                 "userId": 3,
     *                 "goodsId": 1110019,
     *                 "goodsSn": "1110019",
     *                 "goodsName": "宠物合金钢安全除菌指甲",
     *                 "productId": 153,
     *                 "price": 69,
     *                 "number": 3,
     *                 "specifications": [
     *                     "标准"
     *                 ],
     *                 "checked": true,
     *                 "picUrl": "http://yanxuan.nosdn.127.net/1e7e392b6fc9da99dc112197b7444eec.png",
     *                 "addTime": "2020-11-24 10:09:37",
     *                 "updateTime": "2020-11-24 10:15:46",
     *                 "deleted": false
     */

    private int id;
    private int userId;
    private int goodsId;
    private int goodsSn;
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

    public void setGoodsSn(int goodsSn) {
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

    public int getGoodsSn() {
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
