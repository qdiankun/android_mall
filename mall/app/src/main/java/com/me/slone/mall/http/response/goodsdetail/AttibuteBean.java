package com.me.slone.mall.http.response.goodsdetail;

/**
 * Author：diankun
 * Time：20-11-5 下午2:44
 * Description:规格
 */
public class AttibuteBean {

    /**
     * "id": 259,
     * "goodsId": 1057036,
     * "attribute": "尺寸",
     * "value": "45*45cm",
     * "addTime": "2018-02-01 00:00:00",
     * "updateTime": "2018-02-01 00:00:00",
     * "deleted": false
     */

    private int id;
    private int goodsId;
    private String attribute;
    private String value;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public int getId() {
        return id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getValue() {
        return value;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setValue(String value) {
        this.value = value;
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
}
