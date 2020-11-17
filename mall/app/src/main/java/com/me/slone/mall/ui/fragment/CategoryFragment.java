package com.me.slone.mall.ui.fragment;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.GoodCategoryApi;
import com.me.slone.mall.http.response.category.Category;
import com.me.slone.mall.http.response.category.GoodCategory;
import com.me.slone.mall.other.GridSpaceDecoration;
import com.me.slone.mall.ui.activity.HomeActivity;
import com.me.slone.mall.ui.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * Author：diankun
 * Time：20-10-30 下午2:52
 * Description: 分类
 */
public class CategoryFragment extends MyFragment<HomeActivity> {

    private VerticalTabLayout mTabLayout;
    private ImageView mCategoryIv;
    private TextView mCategoryTv;
    private RecyclerView mCategoryRv;
    private CategoryAdapter mCategoryAdapter;
    private List<Category> mCategoryList = new ArrayList<>();
    private Map<String,List<Category>> mAllCategorys;

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.category_fragment;
    }

    @Override
    protected void initView() {
        mTabLayout = findViewById(R.id.vtl_category);
        mCategoryRv = findViewById(R.id.rv_category);
        mCategoryIv = findViewById(R.id.iv_category);
        mCategoryTv = findViewById(R.id.tv_cateogry);

        GridLayoutManager newGoodsManager = new GridLayoutManager(getContext(), 2);
        mCategoryRv.setLayoutManager(newGoodsManager);
        mCategoryAdapter = new CategoryAdapter(getContext());
        mCategoryAdapter.setData(mCategoryList);
        mCategoryRv.addItemDecoration(new GridSpaceDecoration(getContext()));
        mCategoryRv.setAdapter(mCategoryAdapter);
    }

    @Override
    protected void initData() {
        getCurrentCategory();
    }

    private void getCurrentCategory() {
        EasyHttp.get(this)
                .api(new GoodCategoryApi())
                .request(new HttpCallback<HttpData<GoodCategory>>(this) {
                    @Override
                    public void onSucceed(HttpData<GoodCategory> result) {
                        super.onSucceed(result);
                        if(result.getData() == null){
                            return;
                        }
                        mAllCategorys= result.getData().getAllList();
                        refreshCategory(result.getData().getCurrentCategory());
                        refreshCategoryList(result.getData().getCategoryList());
                        refreshSubCategory(result.getData().getCurrentSubCategory());
                    }
                });
    }


    private void refreshCategoryList(List<Category> categoryList) {
        if (categoryList == null || categoryList.isEmpty()) {
            return;
        }
        mTabLayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return categoryList == null ? 0 : categoryList.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int i) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int i) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int i) {
                return new TabView.TabTitle.Builder()
                        .setContent(categoryList.get(i).getName())
                        .setTextColor(ContextCompat.getColor(getAttachActivity(), R.color.shallow_green),
                                ContextCompat.getColor(getAttachActivity(), R.color.shallow_grey))
                        .build();
            }

            @Override
            public int getBackground(int i) {
                return -1;
            }

        });
        mTabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                Category category = categoryList.get(position);
                mCategoryTv.setText("－ " + category.getName() + " －");
                GlideApp.with(getAttachActivity())
                        .load(category.getPicUrl())
                        .into(mCategoryIv);
                String name = String.valueOf(category.getId());
                refreshSubCategory(mAllCategorys.get(name));
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
    }

    private void refreshSubCategory(List<Category> subCategory) {
        if(subCategory==null || subCategory.isEmpty()){
            return;
        }
        mCategoryList.clear();
        mCategoryList.addAll(subCategory);
        mCategoryAdapter.notifyDataSetChanged();
    }

    private void refreshCategory(Category currentCategory) {
        if (currentCategory == null) {
            return;
        }
        mCategoryTv.setText("－ " + currentCategory.getName() + " －");
        GlideApp.with(getAttachActivity())
                .load(currentCategory.getPicUrl())
                .into(mCategoryIv);
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

}
