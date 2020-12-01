package com.me.slone.mall.ui.activity;

import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hjq.base.BaseFragmentAdapter;
import com.me.slone.mall.R;
import com.me.slone.mall.common.Constants;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.ui.fragment.CouponListFragment;

/**
 * Author：diankun
 * Time：20-12-1 上午9:40
 * Description:优惠券列表
 */
public class CouponListActivity extends MyActivity {

    private ViewPager mCouponVp;
    private BaseFragmentAdapter<CouponListFragment> mFrgmentAdapter;
    private String[] mTitles = {"未使用", "已使用", "已过期"};
    private SegmentTabLayout mCouponSt;


    @Override
    protected int getLayoutId() {
        return R.layout.couponlist_activity;
    }

    @Override
    protected void initView() {
        mCouponSt = findViewById(R.id.tl_1);
        mCouponSt.setTabData(mTitles);
        mCouponSt.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mCouponVp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mCouponVp = findViewById(R.id.vp_coupons);
    }

    @Override
    protected void initData() {
        mFrgmentAdapter = new BaseFragmentAdapter<>(this);
        for (String title : mTitles) {
            CouponListFragment couponListFragment = null;
            if ("未使用".equals(title)) {
                couponListFragment = CouponListFragment.getInstance(Constants.COUPON_STATUS_UNUSERD);
            } else if ("已使用".equals(title)) {
                couponListFragment = CouponListFragment.getInstance(Constants.COUPON_STATUS_USED);
            } else if ("已过期".equals(title)) {
                couponListFragment = CouponListFragment.getInstance(Constants.COUPON_STATUS_EXPIRED);
            }

            mFrgmentAdapter.addFragment(couponListFragment);
        }
        mCouponVp.setAdapter(mFrgmentAdapter);
        mCouponVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCouponSt.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
