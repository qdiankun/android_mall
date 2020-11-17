package com.me.slone.mall.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.CategoryListApi;
import com.me.slone.mall.http.response.category.Category;
import com.me.slone.mall.http.response.goods.CategoryListBean;
import com.me.slone.mall.http.response.goods.NewGoodsBean;
import com.me.slone.mall.other.DividerGridItemDecoration;
import com.me.slone.mall.ui.activity.HomeActivity;
import com.me.slone.mall.ui.adapter.FloorChildAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：diankun
 * Time：20-11-17 下午2:00
 * Description: 分类列表
 */
public class CategoryListFragment extends MyFragment<HomeActivity> {

    private RecyclerView mCategoryRv;
    private TextView mTitleTv, mBriefTv;
    private FloorChildAdapter mFloorChildAdapter;
    private List<NewGoodsBean> mNewGoodsBeans = new ArrayList<>();
    private Category mCategory;
    private static String ARG_CATEGORY = "arg_category";

    public static CategoryListFragment getInstance(Category category) {
        CategoryListFragment categoryListFragment = new CategoryListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_CATEGORY, category);
        categoryListFragment.setArguments(bundle);
        return categoryListFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.category_list_fragment;
    }

    @Override
    protected void initView() {
        mCategoryRv = findViewById(R.id.rv_category);
        mTitleTv = findViewById(R.id.tv_cateogry_title);
        mBriefTv = findViewById(R.id.tv_cateogry_brief);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        mCategoryRv.setLayoutManager(layoutManager);
        Drawable verticalLine = getResources().getDrawable(R.drawable.divider_grid_gray_bg);
        DividerGridItemDecoration dividerItemDecoration = new DividerGridItemDecoration(verticalLine);
        mCategoryRv.addItemDecoration(dividerItemDecoration);
        mFloorChildAdapter = new FloorChildAdapter(getContext());
        mFloorChildAdapter.setData(mNewGoodsBeans);
        mCategoryRv.setAdapter(mFloorChildAdapter);
//        mHotGoodsAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
//
//            }
//        });
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mCategory = (Category) arguments.getSerializable(ARG_CATEGORY);
        }
        if (mCategory == null) {
            return;
        }
        getCategoryGoods(mCategory.getId());
        mTitleTv.setText(mCategory.getName());
        mBriefTv.setText(mCategory.getDesc());
    }

    private void getCategoryGoods(int id) {
        EasyHttp.get(this)
                .api(new CategoryListApi().setCategoryId(id))
                .request(new HttpCallback<HttpData<CategoryListBean>>(this) {
                    @Override
                    public void onSucceed(HttpData<CategoryListBean> result) {
                        super.onSucceed(result);
                        if (result.getData() == null) {
                            return;
                        }
                        refreshHotGoods(result.getData().getList());
                    }
                });
    }

    private void refreshHotGoods(List<NewGoodsBean> hotGoodsBeans) {
        if (hotGoodsBeans == null || hotGoodsBeans.isEmpty()) {
            mCategoryRv.setVisibility(View.GONE);
            ;
            return;
        }
        mCategoryRv.setVisibility(View.VISIBLE);
        ;
        mNewGoodsBeans.clear();
        mNewGoodsBeans.addAll(hotGoodsBeans);
        mFloorChildAdapter.notifyDataSetChanged();
    }
}
