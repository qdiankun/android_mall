package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-12-8 下午2:05
 * Description:
 */
public class OrderDeleteApi implements IRequestApi {

    /**
     * { orderId：xxx }
     */
    private int orderId;


    @Override
    public String getApi() {
        return "order/delete";
    }

    public OrderDeleteApi setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }
}
