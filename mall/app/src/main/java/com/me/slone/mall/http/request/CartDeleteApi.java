package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-25 下午3:48
 * Description: 删除购物车
 */
public class CartDeleteApi implements IRequestApi {

    /**
     * { productIds: xxx }
     */
    private List<Integer> productIds;


    @Override
    public String getApi() {
        return "cart/delete";
    }


    public CartDeleteApi setProductId(List<Integer> productIds) {
        this.productIds = productIds;
        return this;
    }

}
