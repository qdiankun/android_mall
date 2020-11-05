package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.goods.BannerBean;
import com.ms.banner.holder.BannerViewHolder;

/**
 * Author：diankun
 * Time：20-11-2 上午10:50
 * Description: 商品详情
 */
public class GoodsDetailViewHolder implements BannerViewHolder<String> {

    @Override
    public View createView(Context context, int position, String url) {
        // 返回mImageView页面布局
        ImageView imageView = new ImageView(context);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        );
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        GlideApp.with(context)
                .load(url)
                .into(imageView);
        return imageView;
    }

}
