package com.me.slone.mall.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.hjq.base.BaseAdapter;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.OrderCancelApi;
import com.me.slone.mall.http.request.OrderDeleteApi;
import com.me.slone.mall.http.request.OrderListApi;
import com.me.slone.mall.http.response.order.OrderBean;
import com.me.slone.mall.http.response.order.OrderItemBean;
import com.me.slone.mall.other.DividerGridItemDecoration;
import com.me.slone.mall.ui.activity.OrderActivity;
import com.me.slone.mall.ui.adapter.OrderAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：diankun
 * Time：20-12-4 下午4:09
 * Description:
 */
public class OrderListFragment extends MyFragment<OrderActivity> {

    private RecyclerView mOrderRv;
    private OrderAdapter mOrderAdapter;
    private List<OrderItemBean> mOrderItemBeans = new ArrayList<>();
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
        Drawable verticalLine = getResources().getDrawable(R.drawable.divider_grid_gray_bg);
        DividerGridItemDecoration dividerItemDecoration = new DividerGridItemDecoration(verticalLine);
        mOrderRv.addItemDecoration(dividerItemDecoration);
        mOrderAdapter = new OrderAdapter(getContext());
        mOrderAdapter.setData(mOrderItemBeans);
        mOrderAdapter.setOnChildClickListener(R.id.btn_order_cancel, (recyclerView, childView, position) -> {
            OrderItemBean orderItemBean = mOrderItemBeans.get(position);
            cancelOrder(orderItemBean.getId());
        });
        mOrderAdapter.setOnChildClickListener(R.id.btn_order_delete, (recyclerView, childView, position) -> {
            OrderItemBean orderItemBean = mOrderItemBeans.get(position);
            deleteOrder(orderItemBean.getId());
        });
        mOrderRv.setAdapter(mOrderAdapter);
    }

    private void deleteOrder(int orderId) {
        toast("delete " + orderId);
        EasyHttp.post(this)
                .api(new OrderDeleteApi().setOrderId(orderId))
                .request(new HttpCallback<HttpData<Void>>(this) {
                    @Override
                    public void onSucceed(HttpData<Void> result) {
                        toast("删除订单成功 ");
                        getOrders();
                    }
                });
    }

    private void cancelOrder(int orderId) {
        EasyHttp.post(this)
                .api(new OrderCancelApi().setOrderId(orderId))
                .request(new HttpCallback<HttpData<Void>>(this) {
                    @Override
                    public void onSucceed(HttpData<Void> result) {
                        toast("取消订单成功 ");
                        getOrders();
                    }
                });
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
                .request(new HttpCallback<HttpData<OrderBean>>(this) {
                    @Override
                    public void onSucceed(HttpData<OrderBean> result) {
                        //super.onSucceed(result);
                        if (result == null) {
                            return;
                        }
                        refreshOrderList(result.getData());
                    }
                });
    }

    private void refreshOrderList(OrderBean data) {
        if (data == null || data.getList() == null) {
            return;
        }
        mOrderItemBeans.clear();
        mOrderItemBeans.addAll(data.getList());
        mOrderAdapter.notifyDataSetChanged();
    }
}
