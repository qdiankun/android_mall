package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.goods.FloorGoodsBean;
import com.me.slone.mall.http.response.goods.NewGoodsBean;
import com.me.slone.mall.http.response.order.GoodItemBean;
import com.me.slone.mall.other.DividerGridItemDecoration;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-3 上午10:34
 * Description: 楼层
 */
public class OrderChildAdapter extends MyAdapter<GoodItemBean> {

    public OrderChildAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder {

        private ImageView goodIv;
        private TextView titleTv, priceTv, countTv;


        public ViewHolder() {
            super(R.layout.orderchild_item);
        }

        @Override
        public void onBindView(int position) {
            goodIv = (ImageView) findViewById(R.id.iv_goods);
            priceTv = (TextView) findViewById(R.id.tv_price);
            titleTv = (TextView) findViewById(R.id.tv_name);
            countTv = (TextView) findViewById(R.id.tv_count);

            GoodItemBean goodItemBean = getItem(position);
            titleTv.setText(goodItemBean.getGoodsName());
            priceTv.setText("" + goodItemBean.getPrice());
            countTv.setText("x" + goodItemBean.getNumber());
            GlideApp.with(getContext())
                    .load(goodItemBean.getPicUrl())
                    .into(goodIv);
        }
    }

}
