package com.me.slone.mall.http.response.cart;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-24 下午4:19
 * Description:
 */
public class CartListBean {

    private CartTotalBean cartTotal;
    private List<CartBean> cartList;

    public CartTotalBean getCartTotal() {
        return cartTotal;
    }

    public List<CartBean> getCartList() {
        return cartList;
    }

    public void setCartTotal(CartTotalBean cartTotal) {
        this.cartTotal = cartTotal;
    }

    public void setCartList(List<CartBean> cartList) {
        this.cartList = cartList;
    }
}
