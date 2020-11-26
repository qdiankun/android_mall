package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-25 下午3:48
 * Description:
 */
public class CartUpdateApi implements IRequestApi {

    /**
     *   { id: xxx, goodsId: xxx, productId: xxx, number: xxx }
     */
    private int id;
    private int goodsId;
    private int productId;
    private int number;


    @Override
    public String getApi() {
        return "cart/update";
    }

    public CartUpdateApi setId(int id) {
        this.id = id;
        return this;
    }

    public CartUpdateApi setGoodsId(int goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public CartUpdateApi setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public CartUpdateApi setNumber(int number) {
        this.number = number;
        return this;
    }
}
