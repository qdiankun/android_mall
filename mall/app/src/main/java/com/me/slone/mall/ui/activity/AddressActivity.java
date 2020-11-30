package com.me.slone.mall.ui.activity;

import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.blankj.utilcode.util.RegexUtils;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.widget.view.SwitchButton;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.AddressAddApi;
import com.me.slone.mall.ui.dialog.AddressDialog;

public class AddressActivity extends MyActivity {

    private AppCompatTextView mAddressTv;
    private AppCompatEditText mNameEt, mPhoneEt,mAddressDetailEt;
    private SwitchButton mDefaultSb;
    /**
     * 省
     */
    private String mProvince = "";
    /**
     * 市
     */
    private String mCity = "";
    /**
     * 区
     */
    private String mArea = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_address;
    }

    @Override
    protected void initView() {
        mNameEt = findViewById(R.id.et_address_name);
        mPhoneEt = findViewById(R.id.et_address_phone);
        mAddressTv = findViewById(R.id.tv_address);
        mAddressDetailEt = findViewById(R.id.et_address_detail);
        mDefaultSb = findViewById(R.id.sb_default_switch);
        setOnClickListener(R.id.tv_address,R.id.btn_save, R.id.btn_cancel);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_cancel) {
            finish();
        } else if (id == R.id.btn_save) {
            saveAddress();
        } else if (id == R.id.tv_address){
            new AddressDialog.Builder(this)
                    //.setTitle("选择地区")
                    // 设置默认省份
                    .setProvince(mProvince)
                    // 设置默认城市（必须要先设置默认省份）
                    .setCity(mCity)
                    // 不选择县级区域
                    //.setIgnoreArea()
                    .setListener((dialog, province, city, area) -> {
                        String address = province +"/"+ city  +"/"+ area;
                        if (!mAddressTv.getText().toString().trim().equals(address)) {
                            mProvince = province;
                            mCity = city;
                            mArea = area;
                            mAddressTv.setText(address);
                        }
                    })
                    .show();
        }
    }

    private void saveAddress() {
        String name = mNameEt.getText().toString().trim();
        String phone = mPhoneEt.getText().toString().trim();
        String address = mAddressTv.getText().toString().trim();
        String addressDetail = mAddressDetailEt.getText().toString().trim();
        boolean isDefault = mDefaultSb.isChecked();
        if (TextUtils.isEmpty(name)) {
            toast(R.string.my_address_name_tip);
            return;
        }
        if (TextUtils.isEmpty(address)
                || TextUtils.isEmpty(mProvince)
                || TextUtils.isEmpty(mCity)
                || TextUtils.isEmpty(mArea)) {
            toast(R.string.my_address_localtion_tip);
            return;
        }
        if (TextUtils.isEmpty(addressDetail)) {
            toast(R.string.my_address_detail_tip);
            return;
        }
        if (!RegexUtils.isMobileSimple(phone)) {
            toast(R.string.my_address_phone_tip);
            return;
        }
        EasyHttp.post(this)
                .api(new AddressAddApi()
                        .setName(name)
                        .setTel(phone)
                        .setProvince(mProvince)
                        .setCity(mCity)
                        .setCounty(mArea)
                        .setAreaCode("110101")
                        .setAddressDetail(addressDetail)
                        .setDefault(isDefault))
                .request(new HttpCallback<HttpData<Integer>>(this) {
                    @Override
                    public void onSucceed(HttpData<Integer> result) {
                        super.onSucceed(result);
                    }
                });

    }
}