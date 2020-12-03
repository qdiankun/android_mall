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

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.OnHttpListener;
import com.me.slone.mall.R;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.AddressListApi;
import com.me.slone.mall.http.response.me.AddressBean;
import com.me.slone.mall.http.response.me.AddressListBean;
import com.me.slone.mall.ui.adapter.AddressCheckAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Author：diankun
 * Time：20-11-12 下午1:56
 * Description: 添加购物车
 */
public class AddressSheetDialog extends BottomSheetDialogFragment {

    private Context mContext;
    private View view;
    private int addressId;
    private static String ARG_ADDRESSID = "arg_addressid";
    private RecyclerView mAddressRv;
    private AddressCheckAdapter mAdapter;
    private List<AddressBean> mAddressList = new ArrayList<>();
    private onAddressClickListener mOnAddressClickListener;

    public static AddressSheetDialog getInstance(int addressId) {
        AddressSheetDialog myBottomSheetFragment = new AddressSheetDialog();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_ADDRESSID, addressId);
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
        view = inflater.inflate(R.layout.address_dialog_layout, container, false);
        initData();
        initViews(view);
        return view;
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        addressId = arguments.getInt(ARG_ADDRESSID);
        getSelectCoupon();
    }

    public void setmOnAddressClickListener(onAddressClickListener mOnAddressClickListener) {
        this.mOnAddressClickListener = mOnAddressClickListener;
    }

    private void getSelectCoupon() {
        EasyHttp.get(this)
                .api(new AddressListApi())
                .request(new OnHttpListener<HttpData<AddressListBean>>() {

                    @Override
                    public void onSucceed(HttpData<AddressListBean> result) {
                        AddressListBean addressListBean = result.getData();
                        refreshAddress(addressListBean);
                    }

                    @Override
                    public void onFail(Exception e) {

                    }
                });
    }

    private void refreshAddress(AddressListBean addressListBean) {
        if (addressListBean == null) {
            return;
        }
        List<AddressBean> list = addressListBean.getList();
        if (list == null) {
            return;
        }
        mAddressList.clear();
        mAddressList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    private void initViews(View view) {
        ImageView closeIv = view.findViewById(R.id.iv_close);
        closeIv.setOnClickListener(view1 -> dismiss());
        mAddressRv = view.findViewById(R.id.rv_address);
        mAdapter = new AddressCheckAdapter(getContext());
        mAdapter.setAddressId(addressId);
        mAdapter.setOnItemClickListener((recyclerView, itemView, position) -> {
            dismiss();
            if (mOnAddressClickListener != null) {
                mOnAddressClickListener.addressClick(mAddressList.get(position).getId());
            }
        });
        mAdapter.setData(mAddressList);
        mAddressRv.setAdapter(mAdapter);
    }


    public interface onAddressClickListener {
        void addressClick(int addressId);
    }

}
