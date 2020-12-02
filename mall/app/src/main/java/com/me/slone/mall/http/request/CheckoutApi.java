package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-12-2 上午11:11
 * Description:
 */
public class CheckoutApi implements IRequestApi {

    /**
     *  userId    用户ID
     *  cartId    购物车商品ID：
     *                  如果购物车商品ID是空，则下单当前用户所有购物车商品；
     *                  如果购物车商品ID非空，则只下单当前购物车商品。
     *  addressId 收货地址ID：
     *                  如果收货地址ID是空，则查询当前用户的默认地址。
     *  couponId  优惠券ID：
     *                  如果优惠券ID是空，则自动选择合适的优惠券。
     */
    private int cartId;
    private int addressId;
    private int couponId;
    private int userCouponId;
    private int grouponRulesId;

    @Override
    public String getApi() {
        return "cart/checkout";
    }

    public CheckoutApi setCartId(int cartId) {
        this.cartId = cartId;
        return this;
    }

    public CheckoutApi setAddressId(int addressId) {
        this.addressId = addressId;
        return this;
    }

    public CheckoutApi setCouponId(int couponId) {
        this.couponId = couponId;
        return this;
    }

    public CheckoutApi setUserCouponId(int userCouponId) {
        this.userCouponId = userCouponId;
        return this;
    }

    public CheckoutApi setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
        return this;
    }
}
