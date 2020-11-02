package com.me.slone.mall.http.response.goods;

/**
 * Author：diankun
 * Time：20-11-2 上午11:29
 * Description:
 */
public class HotGoodsBean {

    /**
     * "id": 1152008,
     * "name": "魔兽世界 部落 护腕 一只",
     * "brief": "吸汗、舒适、弹性、防护、耐用",
     * "picUrl": "http://yanxuan.nosdn.127.net/203cb83d93606865e3ddde57b69b9e9a.png",
     * "isNew": false,
     * "isHot": true,
     * "counterPrice": 49,
     * "retailPrice": 29
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
