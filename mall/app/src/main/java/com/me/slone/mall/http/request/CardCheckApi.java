package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-25 下午3:48
 * Description:
 */
public class CardCheckApi implements IRequestApi {

    /**
     *  { productIds: xxx, isChecked: 1/0 }
     */
    private List<Integer> productIds;
    private int isChecked;


    @Override
    public String getApi() {
        return "cart/checked";
    }

    public CardCheckApi setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
        return this;
    }

    public CardCheckApi setIsChecked(int isChecked) {
        this.isChecked = isChecked;
        return this;
    }
}
