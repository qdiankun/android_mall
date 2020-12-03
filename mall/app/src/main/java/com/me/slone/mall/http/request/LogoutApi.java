package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-12-3 上午9:42
 * Description:
 */
public class LogoutApi implements IRequestApi {
    @Override
    public String getApi() {
        return "auth/logout";
    }
}
