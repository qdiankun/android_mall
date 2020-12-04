package com.me.slone.mall.http.response.order;

import java.util.List;

/**
 * Author：diankun
 * Time：20-12-4 下午5:20
 * Description:
 */
public class GoodItemBean {

    /**
     * {
     * "number": 1,
     * "picUrl": "http://yanxuan.nosdn.127.net/1e7e392b6fc9da99dc112197b7444eec.png",
     * "price": 69,
     * "id": 4,
     * "goodsName": "宠物合金钢安全除菌指甲",
     * "specifications": [
     * "标准"
     * ]
     * },
     */
    private int number;
    private String picUrl;
    private float price;
    private int id;
    private String goodsName;
    private List<String> specifications;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setSpecifications(List<String> specifications) {
        this.specifications = specifications;
    }

    public int getNumber() {
        return number;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public List<String> getSpecifications() {
        return specifications;
    }
}
