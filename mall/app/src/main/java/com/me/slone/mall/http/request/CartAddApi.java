package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-25 下午3:48
 * Description:加入购物车
 */
public class CartAddApi implements IRequestApi {

    /**
     *  { goodsId: xxx, productId: xxx, number: xxx }
     */
    private int goodsId;
    private int productId;
    private int number;


    @Override
    public String getApi() {
        return "cart/add";
    }

    public CartAddApi setGoodsId(int goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public CartAddApi setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public CartAddApi setNumber(int number) {
        this.number = number;
        return this;
    }
}
