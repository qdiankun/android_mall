package com.me.slone.mall.http.response.account;

/**
 * Author：diankun
 * Time：20-11-16 上午11:06
 * Description:
 */
public class UserInfo {

    private String nickName;
    private String avatarUrl;

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
