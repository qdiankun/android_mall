package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-16 下午1:38
 * Description:注册
 */
public class RegisterApi implements IRequestApi {

    @Override
    public String getApi() {
        return "auth/register";
    }

    private String username;
    private String password;
    private String mobile;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public RegisterApi setUsername(String username) {
        this.username = username;
        return this;
    }

    public RegisterApi setPassword(String password) {
        this.password = password;
        return this;
    }

    public RegisterApi setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
}
