package com.me.slone.mall.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.base.BaseAdapter;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.toast.ToastUtils;
import com.me.slone.mall.BuildConfig;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.HomeApi;
import com.me.slone.mall.http.response.goods.BannerBean;
import com.me.slone.mall.http.response.goods.BrandBean;
import com.me.slone.mall.http.response.goods.ChannelBean;
import com.me.slone.mall.http.response.goods.CouponBean;
import com.me.slone.mall.http.response.goods.FloorGoodsBean;
import com.me.slone.mall.http.response.goods.GroupBean;
import com.me.slone.mall.http.response.goods.HomeGoodsBean;
import com.me.slone.mall.http.response.goods.HotGoodsBean;
import com.me.slone.mall.http.response.goods.NewGoodsBean;
import com.me.slone.mall.http.response.goods.TopicBean;
import com.me.slone.mall.other.DividerGridItemDecoration;
import com.me.slone.mall.other.DividerItemDecoration;
import com.me.slone.mall.other.GridSpaceDecoration;
import com.me.slone.mall.ui.activity.GoodDetailActivity;
import com.me.slone.mall.ui.activity.HomeActivity;
import com.me.slone.mall.ui.adapter.BrandAdapter;
import com.me.slone.mall.ui.adapter.ChannelAdapter;
import com.me.slone.mall.ui.adapter.CouponAdapter;
import com.me.slone.mall.ui.adapter.FloorAdapter;
import com.me.slone.mall.ui.adapter.GroupAdapter;
import com.me.slone.mall.ui.adapter.HotGoodsAdapter;
import com.me.slone.mall.ui.adapter.MallViewHolder;
import com.me.slone.mall.ui.adapter.NewGoodsAdapter;
import com.me.slone.mall.utils.DisplayUtil;
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
    //group
    private RecyclerView mGroupRv;
    private GroupAdapter mGroupAdapter;
    private List<GroupBean> mGroupList = new ArrayList<>();
    //newgoods;
    private RecyclerView mNewGoodsRv;
    private NewGoodsAdapter mNewGoodsAdapter;
    private List<NewGoodsBean> mNewGoodsList = new ArrayList<>();
    //brands
    private RecyclerView mBrandsRv;
    private BrandAdapter mBrandAdapter;
    private List<BrandBean> mBrandList = new ArrayList<>();
    //hotgoods
    private RecyclerView mHotGoodsRv;
    private HotGoodsAdapter mHotGoodsAdapter;
    private List<HotGoodsBean> mHotGoodsList = new ArrayList<>();
    //topics
    private LinearLayout topLl;
    //floor
    private RecyclerView mFloorRv;
    private FloorAdapter mFloorAdapter;
    private List<FloorGoodsBean> mFloorGoodsList = new ArrayList<>();

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
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 5);
        mChannelRv.setLayoutManager(layoutManager);
        mChannelAdapter = new ChannelAdapter(getContext());
        mChannelAdapter.setData(mChannelList);
        mChannelAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                ToastUtils.show(mChannelList.get(position).getName());
            }
        });
        //coupon
        mChannelRv.setAdapter(mChannelAdapter);
        mCouponRv = findViewById(R.id.rv_coupon);
        mCouponAdapter = new CouponAdapter(getContext());
        mCouponAdapter.setData(mCouponList);
        mCouponAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                ToastUtils.show(mCouponList.get(position).getName());
            }
        });
        mCouponRv.addItemDecoration(getVerticalWhiteDividerItem());
        mCouponRv.setAdapter(mCouponAdapter);
        //groups
        mGroupRv = findViewById(R.id.rv_group);
        mGroupAdapter = new GroupAdapter(getContext());
        mGroupAdapter.setData(mGroupList);
        mGroupAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

            }
        });
        mGroupRv.addItemDecoration(getVerticalGrayDividerItem());
        mGroupRv.setAdapter(mGroupAdapter);
        //newgoods
        mNewGoodsRv = findViewById(R.id.rv_newgoods);
        GridLayoutManager newGoodsManager = new GridLayoutManager(getContext(), 2);
        mNewGoodsRv.setLayoutManager(newGoodsManager);
        mNewGoodsAdapter = new NewGoodsAdapter(getContext());
        mNewGoodsAdapter.setData(mNewGoodsList);
        mNewGoodsAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("goodId",mNewGoodsList.get(position).getId());
                Intent intent = new Intent(getActivity(),GoodDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        mNewGoodsRv.addItemDecoration(new GridSpaceDecoration(getContext()));
        mNewGoodsRv.setAdapter(mNewGoodsAdapter);
        //brand
        mBrandsRv = findViewById(R.id.rv_brands);
        GridLayoutManager brandManager = new GridLayoutManager(getContext(), 2);
        mBrandsRv.setLayoutManager(brandManager);
        mBrandAdapter = new BrandAdapter(getContext());
        mBrandAdapter.setData(mBrandList);
        mBrandAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

            }
        });
        Drawable gridLine = getResources().getDrawable(R.drawable.divider_grid_white_bg);
        mBrandsRv.addItemDecoration(new DividerGridItemDecoration(gridLine));
        mBrandsRv.setAdapter(mBrandAdapter);
        //hotgoods
        mHotGoodsRv = findViewById(R.id.rv_hotgoods);
        mHotGoodsAdapter = new HotGoodsAdapter(getContext());
        mHotGoodsAdapter.setData(mHotGoodsList);
        mHotGoodsAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

            }
        });
        mHotGoodsRv.addItemDecoration(getVerticalGrayDividerItem());
        mHotGoodsRv.setAdapter(mHotGoodsAdapter);

        topLl = findViewById(R.id.ll_topics);
        mFloorRv = findViewById(R.id.rv_floor);
        mFloorAdapter = new FloorAdapter(getContext());
        mFloorAdapter.setData(mFloorGoodsList);
        mFloorAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

            }
        });
        mFloorRv.setAdapter(mFloorAdapter);


    }

    private DividerItemDecoration getVerticalGrayDividerItem() {
        Drawable verticalLine = getResources().getDrawable(R.drawable.divider_vertical_bg);
        return new DividerItemDecoration(DividerItemDecoration.VERTICAL_LIST, verticalLine);
    }

    private DividerItemDecoration getVerticalWhiteDividerItem() {
        Drawable verticalLine = getResources().getDrawable(R.drawable.divider_vertical_white_bg);
        return new DividerItemDecoration(DividerItemDecoration.VERTICAL_LIST, verticalLine);
    }

    @Override
    protected void initData() {
        getHomeData();
    }

    private void getHomeData() {
        EasyHttp.get(this)
                .api(new HomeApi())
                .request(new HttpCallback<HttpData<HomeGoodsBean>>(this) {
                    @Override
                    public void onSucceed(HttpData<HomeGoodsBean> result) {
                        super.onSucceed(result);
                        refreshBaner(result.getData().getBanner());
                        refreshChannel(result.getData().getChannel());
                        refreshCoupon(result.getData().getCouponList());
                        refreshGroup(result.getData().getGrouponList());
                        refreshNewGoods(result.getData().getNewGoodsList());
                        refreshBrands(result.getData().getBrandList());
                        refreshHotGoods(result.getData().getHotGoodsList());
                        refreshTopics(result.getData().getTopicList());
                        refreshFloor(result.getData().getFloorGoodsList());
                    }
                });
    }

    private void refreshFloor(List<FloorGoodsBean> floorGoodsList) {
        if (floorGoodsList == null || floorGoodsList.isEmpty()) {
            return;
        }
        mFloorGoodsList.clear();
        mFloorGoodsList.addAll(floorGoodsList);
        mFloorAdapter.notifyDataSetChanged();
    }

    private void refreshTopics(List<TopicBean> topicList) {
        if (topicList == null || topicList.isEmpty()) {
            return;
        }
        for (TopicBean topicBean : topicList) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.topic_item, null);
            ImageView goodIv = view.findViewById(R.id.iv_goods);
            TextView nameTv = view.findViewById(R.id.tv_name);
            TextView priceTv = view.findViewById(R.id.tv_price);
            TextView subTitleTv = view.findViewById(R.id.tv_subtitle);
            GlideApp.with(getContext())
                    .load(topicBean.getPicUrl())
                    .into(goodIv);
            nameTv.setText(topicBean.getTitle());
            priceTv.setText("¥ "+topicBean.getPrice());
            subTitleTv.setText(topicBean.getSubtitle());
            view.setOnClickListener(view1 -> {
                ToastUtils.show(topicBean.getTitle());
            });
            int width = DisplayUtil.getScreenContentWidth(getContext()) - 80;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            topLl.addView(view,params);
        }
    }

    private void refreshHotGoods(List<HotGoodsBean> hotGoodsList) {
        if (hotGoodsList == null || hotGoodsList.isEmpty()) {
            return;
        }
        mHotGoodsList.clear();
        mHotGoodsList.addAll(hotGoodsList);
        mHotGoodsAdapter.notifyDataSetChanged();
    }

    private void refreshBrands(List<BrandBean> brandList) {
        if (brandList == null || brandList.isEmpty()) {
            return;
        }
        mBrandList.clear();
        mBrandList.addAll(brandList);
        mBrandAdapter.notifyDataSetChanged();
    }

    private void refreshNewGoods(List<NewGoodsBean> newGoodsList) {
        if (newGoodsList == null || newGoodsList.isEmpty()) {
            return;
        }
        mNewGoodsList.clear();
        mNewGoodsList.addAll(newGoodsList);
        mNewGoodsAdapter.notifyDataSetChanged();
    }

    private void refreshGroup(List<GroupBean> grouponList) {
        if (grouponList == null || grouponList.isEmpty()) {
            return;
        }
        mGroupList.clear();
        mGroupList.addAll(grouponList);
        mGroupAdapter.notifyDataSetChanged();
    }

    private void refreshCoupon(List<CouponBean> couponList) {
        if (couponList == null || couponList.isEmpty()) {
            return;
        }
        mCouponList.clear();
        mCouponList.addAll(couponList);
        mCouponAdapter.notifyDataSetChanged();
    }

    private void refreshChannel(List<ChannelBean> channel) {
        if (channel == null || channel.isEmpty()) {
            return;
        }
        mChannelList.clear();
        ;
        mChannelList.addAll(channel);
        mChannelAdapter.notifyDataSetChanged();
    }

    private void refreshBaner(List<BannerBean> bannerBeans) {
        mBanner.setAutoPlay(true)
                .setPages(bannerBeans, new MallViewHolder())
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
