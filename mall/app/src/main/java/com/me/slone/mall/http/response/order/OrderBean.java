package com.me.slone.mall.http.response.order;

import java.util.List;

/**
 * Author：diankun
 * Time：20-12-4 下午5:24
 * Description:
 */
public class OrderBean {

    /**
     * "total": 4,
     * "pages": 1,
     * "limit": 10,
     * "page": 1,
     * "list": [
     * {
     * "orderStatusText": "已取消(系统)",
     * "aftersaleStatus": 0,
     * "isGroupin": false,
     * "orderSn": "20201204498285",
     * "actualPrice": 77,
     * "goodsList": [
     * {
     * "number": 1,
     * "picUrl": "http://yanxuan.nosdn.127.net/1e7e392b6fc9da99dc112197b7444eec.png",
     * "price": 69,
     * "id": 17,
     * "goodsName": "宠物合金钢安全除菌指甲",
     * "specifications": [
     * "标准"
     * ]
     * }
     * ],
     * "id": 12,
     * "handleOption": {
     * "cancel": false,
     * "delete": true,
     * "pay": false,
     * "comment": false,
     * "confirm": false,
     * "refund": false,
     * "rebuy": false,
     * "aftersale": false
     * }
     * },
     * {
     * "orderStatusText": "已取消(系统)",
     * "aftersaleStatus": 0,
     * "isGroupin": false,
     * "orderSn": "20201204944007",
     * "actualPrice": 549,
     * "goodsList": [
     * {
     * "number": 1,
     * "picUrl": "http://yanxuan.nosdn.127.net/a1094a808ffb3a52a6cb13565a283d98.png",
     * "price": 599,
     * "id": 16,
     * "goodsName": "清新趣粉系列居家地毯 青粉拼接",
     * "specifications": [
     * "标准"
     * ]
     * }
     * ],
     * "id": 11,
     * "handleOption": {
     * "cancel": false,
     * "delete": true,
     * "pay": false,
     * "comment": false,
     * "confirm": false,
     * "refund": false,
     * "rebuy": false,
     * "aftersale": false
     * }
     * },
     * {
     * "orderStatusText": "已取消(系统)",
     * "aftersaleStatus": 0,
     * "isGroupin": false,
     * "orderSn": "20201202756632",
     * "actualPrice": 478,
     * "goodsList": [
     * {
     * "number": 1,
     * "picUrl": "http://yanxuan.nosdn.127.net/1e7e392b6fc9da99dc112197b7444eec.png",
     * "price": 69,
     * "id": 4,
     * "goodsName": "宠物合金钢安全除菌指甲",
     * "specifications": [
     * "标准"
     * ]
     * },
     * {
     * "number": 1,
     * "picUrl": "http://yanxuan.nosdn.127.net/615a16e899e01efb780c488df4233f48.png",
     * "price": 459,
     * "id": 5,
     * "goodsName": "Carat钻石 不粘厨具组合",
     * "specifications": [
     * "标准"
     * ]
     * }
     * ],
     * "id": 2,
     * "handleOption": {
     * "cancel": false,
     * "delete": true,
     * "pay": false,
     * "comment": false,
     * "confirm": false,
     * "refund": false,
     * "rebuy": false,
     * "aftersale": false
     * }
     * },
     * {
     * "orderStatusText": "已取消(系统)",
     * "aftersaleStatus": 0,
     * "isGroupin": false,
     * "orderSn": "20201202889797",
     * "actualPrice": 1645,
     * "goodsList": [
     * {
     * "number": 16,
     * "picUrl": "http://yanxuan.nosdn.127.net/1e7e392b6fc9da99dc112197b7444eec.png",
     * "price": 69,
     * "id": 1,
     * "goodsName": "宠物合金钢安全除菌指甲",
     * "specifications": [
     * "标准"
     * ]
     * },
     * {
     * "number": 3,
     * "picUrl": "http://yanxuan.nosdn.127.net/3bd73b7279a83d1cbb50c0e45778e6d6.png",
     * "price": 39,
     * "id": 2,
     * "goodsName": "天然硅胶宠物除毛按摩刷",
     * "specifications": [
     * "标准"
     * ]
     * },
     * {
     * "number": 6,
     * "picUrl": "http://yanxuan.nosdn.127.net/7f508253f65733c7b2af52dd3943ee28.png",
     * "price": 79,
     * "id": 3,
     * "goodsName": "方圆木钟",
     * "specifications": [
     * "标准"
     * ]
     * }
     * ],
     * "id": 1,
     * "handleOption": {
     * "cancel": false,
     * "delete": true,
     * "pay": false,
     * "comment": false,
     * "confirm": false,
     * "refund": false,
     * "rebuy": false,
     * "aftersale": false
     * }
     * }
     * ]
     * }
     */
    private int total;
    private int pages;
    private int limit;
    private int page;
    private List<OrderItemBean> list;

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

    public void setList(List<OrderItemBean> list) {
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

    public List<OrderItemBean> getList() {
        return list;
    }
}
