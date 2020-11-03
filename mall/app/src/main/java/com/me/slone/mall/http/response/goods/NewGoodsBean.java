package com.me.slone.mall.http.response.goods;

/**
 * Author：diankun
 * Time：20-11-2 上午11:20
 * Description:
 */
public class NewGoodsBean {

    /**
     * "id": 1116011,
     * "name": "蔓越莓曲奇 200克",
     * "brief": "酥脆奶香，甜酸回味",
     * "picUrl": "http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png",
     * "isNew": true,
     * "isHot": true,
     * "counterPrice": 56,
     * "retailPrice": 36
     */

    private int id;
    private String name;
    private String brief;
    private String picUrl;
    private boolean isNew;
    private boolean isHot;
    private int counterPrice;
    private int retailPrice;

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

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public void setCounterPrice(int counterPrice) {
        this.counterPrice = counterPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
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

    public boolean isNew() {
        return isNew;
    }

    public boolean isHot() {
        return isHot;
    }

    public int getCounterPrice() {
        return counterPrice;
    }

    public int getRetailPrice() {
        return retailPrice;
    }
}
