package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.cart.CartBean;

/**
 * Author：diankun
 * Time：20-11-24 下午4:55
 * Description:
 */
public class CartListAdapter extends MyAdapter<CartBean> {

    public CartListAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }


    private final class ViewHolder extends MyAdapter.ViewHolder {

        private ImageView goodsIv;
        private TextView nameTv, countTv, briefTv, priceTv;

        public ViewHolder() {
            super(R.layout.cartlist_item);
        }

        @Override
        public void onBindView(int position) {
            goodsIv = (ImageView) findViewById(R.id.iv_goods);
            nameTv = (TextView) findViewById(R.id.tv_name);
            countTv = (TextView) findViewById(R.id.tv_count);
            briefTv = (TextView) findViewById(R.id.tv_brief);
            priceTv = (TextView) findViewById(R.id.tv_price);

            CartBean cartBean = getItem(position);
            nameTv.setText(cartBean.getGoodsName());
            StringBuffer specSb = new StringBuffer();
            for (String spec : cartBean.getSpecifications()) {
                specSb.append(spec).append(" ");
            }
            briefTv.setText(specSb.toString());
            countTv.setText("x"+cartBean.getNumber());
            priceTv.setText("¥" + cartBean.getPrice());
            GlideApp.with(getContext())
                    .load(cartBean.getPicUrl())
                    .into(goodsIv);
        }
    }
}
