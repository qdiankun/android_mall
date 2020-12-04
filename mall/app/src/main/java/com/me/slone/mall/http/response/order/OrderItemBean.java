package com.me.slone.mall.http.response.order;

import java.util.List;

/**
 * Author：diankun
 * Time：20-12-4 下午5:22
 * Description:
 */
public class OrderItemBean {

    /**
     * {
     * "orderStatusText": "已取消(系统)",
     * "aftersaleStatus": 0,
     * "isGroupin": false,
     * "orderSn": "20201204498285",
     * "actualPrice": 77,
     * "goodsList": [
     * {
     * "number": 1,
     * "picUrl": "http://yanxuan.nosdn.127.net/1e7e392b6fc9da99dc112197b7444eec.png",
     * "price": 69,
     * "id": 17,
     * "goodsName": "宠物合金钢安全除菌指甲",
     * "specifications": [
     * "标准"
     * ]
     * }
     * ],
     * "id": 12,
     * "handleOption": {
     * "cancel": false,
     * "delete": true,
     * "pay": false,
     * "comment": false,
     * "confirm": false,
     * "refund": false,
     * "rebuy": false,
     * "aftersale": false
     * }
     * },
     */

    private String orderStatusText;
    private int aftersaleStatus;
    private boolean isGroupin;
    private String orderSn;
    private float actualPrice;
    private List<GoodItemBean> goodsList;
    private int id;
    private HandleOptionBean handleOption;

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public void setAftersaleStatus(int aftersaleStatus) {
        this.aftersaleStatus = aftersaleStatus;
    }

    public void setGroupin(boolean groupin) {
        isGroupin = groupin;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public void setActualPrice(float actualPrice) {
        this.actualPrice = actualPrice;
    }

    public void setGoodsList(List<GoodItemBean> goodsList) {
        this.goodsList = goodsList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHandleOption(HandleOptionBean handleOption) {
        this.handleOption = handleOption;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public int getAftersaleStatus() {
        return aftersaleStatus;
    }

    public boolean isGroupin() {
        return isGroupin;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public float getActualPrice() {
        return actualPrice;
    }

    public List<GoodItemBean> getGoodsList() {
        return goodsList;
    }

    public int getId() {
        return id;
    }

    public HandleOptionBean getHandleOption() {
        return handleOption;
    }
}
