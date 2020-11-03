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

/**
 * Author：diankun
 * Time：20-11-3 上午10:34
 * Description: 团购
 */
public class GroupAdapter extends MyAdapter<GroupBean> {

    public GroupAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder{

        private ImageView goodsIv;
        private TextView nameTv,numbersTv,timeTv, briefTv,price1Tv,price2Tv;

        public ViewHolder() {
            super(R.layout.group_item);
        }

        @Override
        public void onBindView(int position) {
            goodsIv = (ImageView) findViewById(R.id.iv_goods);
            nameTv = (TextView) findViewById(R.id.tv_name);
            numbersTv = (TextView) findViewById(R.id.tv_numbers);
            timeTv = (TextView) findViewById(R.id.tv_time);
            briefTv = (TextView) findViewById(R.id.tv_desc);
            price1Tv = (TextView) findViewById(R.id.tv_price1);
            price2Tv = (TextView) findViewById(R.id.tv_price2);

            GroupBean groupBean = getItem(position);
            nameTv.setText(groupBean.getName());
            numbersTv.setText(groupBean.getGrouponDiscount()+"人成团");
            timeTv.setText("有效期："+groupBean.getExpireTime());
            briefTv.setText(groupBean.getBrief());
            price1Tv.setText("现价："+ " ¥"+groupBean.getRetailPrice());
            price2Tv.setText("团购价："+" ¥"+groupBean.getGrouponPrice());
            GlideApp.with(getContext())
                    .load(groupBean.getPicUrl())
                    .into(goodsIv);
        }
    }
}
