package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-16 上午11:01
 * Description:登陆接口
 */
public class LoginApi implements IRequestApi {
    @Override
    public String getApi() {
        return "auth/login";
    }

    /** 用户ｉ名 */
    private String username;
    /** 登录密码 */
    private String password;

    public LoginApi setUsername(String username) {
        this.username = username;
        return this;
    }

    public LoginApi setPassword(String password) {
        this.password = password;
        return this;
    }
}
