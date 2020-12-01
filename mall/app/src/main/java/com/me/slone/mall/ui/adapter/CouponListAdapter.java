package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
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
public class CouponListAdapter extends MyAdapter<CouponItemBean> {

    public CouponListAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder{

        private TextView priceTv, descTv,nameTv,timeTv;

        public ViewHolder() {
            super(R.layout.couponlist_item);
        }

        @Override
        public void onBindView(int position) {
            priceTv = (TextView) findViewById(R.id.tv_price);
            descTv = (TextView) findViewById(R.id.tv_desc);
            nameTv = (TextView) findViewById(R.id.tv_name);
            timeTv = (TextView) findViewById(R.id.tv_time);

            CouponItemBean couponItemBean = getItem(position);
            priceTv.setText("¥ "+couponItemBean.getDiscount()+" 元");
            descTv.setText(couponItemBean.getDesc()+"-"+couponItemBean.getTag());
            nameTv.setText(couponItemBean.getName());
            timeTv.setText("有效期: 至 "+couponItemBean.getEndTime());
        }
    }

}
