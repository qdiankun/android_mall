package com.me.slone.mall.http.response.me;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-30 上午11:30
 * Description:
 */
public class AddressListBean {

    private int total;
    private int pages;
    private int limit;
    private int page;
    private List<AddressBean> list;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setList(List<AddressBean> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public int getPages() {
        return pages;
    }

    public int getLimit() {
        return limit;
    }

    public int getPage() {
        return page;
    }

    public List<AddressBean> getList() {
        return list;
    }
}
