package com.me.slone.mall.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.hjq.bar.TitleBar;
import com.hjq.base.BaseFragmentAdapter;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.http.response.category.Category;
import com.me.slone.mall.ui.fragment.CategoryListFragment;

import java.util.ArrayList;

/**
 * Author：diankun
 * Time：20-11-17 下午2:31
 * Description:
 */
public class CategoryListActivity extends MyActivity {

    private TitleBar mTitleBar;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private BaseFragmentAdapter<CategoryListFragment> mFrgmentAdapter;

    private Category mCategory;
    private ArrayList<Category> mCategoryList;
    public static String ARG_FIRST_CATEGORY = "arg_first_category";
    public static String ARG_SUB_CATEGORY = "arg_sub_category";

    @Override
    protected int getLayoutId() {
        return R.layout.category_list_activity;
    }

    @Override
    protected void initView() {
        mTitleBar = findViewById(R.id.titlebar);
        mSlidingTabLayout = findViewById(R.id.stl_category_list);
        mViewPager = findViewById(R.id.vp_category_list);
    }

    @Override
    protected void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        mCategory = (Category) bundle.getSerializable(ARG_FIRST_CATEGORY);
        mCategoryList = (ArrayList<Category>) bundle.getSerializable(ARG_SUB_CATEGORY);

        if (mCategory == null) {
            finish();
        }
        if (mCategoryList == null) {
            finish();
        }

        mTitleBar.setTitle(mCategory.getName());
        mFrgmentAdapter = new BaseFragmentAdapter<CategoryListFragment>(this){
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mCategoryList.get(position).getName();
            }
        };
        for (Category category : mCategoryList) {
            CategoryListFragment categoryListFragment = CategoryListFragment.getInstance(category);
            mFrgmentAdapter.addFragment(categoryListFragment);
        }
        mViewPager.setAdapter(mFrgmentAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
    }
}
