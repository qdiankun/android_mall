package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.goods.BrandBean;

/**
 * Author：diankun
 * Time：20-11-3 上午10:34
 * Description: 团购
 */
public class BrandAdapter extends MyAdapter<BrandBean> {

    public BrandAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder{

        private ImageView goodsIv;
        private TextView nameTv, priceTv;

        public ViewHolder() {
            super(R.layout.brand_item);
        }

        @Override
        public void onBindView(int position) {
            goodsIv = (ImageView) findViewById(R.id.iv_goods);
            nameTv = (TextView) findViewById(R.id.tv_name);
            priceTv = (TextView) findViewById(R.id.tv_price);

            BrandBean brandBean = getItem(position);
            nameTv.setText(brandBean.getName());
            priceTv.setText(brandBean.getFloorPrice()+"起");
            GlideApp.with(getContext())
                    .load(brandBean.getPicUrl())
                    .into(goodsIv);
        }
    }
}
