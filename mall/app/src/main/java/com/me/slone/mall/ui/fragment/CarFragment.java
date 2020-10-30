package com.me.slone.mall.ui.fragment;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.common.MyFragment;

/**
 * Author：diankun
 * Time：20-10-30 下午2:53
 * Description: 购物车
 */
public class CarFragment extends MyFragment<MyActivity> {

    public static CarFragment newInstance() {
        return new CarFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.car_fragment;
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
