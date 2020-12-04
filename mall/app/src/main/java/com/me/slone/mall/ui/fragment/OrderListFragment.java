package com.me.slone.mall.ui.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.OrderListApi;
import com.me.slone.mall.http.response.order.OrderBean;
import com.me.slone.mall.ui.activity.OrderActivity;

/**
 * Author：diankun
 * Time：20-12-4 下午4:09
 * Description:
 */
public class OrderListFragment extends MyFragment<OrderActivity> {

    private RecyclerView mOrderRv;
    private int showType;
    private static String ARG_SHOWTYPE = "arg_showtype";

    public static OrderListFragment getInstance(int showType) {
        OrderListFragment orderListFragment = new OrderListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SHOWTYPE, showType);
        orderListFragment.setArguments(bundle);
        return orderListFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.orderlist_fragment;
    }

    @Override
    protected void initView() {
        mOrderRv = findViewById(R.id.rv_order);
    }

    @Override
    protected void initData() {
        showType = getArguments().getInt(ARG_SHOWTYPE);
        getOrders();
    }

    private void getOrders() {
        EasyHttp.get(this)
                .api(new OrderListApi()
                .setShowType(showType))
                .request(new HttpCallback<HttpData<OrderBean>>(this){
                    @Override
                    public void onSucceed(HttpData<OrderBean> result) {
                        super.onSucceed(result);
                    }
                });
    }
}
