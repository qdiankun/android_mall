package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.goods.NewGoodsBean;

/**
 * Author：diankun
 * Time：20-11-3 上午11:23
 * Description:新品首发
 */
public class NewGoodsAdapter extends MyAdapter<NewGoodsBean> {

    public NewGoodsAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder {

        private ImageView goodsIv;
        private TextView titleIv, priceTv;

        private ViewHolder() {
            super(R.layout.newgoods_item);

        }


        @Override
        public void onBindView(int position) {
            goodsIv = (ImageView) findViewById(R.id.iv_goods);
            titleIv = (TextView) findViewById(R.id.tv_title);
            priceTv = (TextView) findViewById(R.id.tv_price);

            NewGoodsBean newGoodsBean = getItem(position);
            titleIv.setText(newGoodsBean.getName());
            priceTv.setText("¥ "+newGoodsBean.getRetailPrice());
            GlideApp.with(getContext())
                    .load(newGoodsBean.getPicUrl())
                    .into(goodsIv);
        }
    }

}
