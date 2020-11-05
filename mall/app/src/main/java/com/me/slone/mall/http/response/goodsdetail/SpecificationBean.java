package com.me.slone.mall.http.response.goodsdetail;

/**
 * Author：diankun
 * Time：20-11-5 下午2:48
 * Description:
 */
public class SpecificationBean {

    /**
     * "id": 70,
     * "goodsId": 1057036,
     * "specification": "规格",
     * "value": "标准",
     * "picUrl": "",
     * "addTime": "2018-02-01 00:00:00",
     * "updateTime": "2018-02-01 00:00:00",
     * "deleted": false
     */

    private int id;
    private int goodsId;
    private String specification;
    private String value;
    private String picUrl;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setValue(String value) {
        this.value = value;
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

    public int getGoodsId() {
        return goodsId;
    }

    public String getSpecification() {
        return specification;
    }

    public String getValue() {
        return value;
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
