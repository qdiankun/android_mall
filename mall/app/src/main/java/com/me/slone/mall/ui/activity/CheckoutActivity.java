package com.me.slone.mall.ui.activity;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.CheckoutApi;
import com.me.slone.mall.http.response.cart.CheckedAddress;
import com.me.slone.mall.http.response.cart.CheckedBean;
import com.me.slone.mall.http.response.cart.CheckedGoodsBean;
import com.me.slone.mall.ui.adapter.CheckListAdapter;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends MyActivity {

    private TextView mAddressNameTv, mAddressDetailTv, mCouponTv, mTotalPrice;
    private TextView mostAgeTv, mCouponPriceTv,mRealPrice;
    private CheckedBean mCheckedBean;
    private RecyclerView mCheckedRv;
    private CheckListAdapter mCheckListAdapter;
    private List<CheckedGoodsBean> mList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_checkout;
    }

    @Override

    protected void initView() {
        mAddressNameTv = findViewById(R.id.tv_address_name);
        mAddressDetailTv = findViewById(R.id.tv_address_detail);
        mCouponTv = findViewById(R.id.tv_coupon);
        mCheckedRv = findViewById(R.id.rv_checked);
        mTotalPrice = findViewById(R.id.tv_totoalprice);
        mostAgeTv = findViewById(R.id.tv_postage);
        mCouponPriceTv = findViewById(R.id.tv_coupon_price);
        mRealPrice= findViewById(R.id.tv_realprice);
        mCheckListAdapter = new CheckListAdapter(this);
        mCheckListAdapter.setData(mList);
        mCheckedRv.setAdapter(mCheckListAdapter);
    }

    @Override
    protected void initData() {
        getCheckout();
    }

    private void getCheckout() {
        EasyHttp.get(this)
                .api(new CheckoutApi())
                .request(new HttpCallback<HttpData<CheckedBean>>(this) {
                    @Override
                    public void onSucceed(HttpData<CheckedBean> result) {
                        super.onSucceed(result);
                        if (result.getData() == null) {
                            return;
                        }
                        mCheckedBean = result.getData();
                        refreshAddress();
                        refreshCoupon();
                        refreshGoods();
                        refreshCost();
                    }
                });
    }

    private void refreshCost() {
        mTotalPrice.setText("¥" + mCheckedBean.getGoodsTotalPrice());
        mostAgeTv.setText("¥" + mCheckedBean.getFreightPrice());
        mCouponPriceTv.setText("-¥" + mCheckedBean.getCouponPrice());
        mRealPrice.setText("¥"+mCheckedBean.getActualPrice());
    }

    private void refreshGoods() {
        List<CheckedGoodsBean> checkedGoodsList = mCheckedBean.getCheckedGoodsList();
        if (checkedGoodsList == null) {
            return;
        }
        mList.clear();
        mList.addAll(checkedGoodsList);
        mCheckListAdapter.notifyDataSetChanged();
    }

    private void refreshCoupon() {
        int couponPrice = mCheckedBean.getCouponPrice();
        if (couponPrice > 0) {
            mCouponTv.setText("-¥" + couponPrice);
        }
    }

    private void refreshAddress() {
        CheckedAddress checkedAddress = mCheckedBean.getCheckedAddress();
        if (checkedAddress != null) {
            String name = checkedAddress.getName() + " " + checkedAddress.getTel();
            mAddressNameTv.setText(name);
            String address = checkedAddress.getProvince() + checkedAddress.getCity()
                    + checkedAddress.getCounty() + checkedAddress.getAddressDetail();
            mAddressDetailTv.setText(address);
        }
    }

}