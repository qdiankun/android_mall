package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.response.me.CouponItemBean;

/**
 * Author：diankun
 * Time：20-11-3 下午4:02
 * Description:
 */
public class CouponCheckAdapter extends MyAdapter<CouponItemBean> {

    private int userCouponId;

    public CouponCheckAdapter(@NonNull Context context) {
        super(context);
    }

    public void setUserCouponId(int userCouponId) {
        this.userCouponId = userCouponId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder {

        private TextView priceTv, minTv, nameTv, timeTv, descTv;
        private CheckBox checkCb;

        public ViewHolder() {
            super(R.layout.coupon_checkout_item);
        }

        @Override
        public void onBindView(int position) {
            priceTv = (TextView) findViewById(R.id.tv_price);
            minTv = (TextView) findViewById(R.id.tv_min);
            nameTv = (TextView) findViewById(R.id.tv_name);
            timeTv = (TextView) findViewById(R.id.tv_time);
            descTv = (TextView) findViewById(R.id.tv_desc);
            checkCb = (CheckBox) findViewById(R.id.cb_select);

            CouponItemBean couponItemBean = getItem(position);
            priceTv.setText("¥ " + couponItemBean.getDiscount() + " 元");
            minTv.setText("满" + couponItemBean.getMin() + "元可用");
            nameTv.setText(couponItemBean.getName());
            timeTv.setText("有效期: 至 " + couponItemBean.getEndTime());
            descTv.setText(couponItemBean.getDesc());
            if (couponItemBean.getId() == userCouponId) {
                checkCb.setChecked(true);
            } else {
                checkCb.setChecked(false);
            }
            checkCb.setVisibility(couponItemBean.isAvailable() ? View.VISIBLE : View.GONE);
        }
    }

}
