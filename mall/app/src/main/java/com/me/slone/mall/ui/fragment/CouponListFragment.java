package com.me.slone.mall.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.CouponListApi;
import com.me.slone.mall.http.response.category.Category;
import com.me.slone.mall.http.response.me.CouponItemBean;
import com.me.slone.mall.http.response.me.CouponListBean;
import com.me.slone.mall.other.DividerGridItemDecoration;
import com.me.slone.mall.ui.activity.CouponListActivity;
import com.me.slone.mall.ui.adapter.CouponListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：diankun
 * Time：20-11-17 下午2:00
 * Description: 分类列表
 */
public class CouponListFragment extends MyFragment<CouponListActivity> {

    private RecyclerView mCouponRv;
    private CouponListAdapter mCouponListAdapter;
    private List<CouponItemBean> mNewGoodsBeans = new ArrayList<>();
    private int couponStatus = -1;
    private static String ARG_COUPON = "arg_couponstatus";

    public static CouponListFragment getInstance(int status) {
        CouponListFragment categoryListFragment = new CouponListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_COUPON, status);
        categoryListFragment.setArguments(bundle);
        return categoryListFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.couponlist_fragment;
    }

    @Override
    protected void initView() {
        mCouponRv = findViewById(R.id.rv_coupon);
        mCouponListAdapter = new CouponListAdapter(getContext());
        mCouponListAdapter.setData(mNewGoodsBeans);
        mCouponListAdapter.setOnItemClickListener((recyclerView, itemView, position) -> {
        });
        mCouponRv.setAdapter(mCouponListAdapter);
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            couponStatus = arguments.getInt(ARG_COUPON);
        }
        if (couponStatus < 0) {
            return;
        }
        getCategoryGoods();
    }

    private void getCategoryGoods() {
        EasyHttp.get(this)
                .api(new CouponListApi()
                        .setStatus(couponStatus)
                        .setLimit(10)
                        .setPage(1))
                .request(new HttpCallback<HttpData<CouponListBean>>(this) {
                    @Override
                    public void onSucceed(HttpData<CouponListBean> result) {
                        super.onSucceed(result);
                        if (result.getData() == null) {
                            return;
                        }
                        refreshCouponList(result.getData().getList());
                    }
                });
    }

    private void refreshCouponList(List<CouponItemBean> couponItemBeans) {
        if (couponItemBeans == null || couponItemBeans.isEmpty()) {
            mCouponRv.setVisibility(View.GONE);
            return;
        }
        mCouponRv.setVisibility(View.VISIBLE);
        mNewGoodsBeans.clear();
        mNewGoodsBeans.addAll(couponItemBeans);
        mCouponListAdapter.notifyDataSetChanged();
    }
}
