package com.me.slone.mall.http.response.me;

import java.util.List;

/**
 * Author：diankun
 * Time：20-12-1 上午10:14
 * Description:
 */
public class CouponListBean {

    /**
     * "total": 4,
     * "pages": 1,
     * "limit": 10,
     * "page": 1,
     * "list": [
     * {
     * "id": 10,
     * "cid": 2,
     * "name": "限时满减券",
     * "desc": "全场通用",
     * "tag": "无限制",
     * "min": 99,
     * "discount": 10,
     * "startTime": "2020-12-01 09:34:18",
     * "endTime": "2020-12-11 09:34:18",
     * "available": false
     * },
     * ]
     */

    private int total;
    private int pages;
    private int limit;
    private int page;
    private List<CouponItemBean> list;

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

    public void setList(List<CouponItemBean> list) {
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

    public List<CouponItemBean> getList() {
        return list;
    }
}
