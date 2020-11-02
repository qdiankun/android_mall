package com.me.slone.mall.http.response.goods;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-2 上午11:32
 * Description:
 */
public class FloorGoodsBean {

    private String name;
    private List<GoodsBean> goodsList;

    public void setName(String name) {
        this.name = name;
    }

    public void setGoodsList(List<GoodsBean> goodsList) {
        this.goodsList = goodsList;
    }

    public String getName() {
        return name;
    }

    public List<GoodsBean> getGoodsList() {
        return goodsList;
    }
}
