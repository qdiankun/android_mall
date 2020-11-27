package com.me.slone.mall.ui.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
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
import com.me.slone.mall.http.response.cart.CartBean;
import com.me.slone.mall.http.response.cart.CartListBean;
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
    private CartListAdapter mCartListAdapter;
    private List<CartBean> mCartBeansList = new ArrayList<>();

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
        mOrderEditTv = findViewById(R.id.tv_order_edit);
        mOrderTv = findViewById(R.id.tv_order);
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
        mCartRv.setAdapter(mCartListAdapter);
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
        CharSequence rightTitle = mTitleBar.getRightTitle();
        if ("编辑".equals(rightTitle)) {
            mTitleBar.setRightTitle("完成");
            mCartListAdapter.setEditCart(true);
            mOrderTv.setVisibility(View.GONE);
            mOrderEditTv.setVisibility(View.GONE);
            mDeleteTv.setVisibility(View.VISIBLE);
        } else if ("完成".equals(rightTitle)) {
            mTitleBar.setRightTitle("编辑");
            mCartListAdapter.setEditCart(false);
            mOrderTv.setVisibility(View.VISIBLE);
            mOrderEditTv.setVisibility(View.VISIBLE);
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
    protected void initData() {
        if (UserConstants.isLogin()) {
            getCartList();
        }
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
            return;
        }
        mTitleBar.setRightTitle("编辑");
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
