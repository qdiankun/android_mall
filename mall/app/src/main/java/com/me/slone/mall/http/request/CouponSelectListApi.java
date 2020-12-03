package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-12-1 上午10:07
 * Description:
 */
public class CouponSelectListApi implements IRequestApi {

    private int cartId;
    private int grouponRulesId ;

    @Override
    public String getApi() {
        return "coupon/selectlist";
    }

    public CouponSelectListApi setCartId(int cartId) {
        this.cartId = cartId;
        return this;
    }

    public CouponSelectListApi setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
        return this;
    }
}
