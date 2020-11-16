package com.me.slone.mall.http.response.account;

/**
 * Author：diankun
 * Time：20-11-16 上午11:05
 * Description:
 */
public class LoginBean {

    private UserInfo userInfo;
    private String token;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public String getToken() {
        return token;
    }
}
