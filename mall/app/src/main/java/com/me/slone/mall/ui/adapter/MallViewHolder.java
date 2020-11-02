package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.me.slone.mall.R;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.goods.BannerBean;
import com.ms.banner.holder.BannerViewHolder;

/**
 * Author：diankun
 * Time：20-11-2 上午10:50
 * Description:
 */
public class MallViewHolder implements BannerViewHolder<BannerBean> {

    private Context context;

    public MallViewHolder(Context context) {
        this.context = context;
    }

    @Override
    public View createView(Context context, int position, BannerBean banner) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
        ImageView imageView = view.findViewById(R.id.id_banner);
        GlideApp.with(context)
                .load(banner.getUrl())
                .into(imageView);
        return view;
    }

}
