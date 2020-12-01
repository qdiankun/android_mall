package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-12-1 上午10:07
 * Description:
 */
public class CouponListApi implements IRequestApi {

    private int status;
    private int page ;
    private int limit;

    @Override
    public String getApi() {
        return "coupon/mylist";
    }

    public CouponListApi setStatus(int status) {
        this.status = status;
        return this;
    }

    public CouponListApi setPage(int page) {
        this.page = page;
        return this;
    }

    public CouponListApi setLimit(int limit) {
        this.limit = limit;
        return this;
    }
}
