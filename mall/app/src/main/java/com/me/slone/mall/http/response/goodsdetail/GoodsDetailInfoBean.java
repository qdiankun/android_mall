package com.me.slone.mall.http.response.goodsdetail;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-5 下午2:38
 * Description:
 */
public class GoodsDetailInfoBean {

    /**
     * "id": 1109005,
     * "goodsSn": "1109005",
     * "name": "方圆木钟",
     * "categoryId": 1011004,
     * "brandId": 0,
     * "gallery": [
     * "http://yanxuan.nosdn.127.net/fc5bf833a02a3be40e3e396a1c5a9c13.jpg",
     * "http://yanxuan.nosdn.127.net/43870fe7ec3c7186fb093ab50d94fa3a.jpg",
     * "http://yanxuan.nosdn.127.net/66ac578985180b614c88fda44a2eb26b.jpg",
     * "http://yanxuan.nosdn.127.net/afcd8c99f588072f1ad755762294dca1.jpg"
     * ],
     * "keywords": "",r
     * "brief": "坚硬榉木，实木雕刻",
     * "isOnSale": true,
     * "sortOrder": 12,
     * "picUrl": "http://yanxuan.nosdn.127.net/7f508253f65733c7b2af52dd3943ee28.png",
     * "shareUrl": "",
     * "isNew": false,
     * "isHot": false,
     * "unit": "件",
     * "counterPrice": 99,
     * "retailPrice": 79,
     * "addTime": "2018-02-01 00:00:00",
     * "updateTime": "2018-02-01 00:00:00",
     * "deleted": false,
     * "detail": ""
     */

    private int id;
    private String goodsSn;
    private String name;
    private int categoryId;
    private int brandId;
    private List<String> gallery;
    private String keywords;
    private String brief;
    private boolean isOnSale;
    private int sortOrder;
    private String picUrl;
    private String shareUrl;
    private boolean isNew;
    private boolean isHot;
    private String unit;
    private int counterPrice;
    private int retailPrice;
    private String addTime;
    private String updateTime;
    private boolean deleted;
    private String detail;

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCounterPrice(int counterPrice) {
        this.counterPrice = counterPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
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

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getBrief() {
        return brief;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public boolean isNew() {
        return isNew;
    }

    public boolean isHot() {
        return isHot;
    }

    public String getUnit() {
        return unit;
    }

    public int getCounterPrice() {
        return counterPrice;
    }

    public int getRetailPrice() {
        return retailPrice;
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

    public String getDetail() {
        return detail;
    }
}
