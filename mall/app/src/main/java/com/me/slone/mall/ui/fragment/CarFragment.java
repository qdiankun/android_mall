package com.me.slone.mall.ui.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.bar.TitleBar;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.common.UserConstants;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.CartCheckApi;
import com.me.slone.mall.http.request.CartDeleteApi;
import com.me.slone.mall.http.request.CartListApi;
import com.me.slone.mall.http.request.CartUpdateApi;
import com.me.slone.mall.http.response.cart.CartBean;
import com.me.slone.mall.http.response.cart.CartListBean;
import com.me.slone.mall.ui.activity.CheckoutActivity;
import com.me.slone.mall.ui.activity.HomeActivity;
import com.me.slone.mall.ui.activity.LoginActivity;
import com.me.slone.mall.ui.adapter.CartListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：diankun
 * Time：20-10-30 下午2:53
 * Description: 购物车
 */
public class CarFragment extends MyFragment<HomeActivity> {

    private TitleBar mTitleBar;
    private TextView mPriceTv, mDeleteTv, mOrderEditTv, mOrderTv;
    private LinearLayout mNotLoginLl;
    private AppCompatButton mLoginBtn;
    private RecyclerView mCartRv;
    private RelativeLayout mOrderRl;
    private CartListAdapter mCartListAdapter;
    private List<CartBean> mCartBeansList = new ArrayList<>();
    private Page mPage = Page.MODIFY;
    //编辑数量
    private boolean updateCart;

    private enum Page {
        MODIFY, FINISH
    }

    public static CarFragment newInstance() {
        return new CarFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.car_fragment;
    }

    @Override
    protected void initView() {
        mTitleBar = findViewById(R.id.titlebar);
        mNotLoginLl = findViewById(R.id.notlogin);
        mLoginBtn = findViewById(R.id.btn_login_commit);
        mCartRv = findViewById(R.id.ll_cartlist);
        mPriceTv = findViewById(R.id.tv_cart_price);
        mDeleteTv = findViewById(R.id.tv_deleteall);
        mOrderEditTv = findViewById(R.id.tv_add_order);
        mOrderTv = findViewById(R.id.tv_take_order);
        mOrderRl = findViewById(R.id.rl_order);
        mOrderEditTv.setVisibility(View.GONE);
        if (!UserConstants.isLogin()) {
            mNotLoginLl.setVisibility(View.VISIBLE);
        }
        setOnClickListener(mLoginBtn, mOrderTv, mDeleteTv);
        mCartListAdapter = new CartListAdapter(getContext());
        mCartListAdapter.setData(mCartBeansList);
        mCartListAdapter.setOnChildClickListener(R.id.cb_select, (recyclerView, childView, position) -> {
            CheckBox checkBox = (CheckBox) childView;
            CartBean cartBean = mCartBeansList.get(position);
            checkCart(checkBox.isChecked(), cartBean);
        });
        mCartListAdapter.setOnChildClickListener(R.id.ll_delete, (recyclerView, childView, position) -> {
            //toast("删除-" + position);
            List<Integer> productIds = new ArrayList<>();
            productIds.add(mCartBeansList.get(position).getProductId());
            deleteCart(productIds);
        });
        mCartListAdapter.setCartListAmountListener((view, amount, position) -> {
            updateCart(amount, mCartBeansList.get(position));
        });
        mCartRv.setAdapter(mCartListAdapter);
    }

    private void updateCart(int amount, CartBean cartBean) {
        updateCart = true;
        EasyHttp.post(this)
                .api(new CartUpdateApi()
                        .setNumber(amount)
                        .setId(cartBean.getId())
                        .setGoodsId(cartBean.getGoodsId())
                        .setProductId(cartBean.getProductId()))
                .request(new HttpCallback<HttpData<Void>>(this) {

                    @Override
                    public void onSucceed(HttpData<Void> data) {
                        cartBean.setNumber(amount);
                        getCartList();
                    }
                });
    }

    private void deleteCart(List<Integer> productIds) {
        EasyHttp.post(this)
                .api(new CartDeleteApi()
                        .setProductId(productIds))
                .request(new HttpCallback<HttpData<CartListBean>>(this) {

                    @Override
                    public void onSucceed(HttpData<CartListBean> data) {
                        super.onSucceed(data);
                        CartListBean cartListBean = data.getData();
                        refreshCartList(cartListBean);
                    }

                });
    }

    @Override
    public void onRightClick(View v) {
        if (mPage == Page.MODIFY) {
            mPage = Page.FINISH;
            mTitleBar.setRightTitle("完成");
            mCartListAdapter.setEditCart(true);
            mOrderTv.setVisibility(View.GONE);
            mDeleteTv.setVisibility(View.VISIBLE);
        } else if (mPage == Page.FINISH) {
            mPage = Page.MODIFY;
            mTitleBar.setRightTitle("编辑");
            mCartListAdapter.setEditCart(false);
            mOrderTv.setVisibility(View.VISIBLE);
            mDeleteTv.setVisibility(View.GONE);
        }
    }

    private void checkCart(boolean checked, CartBean checkCart) {
        List<Integer> checkedProductIds = new ArrayList<>();
        List<Integer> unCheckedProductIds = new ArrayList<>();
        for (CartBean cart : mCartBeansList) {
            if (cart.getProductId() == checkCart.getProductId()) {
                if (checked) {
                    checkedProductIds.add(checkCart.getProductId());
                } else {
                    unCheckedProductIds.add(checkCart.getProductId());
                }
            } else {
                if (cart.isChecked()) {
                    checkedProductIds.add(cart.getProductId());
                } else {
                    unCheckedProductIds.add(cart.getProductId());
                }
            }
        }
        if (!checkedProductIds.isEmpty()) {
            updateCart = true;
            EasyHttp.post(this)
                    .api(new CartCheckApi()
                            .setProductIds(checkedProductIds)
                            .setIsChecked(1))
                    .request(new HttpCallback<HttpData<CartListBean>>(this) {

                        @Override
                        public void onSucceed(HttpData<CartListBean> data) {
                            super.onSucceed(data);
                            CartListBean cartListBean = data.getData();
                            refreshCartList(cartListBean);
                        }

                    });
        }
        if (!unCheckedProductIds.isEmpty()) {
            updateCart = true;
            EasyHttp.post(this)
                    .api(new CartCheckApi()
                            .setProductIds(unCheckedProductIds)
                            .setIsChecked(0))
                    .request(new HttpCallback<HttpData<CartListBean>>(this) {

                        @Override
                        public void onSucceed(HttpData<CartListBean> data) {
                            super.onSucceed(data);
                            CartListBean cartListBean = data.getData();
                            refreshCartList(cartListBean);
                        }
                    });
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (UserConstants.isLogin()) {
            updateCart = false;
            getCartList();
        }
    }

    @Override
    protected void initData() {

    }

    private void getCartList() {
        EasyHttp.get(this)
                .api(new CartListApi())
                .request(new HttpCallback<HttpData<CartListBean>>(this) {

                    @Override
                    public void onSucceed(HttpData<CartListBean> data) {
                        CartListBean cartListBean = data.getData();
                        refreshCartList(cartListBean);
                    }
                });
    }

    private void refreshCartList(CartListBean cartListBean) {
        if (cartListBean == null) {
            return;
        }
        if (cartListBean.getCartList() == null || cartListBean.getCartList().isEmpty()) {
            mTitleBar.setRightTitle("");
            mOrderRl.setVisibility(View.GONE);
        } else {
            mOrderRl.setVisibility(View.VISIBLE);
        }
        if (updateCart) {
            mTitleBar.setRightTitle("完成");
        } else {
            mTitleBar.setRightTitle("编辑");
        }
        mPriceTv.setText("¥ " + cartListBean.getCartTotal().getCheckedGoodsAmount());
        mCartBeansList.clear();
        mCartBeansList.addAll(cartListBean.getCartList());
        mCartListAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    @Override
    public void onClick(View v) {
        if (mLoginBtn == v) {
            startActivity(LoginActivity.class);
        } else if (mDeleteTv == v) {
            deleteAllCheck();
        } else if (mOrderTv == v) {
            startActivity(CheckoutActivity.class);
        }
    }

    private void deleteAllCheck() {
        List<Integer> checkedProductIds = new ArrayList<>();
        for (CartBean cart : mCartBeansList) {
            if (cart.isChecked()) {
                checkedProductIds.add(cart.getProductId());
            }
        }
        deleteCart(checkedProductIds);
    }
}
