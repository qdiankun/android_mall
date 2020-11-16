package com.me.slone.mall.ui.activity;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import android.text.TextUtils;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hjq.base.BaseFragmentAdapter;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.common.UserConstants;
import com.me.slone.mall.ui.fragment.CarFragment;
import com.me.slone.mall.ui.fragment.CategoryFragment;
import com.me.slone.mall.ui.fragment.HomeFragment;
import com.me.slone.mall.ui.fragment.MeFragment;

public class HomeActivity extends MyActivity implements  BottomNavigationView.OnNavigationItemSelectedListener  {


    private BottomNavigationView mBottomNavigationView;
    private ViewPager mViewPager;
    private BaseFragmentAdapter<MyFragment> mPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.home_activity;
    }

    @Override
    protected void initView() {
        mViewPager = findViewById(R.id.vp_home_pager);
        mBottomNavigationView = findViewById(R.id.bv_home_navigation);
        // 不使用图标默认变色
        mBottomNavigationView.setItemIconTintList(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initData() {
        mPagerAdapter = new BaseFragmentAdapter<>(this);
        mPagerAdapter.addFragment(HomeFragment.newInstance());
        mPagerAdapter.addFragment(CategoryFragment.newInstance());
        mPagerAdapter.addFragment(CarFragment.newInstance());
        mPagerAdapter.addFragment(MeFragment.newInstance());
        // 设置成懒加载模式
        mPagerAdapter.setLazyMode(true);
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                mViewPager.setCurrentItem(0);
                return true;
            case R.id.home_found:
                mViewPager.setCurrentItem(1);
                return true;
            case R.id.home_shop:
                if(UserConstants.isLogin()) {
                    mViewPager.setCurrentItem(2);
                } else {
                    startActivity(LoginActivity.class);
                }
                return true;
            case R.id.home_me:
                mViewPager.setCurrentItem(3);
                return true;
            default:
                break;
        }
        return false;
    }
}