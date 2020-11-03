package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.goods.GroupBean;
import com.me.slone.mall.http.response.goods.HotGoodsBean;

/**
 * Author：diankun
 * Time：20-11-3 上午10:34
 * Description: 团购
 */
public class HotGoodsAdapter extends MyAdapter<HotGoodsBean> {

    public HotGoodsAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder {

        private ImageView goodsIv;
        private TextView nameTv, briefTv, priceTv;

        public ViewHolder() {
            super(R.layout.hotgood_item);
        }

        @Override
        public void onBindView(int position) {
            goodsIv = (ImageView) findViewById(R.id.iv_goods);
            nameTv = (TextView) findViewById(R.id.tv_name);
            briefTv = (TextView) findViewById(R.id.tv_desc);
            priceTv = (TextView) findViewById(R.id.tv_price);

            HotGoodsBean hotGoodsBean = getItem(position);
            nameTv.setText(hotGoodsBean.getName());
            briefTv.setText(hotGoodsBean.getBrief());
            priceTv.setText(" ¥ " + hotGoodsBean.getRetailPrice());
            GlideApp.with(getContext())
                    .load(hotGoodsBean.getPicUrl())
                    .into(goodsIv);
        }
    }
}
