package com.me.slone.mall.ui.fragment;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.ui.activity.HomeActivity;

/**
 * Author：diankun
 * Time：20-10-30 下午2:51
 * Description:
 */
public class HomeFragment extends MyFragment<HomeActivity> {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
}
