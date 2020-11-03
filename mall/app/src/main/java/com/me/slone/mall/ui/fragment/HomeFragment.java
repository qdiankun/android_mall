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
import com.me.slone.mall.http.response.goods.BrandBean;
import com.me.slone.mall.http.response.goods.ChannelBean;
import com.me.slone.mall.http.response.goods.CouponBean;
import com.me.slone.mall.http.response.goods.GroupBean;
import com.me.slone.mall.http.response.goods.HomeGoodsBean;
import com.me.slone.mall.http.response.goods.NewGoodsBean;
import com.me.slone.mall.other.DividerGridItemDecoration;
import com.me.slone.mall.other.GridSpaceDecoration;
import com.me.slone.mall.other.SimpleDividerDecoration;
import com.me.slone.mall.ui.activity.HomeActivity;
import com.me.slone.mall.ui.adapter.BrandAdapter;
import com.me.slone.mall.ui.adapter.ChannelAdapter;
import com.me.slone.mall.ui.adapter.CouponAdapter;
import com.me.slone.mall.ui.adapter.GroupAdapter;
import com.me.slone.mall.ui.adapter.MallViewHolder;
import com.me.slone.mall.ui.adapter.NewGoodsAdapter;
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
        mCouponRv.addItemDecoration(new GridSpaceDecoration(getContext()));
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
        mGroupRv.addItemDecoration(new SimpleDividerDecoration(getContext()));
        mGroupRv.setAdapter(mGroupAdapter);
        //newgoods
        mNewGoodsRv = findViewById(R.id.rv_newgoods);
        GridLayoutManager newGoodsManager = new GridLayoutManager(getContext(),2);
        mNewGoodsRv.setLayoutManager(newGoodsManager);
        mNewGoodsAdapter = new NewGoodsAdapter(getContext());
        mNewGoodsAdapter.setData(mNewGoodsList);
        mNewGoodsAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

            }
        });
        mNewGoodsRv.addItemDecoration(new GridSpaceDecoration(getContext()));
        mNewGoodsRv.setAdapter(mNewGoodsAdapter);
        //brand
        mBrandsRv = findViewById(R.id.rv_brands);
        GridLayoutManager brandManager = new GridLayoutManager(getContext(),2);
        mBrandsRv.setLayoutManager(brandManager);
        mBrandAdapter = new BrandAdapter(getContext());
        mBrandAdapter.setData(mBrandList);
        mBrandAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

            }
        });
        mBrandsRv.addItemDecoration(new DividerGridItemDecoration(getContext()));
        mBrandsRv.setAdapter(mBrandAdapter);
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
                        refreshGroup(result.getData().getGrouponList());
                        refreshNewGoods(result.getData().getNewGoodsList());
                        refreshBrands(result.getData().getBrandList());
                    }
                });
    }

    private void refreshBrands(List<BrandBean> brandList) {
        if(brandList == null || brandList.isEmpty()){
            return;
        }
        mBrandList.clear();
        mBrandList.addAll(brandList);
        mBrandAdapter.notifyDataSetChanged();
    }

    private void refreshNewGoods(List<NewGoodsBean> newGoodsList) {
        if(newGoodsList == null || newGoodsList.isEmpty()){
            return;
        }
        mNewGoodsList.clear();
        mNewGoodsList.addAll(newGoodsList);
        mNewGoodsAdapter.notifyDataSetChanged();
    }

    private void refreshGroup(List<GroupBean> grouponList) {
        if(grouponList == null || grouponList.isEmpty()){
            return;
        }
        mGroupList.clear();
        mGroupList.addAll(grouponList);
        mGroupAdapter.notifyDataSetChanged();
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
