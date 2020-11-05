package com.me.slone.mall.http.response.goodsdetail;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-5 下午2:58
 * Description: 产品规格
 */
public class ProductBean {
    /**
     *
     *"id": 1,
     * "goodsId": 1181000,
     * "specifications": [
     * "1.5m床垫*1+枕头*2",
     * "浅杏粉"
     * ],
     * "price": 999,
     * "number": 100,
     * "url": "http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png",
     * "addTime": "2018-02-01 00:00:00",
     * "updateTime": "2018-02-01 00:00:00",
     * "deleted": false
     */

    private int id;
    private int goodsId;
    private List<String> specifications;
    private int price;
    private int number;
    private String url;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setSpecifications(List<String> specifications) {
        this.specifications = specifications;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public List<String> getSpecifications() {
        return specifications;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public String getUrl() {
        return url;
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
