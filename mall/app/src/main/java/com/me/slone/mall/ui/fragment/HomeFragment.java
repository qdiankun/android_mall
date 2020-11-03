package com.me.slone.mall.ui.fragment;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.base.BaseAdapter;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.toast.ToastUtils;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.HomeApi;
import com.me.slone.mall.http.response.goods.BannerBean;
import com.me.slone.mall.http.response.goods.ChannelBean;
import com.me.slone.mall.http.response.goods.CouponBean;
import com.me.slone.mall.http.response.goods.HomeGoodsBean;
import com.me.slone.mall.other.GridSpaceDecoration;
import com.me.slone.mall.ui.activity.HomeActivity;
import com.me.slone.mall.ui.adapter.ChannelAdapter;
import com.me.slone.mall.ui.adapter.CouponAdapter;
import com.me.slone.mall.ui.adapter.MallViewHolder;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：diankun
 * Time：20-10-30 下午2:51
 * Description:
 */
public class HomeFragment extends MyFragment<HomeActivity> {

    private Banner mBanner;
    private RecyclerView mChannelRv;
    private ChannelAdapter mChannelAdapter;
    private List<ChannelBean> mChannelList = new ArrayList<>();
    //coupon
    private RecyclerView mCouponRv;
    private CouponAdapter mCouponAdapter;
    private List<CouponBean> mCouponList = new ArrayList<>();


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
        mChannelRv = findViewById(R.id.rv_channel);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),5);
        mChannelRv.setLayoutManager(layoutManager);
        mChannelAdapter = new ChannelAdapter(getContext());
        mChannelAdapter.setData(mChannelList);
        mChannelAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                ToastUtils.show(mChannelList.get(position).getName());
            }
        });
        mChannelRv.setAdapter(mChannelAdapter);
        mCouponRv = findViewById(R.id.rv_coupon);
        mCouponAdapter = new CouponAdapter(getContext());
        mCouponAdapter.setData(mCouponList);
        mCouponAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

            }
        });
        mCouponRv.addItemDecoration(new GridSpaceDecoration(getContext()));
        mCouponRv.setAdapter(mCouponAdapter);
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
                        refreshChannel(result.getData().getChannel());
                        refreshCoupon(result.getData().getCouponList());
                    }
                });
    }

    private void refreshCoupon(List<CouponBean> couponList) {
        if(couponList == null || couponList.isEmpty()){
            return;
        }
        mCouponList.clear();
        mCouponList.addAll(couponList);
        mCouponAdapter.notifyDataSetChanged();
    }

    private void refreshChannel(List<ChannelBean> channel) {
        if(channel==null || channel.isEmpty()){
            return;
        }
        mChannelList.clear();;
        mChannelList.addAll(channel);
        mChannelAdapter.notifyDataSetChanged();
    }

    private void refreshBaner(List<BannerBean> bannerBeans) {
        mBanner.setAutoPlay(true)
                .setPages(bannerBeans,new MallViewHolder())
                .setDelayTime(2000)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start();
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
}
