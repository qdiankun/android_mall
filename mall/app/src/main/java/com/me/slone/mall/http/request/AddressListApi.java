package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-30 上午9:59
 * Description:
 */
public class AddressListApi implements IRequestApi {

    @Override
    public String getApi() {
        return "address/list";
    }
}
