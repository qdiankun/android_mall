package com.me.slone.mall.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.me.slone.mall.R;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.goodsdetail.ProductBean;
import com.me.slone.mall.widget.AmountView;

import java.util.ArrayList;


/**
 * Author：diankun
 * Time：20-11-12 下午1:56
 * Description:
 */
public class MyBottomSheetFragment extends BottomSheetDialogFragment {

    private Context mContext;
    private TextView priceTv,specificationTv;
    private View view;
    private AmountView amountView;
    private ArrayList<ProductBean> productBeans;
    private static String ARG_PRODUCTS = "arg_products";

    public static MyBottomSheetFragment getInstance(ArrayList<ProductBean> productBeans) {
        MyBottomSheetFragment myBottomSheetFragment = new MyBottomSheetFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_PRODUCTS,productBeans);
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
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            bottomSheet.setLayoutParams(layoutParams);

            //peekHeight即弹窗的最大高度
            final BottomSheetBehavior<FrameLayout> behavior = BottomSheetBehavior.from(bottomSheet);
            behavior.setPeekHeight(getPeekHeight());
            // 初始为展开状态
            behavior.setState(BottomSheetBehavior.STATE_DRAGGING);
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
        return peekHeight - peekHeight / 2;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        Log.e("TAG", "onCreateView: ");
        view = inflater.inflate(R.layout.bottomsheet_layout, container, false);
        initData();
        initViews(view);
        return view;
    }

    private void initData() {
        Bundle arguments = getArguments();
        if(arguments == null){
            return;
        }
        productBeans = (ArrayList<ProductBean>) arguments.getSerializable(ARG_PRODUCTS);
    }

    private void initViews(View view) {
        ProductBean productBean = productBeans.get(0);

        amountView = view.findViewById(R.id.amount_view);
        priceTv = view.findViewById(R.id.tv_price);
        specificationTv = view.findViewById(R.id.tv_specification);
        priceTv.setText("价格：¥ "+productBean.getPrice());
        specificationTv.setText("已选择： "+productBean.getSpecifications().get(0));
        ImageView closeIv = view.findViewById(R.id.iv_close);
        closeIv.setOnClickListener(view1 -> dismiss());
        ImageView productIv = view.findViewById(R.id.iv_product);
        GlideApp.with(getContext())
                .load(productBean.getUrl())
                .transform(new RoundedCorners((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, this.getResources().getDisplayMetrics())))
                .into(productIv);
    }

}
