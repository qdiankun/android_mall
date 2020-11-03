package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.response.goods.CouponBean;

/**
 * Author：diankun
 * Time：20-11-2 下午3:48
 * Description: 优惠券dapter
 */
public class CouponAdapter extends MyAdapter<CouponBean> {

    public CouponAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder {

        private TextView tagTv, discountTv, minTv, nameTv, daysTv, descTv;


        private ViewHolder() {
            super(R.layout.coupon_item);
            tagTv = (TextView) findViewById(R.id.tv_tag);
            discountTv = (TextView) findViewById(R.id.tv_discount);
            minTv = (TextView) findViewById(R.id.tv_min);
            nameTv = (TextView) findViewById(R.id.tv_name);
            daysTv = (TextView) findViewById(R.id.tv_days);
            descTv = (TextView) findViewById(R.id.tv_desc);
        }


        @Override
        public void onBindView(int position) {
            CouponBean couponBean = getItem(position);
            tagTv.setText(couponBean.getTag());
            discountTv.setText(couponBean.getDiscount() + "元");
            minTv.setText("满" + couponBean.getMin() + "元使用");
            nameTv.setText(couponBean.getName());
            daysTv.setText("有效期:" + couponBean.getDays());
            descTv.setText(couponBean.getDesc());
        }
    }
}
