package com.me.slone.mall.ui.fragment;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.HomeApi;
import com.me.slone.mall.http.response.goods.BannerBean;
import com.me.slone.mall.http.response.goods.HomeGoodsBean;
import com.me.slone.mall.ui.activity.HomeActivity;
import com.me.slone.mall.ui.adapter.MallViewHolder;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;

import java.util.List;

/**
 * Author：diankun
 * Time：20-10-30 下午2:51
 * Description:
 */
public class HomeFragment extends MyFragment<HomeActivity> {

    private Banner mBanner;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView() {
        mBanner = findViewById(R.id.banner);

    }

    @Override
    protected void initData() {
        getHomeData();
    }

    private void getHomeData() {
        EasyHttp.get(this)
                .api(new HomeApi())
                .request(new HttpCallback<HttpData<HomeGoodsBean>>(this){
                    @Override
                    public void onSucceed(HttpData<HomeGoodsBean> result) {
                        super.onSucceed(result);

                        refreshBaner(result.getData().getBanner());
                    }
                });
    }

    private void refreshBaner(List<BannerBean> bannerBeans) {
        mBanner.setAutoPlay(true)
                .setPages(bannerBeans,new MallViewHolder(getAttachActivity()))
                .setDelayTime(2000)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start();
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
}
