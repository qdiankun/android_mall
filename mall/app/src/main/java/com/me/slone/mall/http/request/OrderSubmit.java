package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-12-2 下午1:55
 * Description: 提交订单
 */
public class OrderSubmit implements IRequestApi {

    /**
     * { cartId：xxx, addressId: xxx, couponId: xxx, message: xxx, grouponRulesId: xxx,  grouponLinkId: xxx,userCouponId}
     */
    private int cartId;
    private int addressId;
    private int couponId;
    private String message;
    private int grouponRulesId;
    private int grouponLinkId;
    private int userCouponId;

    @Override
    public String getApi() {
        return "order/submit";
    }

    public OrderSubmit setCartId(int cartId) {
        this.cartId = cartId;
        return this;
    }

    public OrderSubmit setAddressId(int addressId) {
        this.addressId = addressId;
        return this;
    }

    public OrderSubmit setCouponId(int couponId) {
        this.couponId = couponId;
        return this;
    }

    public OrderSubmit setMessage(String message) {
        this.message = message;
        return this;
    }

    public OrderSubmit setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
        return this;
    }

    public OrderSubmit setGrouponLinkId(int grouponLinkId) {
        this.grouponLinkId = grouponLinkId;
        return this;
    }

    public OrderSubmit setUserCouponId(int userCouponId) {
        this.userCouponId = userCouponId;
        return this;
    }
}
