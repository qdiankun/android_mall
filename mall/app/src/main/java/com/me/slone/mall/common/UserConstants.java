package com.me.slone.mall.common;

import android.text.TextUtils;

/**
 * Author：diankun
 * Time：20-11-16 上午10:46
 * Description:
 */
public class UserConstants {

    //user name
    public static String userName = "";
    //user uid
    public static String userId = "";
    //nickName
    public static String nickName = "";
    //avatar
    public static String avatar = "";
    //sex
    public static String sex = "";
    //user token
    public static String token = "";
    //user phone
    public static String phone = "";

    public static void clear() {
        userId = "";
        nickName = "";
        avatar = "";
        sex = "";
        token = "";
        phone = "";
        userName = "";
    }

    public static boolean isLogin(){
        return !TextUtils.isEmpty(token);
    }

}
