package com.me.slone.mall.http.response.me;

/**
 * Author：diankun
 * Time：20-11-30 下午3:52
 * Description:
 */
public class UserInfo {

    /**
     *         "gender": 0,
     *         "nickName": "slone",
     *         "mobile": "15262737892",
     *         "avatar": "https://yanxuan.nosdn.127.net/80841d741d7fa3073e0ae27bf487339f.jpg?imageView&quality=90&thumbnail=64x64"
     */
    private int gender;
    private String nickName;
    private String mobile;
    private String avatar;

    public int getGender() {
        return gender;
    }

    public String getNickName() {
        return nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
