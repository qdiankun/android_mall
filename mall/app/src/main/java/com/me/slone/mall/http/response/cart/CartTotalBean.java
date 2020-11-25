package com.me.slone.mall.http.response.cart;

/**
 * Author：diankun
 * Time：20-11-24 下午4:14
 * Description:
 */
public class CartTotalBean {

    private int goodsCount;
    private int checkedGoodsCount;
    private int goodsAmount;
    private int checkedGoodsAmount;

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public void setCheckedGoodsCount(int checkedGoodsCount) {
        this.checkedGoodsCount = checkedGoodsCount;
    }

    public void setGoodsAmount(int goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public void setCheckedGoodsAmount(int checkedGoodsAmount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public int getCheckedGoodsCount() {
        return checkedGoodsCount;
    }

    public int getGoodsAmount() {
        return goodsAmount;
    }

    public int getCheckedGoodsAmount() {
        return checkedGoodsAmount;
    }
}
