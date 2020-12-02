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
import com.me.slone.mall.http.response.cart.CheckedGoodsBean;
import com.me.slone.mall.widget.AmountView;

/**
 * Author：diankun
 * Time：20-11-24 下午4:55
 * Description:
 */
public class CheckListAdapter extends MyAdapter<CheckedGoodsBean> {

    private boolean mEditCart;

    public CheckListAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    public void setEditCart(boolean mEditCart) {
        this.mEditCart = mEditCart;
        notifyDataSetChanged();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder {

        private ImageView goodsIv;
        private TextView nameTv, countTv, briefTv, priceTv;

        public ViewHolder() {
            super(R.layout.checklist_item);
        }

        @Override
        public void onBindView(int position) {
            goodsIv = (ImageView) findViewById(R.id.iv_goods);
            nameTv = (TextView) findViewById(R.id.tv_name);
            countTv = (TextView) findViewById(R.id.tv_count);
            briefTv = (TextView) findViewById(R.id.tv_brief);
            priceTv = (TextView) findViewById(R.id.tv_price);
            CheckedGoodsBean checkedGoodsBean = getItem(position);
            nameTv.setText(checkedGoodsBean.getGoodsName());
            StringBuffer specSb = new StringBuffer();
            for (String spec : checkedGoodsBean.getSpecifications()) {
                specSb.append(spec).append(" ");
            }
            briefTv.setText(specSb.toString());
            countTv.setText("x" + checkedGoodsBean.getNumber());
            priceTv.setText("¥" + checkedGoodsBean.getPrice());
            GlideApp.with(getContext())
                    .load(checkedGoodsBean.getPicUrl())
                    .into(goodsIv);
        }
    }
}
