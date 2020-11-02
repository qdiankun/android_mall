package com.me.slone.mall.http.model;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2019/12/07
 *    desc   : 统一接口数据结构
 */
public class HttpData<T> {

    /** 返回码 */
    private int errno;
    /** 提示语 */
    private String errmsg;
    /** 数据 */
    private T data;

    public int getErrno() {
        return errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public T getData() {
        return data;
    }
}