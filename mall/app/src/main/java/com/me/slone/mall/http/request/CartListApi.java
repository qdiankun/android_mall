package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-24 下午4:06
 * Description:购物车api
 */
public class CartListApi implements IRequestApi {

    private int userId;

    @Override
    public String getApi() {
        return "cart/index";
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
