package com.me.slone.mall.http.response.cart;

import java.util.List;

/**
 * Author：diankun
 * Time：20-12-2 上午11:37
 * Description:
 */
public class CheckedBean {

    /**
     *         "grouponRulesId": 0,
     *         "actualPrice": 944,
     *         "orderTotalPrice": 944,
     *         "cartId": 0,
     *         "userCouponId": 12,
     *         "couponId": 2,
     *         "goodsTotalPrice": 954,
     *         "addressId": 6,
     *         "grouponPrice": 0,
     *         "checkedAddress": {
     *             "id": 6,
     *             "name": "c++java",
     *             "userId": 6,
     *             "province": "山东省",
     *             "city": "济南市",
     *             "county": "天桥区",
     *             "addressDetail": "小区",
     *             "areaCode": "123456",
     *             "tel": "15262737894",
     *             "isDefault": true,
     *             "addTime": "2020-11-30 14:37:49",
     *             "updateTime": "2020-11-30 15:28:25",
     *             "deleted": false
     *         },
     *         "couponPrice": 10,
     *         "availableCouponLength": 2,
     *         "freightPrice": 0,
     *         "checkedGoodsList": [
     *             {
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
     *             },
     *             {
     *                 "id": 18,
     *                 "userId": 6,
     *                 "goodsId": 1116011,
     *                 "goodsSn": "1116011",
     *                 "goodsName": "蔓越莓曲奇 200克",
     *                 "productId": 167,
     *                 "price": 36,
     *                 "number": 1,
     *                 "specifications": [
     *                     "标准"
     *                 ],
     *                 "checked": true,
     *                 "picUrl": "http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png",
     *                 "addTime": "2020-11-30 15:32:14",
     *                 "updateTime": "2020-12-02 11:07:49",
     *                 "deleted": false
     *             }
     *         ]
     */
    private int grouponRulesId;
    private int actualPrice;
    private int orderTotalPrice;
    private int cartId;
    private int userCouponId;
    private int couponId;
    private int goodsTotalPrice;
    private int addressId;
    private int grouponPrice;
    private CheckedAddress checkedAddress;
    private int couponPrice;
    private int availableCouponLength;
    private int freightPrice;
    private List<CheckedGoodsBean> checkedGoodsList;

    public void setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public void setActualPrice(int actualPrice) {
        this.actualPrice = actualPrice;
    }

    public void setOrderTotalPrice(int orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setUserCouponId(int userCouponId) {
        this.userCouponId = userCouponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public void setGoodsTotalPrice(int goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setGrouponPrice(int grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public void setCheckedAddress(CheckedAddress checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public void setCouponPrice(int couponPrice) {
        this.couponPrice = couponPrice;
    }

    public void setAvailableCouponLength(int availableCouponLength) {
        this.availableCouponLength = availableCouponLength;
    }

    public void setFreightPrice(int freightPrice) {
        this.freightPrice = freightPrice;
    }

    public void setCheckedGoodsList(List<CheckedGoodsBean> checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public int getGrouponRulesId() {
        return grouponRulesId;
    }

    public int getActualPrice() {
        return actualPrice;
    }

    public int getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public int getCartId() {
        return cartId;
    }

    public int getUserCouponId() {
        return userCouponId;
    }

    public int getCouponId() {
        return couponId;
    }

    public int getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public int getGrouponPrice() {
        return grouponPrice;
    }

    public CheckedAddress getCheckedAddress() {
        return checkedAddress;
    }

    public int getCouponPrice() {
        return couponPrice;
    }

    public int getAvailableCouponLength() {
        return availableCouponLength;
    }

    public int getFreightPrice() {
        return freightPrice;
    }

    public List<CheckedGoodsBean> getCheckedGoodsList() {
        return checkedGoodsList;
    }
}
