package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-12-4 下午4:05
 * Description:
 */
public class OrderListApi implements IRequestApi {

    //显示类型，如果是0则是全部订单
    private int showType;
    //分页页数
    private int page;
    //分页大小
    private int limit;
    //排序字段
    private String sort;
    //排序方式
    private String order;

    @Override
    public String getApi() {
        return "order/list";
    }

    public OrderListApi setShowType(int showType) {
        this.showType = showType;
        return this;
    }

    public OrderListApi setPage(int page) {
        this.page = page;
        return this;
    }

    public OrderListApi setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public OrderListApi setSort(String sort) {
        this.sort = sort;
        return this;
    }

    public OrderListApi setOrder(String order) {
        this.order = order;
        return this;
    }
}
