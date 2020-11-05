package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-5 下午3:08
 * Description:商品详情
 */
public class GoodDetailApi implements IRequestApi {

    private  int id;

    @Override
    public String getApi() {
        return "goods/detail";
    }

    public GoodDetailApi setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }
}
