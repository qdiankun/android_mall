package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-25 下午3:48
 * Description:加入购物车
 */
public class GoodCountApi implements IRequestApi {

    @Override
    public String getApi() {
        return "cart/goodscount";
    }


}
