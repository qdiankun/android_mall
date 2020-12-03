package com.me.slone.mall.ui.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hjq.base.BaseAdapter;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.OnHttpListener;
import com.me.slone.mall.R;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.CouponSelectListApi;
import com.me.slone.mall.http.response.me.CouponItemBean;
import com.me.slone.mall.http.response.me.CouponListBean;
import com.me.slone.mall.ui.adapter.CouponCheckAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Author：diankun
 * Time：20-11-12 下午1:56
 * Description: 添加购物车
 */
public class CouponSheetDialog extends BottomSheetDialogFragment {

    private Context mContext;
    private View view;
    private int cartId;
    private int grouponRulesId;
    private int userCouponId;
    private static String ARG_CARTID = "arg_cartid";
    private static String ARG_GROUPONID = "arg_grouponid";
    private static String ARG_USERCOUPONID = "arg_usercouponid";
    private String[] mTitles = {"可用", "不可用"};
    private RecyclerView mCouponRv;
    private CouponCheckAdapter mAdapter;
    private SegmentTabLayout mCouponSt;
    private List<CouponItemBean> mAllCoupons = new ArrayList<>();
    private List<CouponItemBean> mCouponItemBeans = new ArrayList<>();
    private onCouponCheckListener mOnCouponCheckListener;

    public static CouponSheetDialog getInstance(int cartId, int grouponRulesId, int userCouponId) {
        CouponSheetDialog myBottomSheetFragment = new CouponSheetDialog();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_CARTID, cartId);
        bundle.putInt(ARG_GROUPONID, grouponRulesId);
        bundle.putInt(ARG_USERCOUPONID, userCouponId);
        myBottomSheetFragment.setArguments(bundle);
        return myBottomSheetFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        BottomSheetDialog dialog = (BottomSheetDialog) getDialog();
        //把windowsd的默认背景颜色去掉，不然圆角显示不见
        dialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackground(new ColorDrawable(Color.TRANSPARENT));
        //获取dialog的根布局
        FrameLayout bottomSheet = dialog.getDelegate().findViewById(R.id.design_bottom_sheet);
        if (bottomSheet != null) {
            //修改弹窗的最大高度，不允许上滑（默认可以上滑）
            //获取根部局的LayoutParams对象
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomSheet.getLayoutParams();
            layoutParams.height = getPeekHeight();
            bottomSheet.setLayoutParams(layoutParams);

            //peekHeight即弹窗的最大高度
            final BottomSheetBehavior<FrameLayout> behavior = BottomSheetBehavior.from(bottomSheet);
            behavior.setPeekHeight(getPeekHeight());
            //初始为展开状态
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    /**
     * 弹窗高度，默认为屏幕高度的四分之三
     * 子类可重写该方法返回peekHeight
     *
     * @return height
     */
    protected int getPeekHeight() {
        int peekHeight = getResources().getDisplayMetrics().heightPixels;
        //设置弹窗高度为屏幕高度的3/4
        return peekHeight - peekHeight / 3;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        Log.e("TAG", "onCreateView: ");
        view = inflater.inflate(R.layout.coupon_dialog_layout, container, false);
        initData();
        initViews(view);
        return view;
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        cartId = arguments.getInt(ARG_CARTID);
        grouponRulesId = arguments.getInt(ARG_GROUPONID);
        userCouponId = arguments.getInt(ARG_USERCOUPONID);
        getSelectCoupon();
    }

    public void setOnCouponCheckListener(CouponSheetDialog.onCouponCheckListener mOnCouponCheckListener) {
        this.mOnCouponCheckListener = mOnCouponCheckListener;
    }

    private void getSelectCoupon() {
        EasyHttp.get(this)
                .api(new CouponSelectListApi()
                        .setCartId(cartId)
                        .setGrouponRulesId(grouponRulesId))
                .request(new OnHttpListener<HttpData<CouponListBean>>() {

                    @Override
                    public void onSucceed(HttpData<CouponListBean> result) {
                        CouponListBean couponListBean = (CouponListBean) ((HttpData) result).getData();
                        refreshCoupon(couponListBean);
                    }

                    @Override
                    public void onFail(Exception e) {

                    }
                });
    }

    private void refreshCoupon(CouponListBean couponListBean) {
        if (couponListBean == null) {
            return;
        }
        List<CouponItemBean> list = couponListBean.getList();
        if (list == null) {
            return;
        }
        mAllCoupons.clear();
        mAllCoupons.addAll(list);
        int currentTab = mCouponSt.getCurrentTab();
        updateSelectPos(currentTab);
    }

    private void initViews(View view) {
        ImageView closeIv = view.findViewById(R.id.iv_close);
        closeIv.setOnClickListener(view1 -> dismiss());
        mCouponSt = view.findViewById(R.id.stl_coupon_list);
        mCouponRv = view.findViewById(R.id.rv_coupon);
        mCouponSt.setTabData(mTitles);
        mCouponSt.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                updateSelectPos(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mAdapter = new CouponCheckAdapter(getContext());
        mAdapter.setUserCouponId(userCouponId);
        mAdapter.setOnItemClickListener((recyclerView, itemView, position) -> {
            if (mOnCouponCheckListener != null) {
                dismiss();
                CouponItemBean couponItemBean = mCouponItemBeans.get(position);
                mOnCouponCheckListener.couponCheck(couponItemBean.getCid(),couponItemBean.getId());
            }
        });
        mAdapter.setData(mCouponItemBeans);
        mCouponRv.setAdapter(mAdapter);
    }

    private void updateSelectPos(int position) {
        mCouponItemBeans.clear();
        for (CouponItemBean couponItemBean : mAllCoupons) {
            if (position == 0 && couponItemBean.isAvailable()) {
                mCouponItemBeans.add(couponItemBean);
            }
            if (position == 1 && !couponItemBean.isAvailable()) {
                mCouponItemBeans.add(couponItemBean);
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    public interface onCouponCheckListener {

        void couponCheck(int coupontId,int userCouponId);

    }
}
