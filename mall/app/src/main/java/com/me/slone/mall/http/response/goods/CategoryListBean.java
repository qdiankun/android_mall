package com.me.slone.mall.http.response.goods;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-17 下午3:00
 * Description:
 */
public class CategoryListBean {

    /**
     * total": 39,
     * "pages": 4,
     * "limit": 10,
     * "page": 1,
     * "list": [
     * {
     * "id": 1057036,
     * "name": "日式纯色水洗亚麻抱枕",
     * "brief": "水洗亚麻，透气亲肤",
     * "picUrl": "http://yanxuan.nosdn.127.net/8a9ee5ba08929cc9e40b973607d2f633.png",
     * "isNew": false,
     * "isHot": false,
     * "counterPrice": 99,
     * "retailPrice": 79
     * },
     * ]
     */

    private int total;
    private int pages;
    private int limit;
    private int page;
    private List<NewGoodsBean> list;

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

    public void setList(List<NewGoodsBean> list) {
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

    public List<NewGoodsBean> getList() {
        return list;
    }
}
