package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-25 下午3:48
 * Description: 删除购物车
 */
public class CartDeleteApi implements IRequestApi {

    /**
     * { productIds: xxx }
     */
    private int productIds;


    @Override
    public String getApi() {
        return "cart/update";
    }


    public CartDeleteApi setProductId(int productIds) {
        this.productIds = productIds;
        return this;
    }

}
