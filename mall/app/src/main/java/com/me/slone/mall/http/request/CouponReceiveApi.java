package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-12-1 上午9:32
 * Description:领取优惠券
 */
public class CouponReceiveApi implements IRequestApi {

    // { couponId: xxx }
    private int couponId;

    @Override
    public String getApi() {
        return "coupon/receive";
    }

    public CouponReceiveApi setCouponId(int couponId) {
        this.couponId = couponId;
        return this;
    }
}
