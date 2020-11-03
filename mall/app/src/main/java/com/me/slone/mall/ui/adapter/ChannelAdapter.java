package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.goods.ChannelBean;


/**
 * Author：diankun
 * Time：20-11-2 下午2:31
 * Description:
 */
public class ChannelAdapter extends MyAdapter<ChannelBean> {

    public ChannelAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder{

        private ImageView channelIv;
        private TextView channelTv;

        public ViewHolder() {
            super(R.layout.channel_item);
            channelIv = (ImageView) findViewById(R.id.iv_channel);
            channelTv = (TextView) findViewById(R.id.tv_channel);
        }

        @Override
        public void onBindView(int position) {
            ChannelBean channelBean = getItem(position);
            channelTv.setText(channelBean.getName());
            GlideApp.with(getContext())
                    .load(channelBean.getIconUrl())
                    .into(channelIv);
        }
    }

}
