package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.cart.CartBean;
import com.me.slone.mall.widget.AmountView;

/**
 * Author：diankun
 * Time：20-11-24 下午4:55
 * Description:
 */
public class CartListAdapter extends MyAdapter<CartBean> {

    private boolean editCart;

    public CartListAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    public void setEditCart(boolean editCart) {
        this.editCart = editCart;
        notifyDataSetChanged();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder {

        private ImageView goodsIv;
        private TextView nameTv, countTv, briefTv, priceTv;
        private CheckBox checkCb;
        private LinearLayout deleteLl;
        private AmountView amountView;

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
            checkCb = (CheckBox) findViewById(R.id.cb_select);
            deleteLl = (LinearLayout) findViewById(R.id.ll_delete);
            amountView = (AmountView) findViewById(R.id.amount_view);

            if (editCart) {
                deleteLl.setVisibility(View.VISIBLE);
                amountView.setVisibility(View.VISIBLE);
            } else {
                deleteLl.setVisibility(View.GONE);
                amountView.setVisibility(View.GONE);
            }
            CartBean cartBean = getItem(position);
            nameTv.setText(cartBean.getGoodsName());
            StringBuffer specSb = new StringBuffer();
            for (String spec : cartBean.getSpecifications()) {
                specSb.append(spec).append(" ");
            }
            briefTv.setText(specSb.toString());
            countTv.setText("x" + cartBean.getNumber());
            priceTv.setText("¥" + cartBean.getPrice());
            amountView.setAmount(cartBean.getNumber());
            checkCb.setChecked(cartBean.isChecked());
            GlideApp.with(getContext())
                    .load(cartBean.getPicUrl())
                    .into(goodsIv);
        }
    }
}
