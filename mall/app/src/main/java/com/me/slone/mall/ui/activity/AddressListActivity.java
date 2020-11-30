package com.me.slone.mall.ui.activity;

import android.location.Address;
import android.view.View;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.AddressListApi;
import com.me.slone.mall.http.response.me.AddressListBean;

public class AddressListActivity extends MyActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_addresslist;
    }

    @Override
    protected void initView() {

        setOnClickListener(R.id.btn_addaddress);
    }

    @Override
    protected void initData() {
        getAddressList();
    }

    private void getAddressList() {
        EasyHttp.get(this)
                .api(new AddressListApi())
                .request(new HttpCallback<HttpData<AddressListBean>>(this) {
                    @Override
                    public void onSucceed(HttpData result) {
                        super.onSucceed(result);
                    }
                });
    }

    private void showAddressDialog() {
//            new AddressDialog.Builder(getContext())
//                    //.setTitle("选择地区")
//                    // 设置默认省份
//                    .setProvince(mProvince)
//                    // 设置默认城市（必须要先设置默认省份）
//                    .setCity(mCity)
//                    // 不选择县级区域
//                    //.setIgnoreArea()
//                    .setListener((dialog, province, city, area) -> {
//                        String address = province + city + area;
//                        if (!mAddressView.getRightText().equals(address)) {
//                            mProvince = province;
//                            mCity = city;
//                            mArea = area;
//                            mAddressView.setRightText(address);
//                        }
//                    })
//                    .show();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_addaddress) {
            startActivity(AddressActivity.class);
        }
    }
}