package com.me.slone.mall.common;

/**
 * Author：diankun
 * Time：20-11-16 上午10:29
 * Description: 共用变量
 */
public class Constants {

    //spkey
    public static final String SP_KEY_USERNAME = "sp_key_username";
    public static final String SP_KEY_REMEBERPASS = "sp_key_remeberpass";
    public static final String SP_KEY_USERID = "sp_key_userid";
    public static final String SP_KEY_NICKNAME = "sp_key_nickname";
    public static final String SP_KEY_AVATAR = "sp_key_avatar";
    public static final String SP_KEY_SEX = "sp_key_sex";
    public static final String SP_KEY_TOKEN = "sp_key_token";

    public static final int REQUEST_ADDRESS_LIST = 1001;
    public static final int RESULT_ADDRESS_ADD = 1002;
    public static final int RESULT_ADDRESS_UPDATE = 1003;

    public static final int COUPON_STATUS_UNUSERD = 0;
    public static final int COUPON_STATUS_USED = 1;
    public static final int COUPON_STATUS_EXPIRED = 2;

    /**
     *                 0，全部订单；
     *                 1，待付款；
     *                 2，待发货；
     *                 3，待收货；
     *                 4，待评价。
     */
    public static final int ORDER_ALL = 0;
    public static final int ORDER_TOPAY = 1;
    public static final int ORDER_TOSEND = 2;
    public static final int ORDER_TORECEIVE = 3;
    public static final int ORDER_TOJUDGE = 4;

}
