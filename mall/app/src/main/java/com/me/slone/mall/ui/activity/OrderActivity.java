package com.me.slone.mall.ui.activity;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.hjq.bar.TitleBar;
import com.hjq.base.BaseFragmentAdapter;
import com.me.slone.mall.R;
import com.me.slone.mall.bean.OrderStatus;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.ui.fragment.OrderListFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends MyActivity {

    private TitleBar mTitleBar;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mOrderVp;
    private List<OrderStatus> mOrderStatusList = new ArrayList<>();
    private BaseFragmentAdapter<OrderListFragment> mFrgmentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void initView() {
        mOrderVp = findViewById(R.id.vp_order_list);
        mSlidingTabLayout = findViewById(R.id.stl_orderlist);
    }

    @Override
    protected void initData() {
        initTabs();
        mFrgmentAdapter = new BaseFragmentAdapter<OrderListFragment>(this) {
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mOrderStatusList.get(position).getName();
            }
        };
        for (OrderStatus orderStatus : mOrderStatusList) {
            mFrgmentAdapter.addFragment(OrderListFragment.getInstance(orderStatus.getVaule()));
        }
        mOrderVp.setAdapter(mFrgmentAdapter);
        mSlidingTabLayout.setViewPager(mOrderVp);
    }

    private void initTabs() {
        mOrderStatusList.add(new OrderStatus(0, "全部"));
        mOrderStatusList.add(new OrderStatus(1, "待付款"));
        mOrderStatusList.add(new OrderStatus(2, "待发货"));
        mOrderStatusList.add(new OrderStatus(3, "待收货"));
        mOrderStatusList.add(new OrderStatus(4, "待评价"));
    }
}