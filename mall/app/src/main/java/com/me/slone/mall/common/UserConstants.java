package com.me.slone.mall.common;

import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;

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

        SPUtils.getInstance().remove(Constants.SP_KEY_TOKEN);
    }

    public static boolean isLogin(){
        return !TextUtils.isEmpty(token);
    }

}
