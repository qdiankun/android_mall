package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-17 上午10:17
 * Description:
 */
public class GoodCategoryApi implements IRequestApi {

    @Override
    public String getApi() {
        return "catalog/all";
    }

}
