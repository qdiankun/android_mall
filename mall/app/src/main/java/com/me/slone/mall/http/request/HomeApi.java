package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-2 上午11:15
 * Description: 首页
 */
public class HomeApi implements IRequestApi {

    @Override
    public String getApi() {
        return "home/index";
    }
}
