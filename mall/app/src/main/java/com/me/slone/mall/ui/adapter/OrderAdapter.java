package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.response.order.GoodItemBean;
import com.me.slone.mall.http.response.order.HandleOptionBean;
import com.me.slone.mall.http.response.order.OrderItemBean;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-3 上午10:34
 * Description: 楼层
 */
public class OrderAdapter extends MyAdapter<OrderItemBean> {

    public OrderAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder {

        private RecyclerView ordersRv;
        private TextView orderNumTv, statusTv, priceTv;
        private LinearLayout orderLl;
        private Button payBtn, cancelBtn, deleteBtn;

        public ViewHolder() {
            super(R.layout.order_item);
        }

        @Override
        public void onBindView(int position) {
            orderLl = (LinearLayout) findViewById(R.id.ll_order);
            ordersRv = (RecyclerView) findViewById(R.id.rv_orderlist);
            orderNumTv = (TextView) findViewById(R.id.tv_order_num);
            statusTv = (TextView) findViewById(R.id.tv_status);
            priceTv = (TextView) findViewById(R.id.tv_price);
            payBtn = (Button) findViewById(R.id.btn_order_pay);
            cancelBtn = (Button) findViewById(R.id.btn_order_cancel);
            deleteBtn = (Button) findViewById(R.id.btn_order_delete);

            OrderItemBean orderItemBean = getItem(position);
            List<GoodItemBean> orderItems = orderItemBean.getGoodsList();
            orderNumTv.setText("订单编号：" + orderItemBean.getOrderSn());
            HandleOptionBean handleOption = orderItemBean.getHandleOption();
            statusTv.setText(orderItemBean.getOrderStatusText());
            if (handleOption.isPay() && handleOption.isCancel()) {
                payBtn.setVisibility(View.VISIBLE);
                cancelBtn.setVisibility(View.VISIBLE);
                deleteBtn.setVisibility(View.GONE);
            } else {
                deleteBtn.setVisibility(View.VISIBLE);
                payBtn.setVisibility(View.GONE);
                cancelBtn.setVisibility(View.GONE);
            }
            priceTv.setText("合计: ¥ " + orderItemBean.getActualPrice());
            if (orderItems != null && !orderItems.isEmpty()) {
                orderLl.setVisibility(View.VISIBLE);
                OrderChildAdapter orderChildAdapter = new OrderChildAdapter(getContext());
                orderChildAdapter.setData(orderItemBean.getGoodsList());
                ordersRv.setAdapter(orderChildAdapter);
            } else {
                orderLl.setVisibility(View.GONE);
            }

        }
    }
}
