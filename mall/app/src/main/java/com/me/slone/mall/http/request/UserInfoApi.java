package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-30 下午3:51
 * Description:
 */
public class UserInfoApi implements IRequestApi {
    @Override
    public String getApi() {
        return "auth/info";
    }
}
