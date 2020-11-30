package com.me.slone.mall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.hjq.base.BaseAdapter;
import com.hjq.base.BaseDialog;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.AddressAddApi;
import com.me.slone.mall.http.request.AddressDeleteApi;
import com.me.slone.mall.http.request.AddressListApi;
import com.me.slone.mall.http.response.me.AddressBean;
import com.me.slone.mall.http.response.me.AddressListBean;
import com.me.slone.mall.ui.adapter.AddressListAdapter;
import com.me.slone.mall.ui.dialog.MessageDialog;

import java.util.ArrayList;
import java.util.List;

import static com.me.slone.mall.common.Constants.RESULT_ADDRESS_ADD;
import static com.me.slone.mall.common.Constants.RESULT_ADDRESS_UPDATE;

public class AddressListActivity extends MyActivity {

    private RecyclerView mAddressRv;
    private AddressListAdapter mAddressListAdapter;
    private List<AddressBean> mList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_addresslist;
    }

    @Override
    protected void initView() {
        mAddressRv = findViewById(R.id.rl_addresslist);
        mAddressListAdapter = new AddressListAdapter(this);
        mAddressListAdapter.setData(mList);
        mAddressListAdapter.setOnItemClickListener((recyclerView, itemView, position) -> {
            Intent intent = new Intent(AddressListActivity.this,AddressActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(AddressActivity.ARG_ADDRESS,mList.get(position));
            intent.putExtras(bundle);
            startActivityForResult(intent,bundle, (resultCode, data) -> {
                if (RESULT_ADDRESS_UPDATE == resultCode) {
                    initData();
                }
            });
        });
        mAddressListAdapter.setOnItemLongClickListener((recyclerView, itemView, position) -> {
            AddressBean addressBean = mList.get(position);
            showDeleteDialog(addressBean);
            return false;
        });
        mAddressListAdapter.setOnChildClickListener(R.id.cb_select, (recyclerView, childView, position) -> {
            CheckBox checkBox = (CheckBox) childView;
            if (checkBox.isChecked()) {
                updateAddress(mList.get(position));
            }
        });
        mAddressRv.setAdapter(mAddressListAdapter);
        setOnClickListener(R.id.btn_addaddress);
    }

    private void showDeleteDialog(AddressBean addressBean) {
        // 消息对话框
        new MessageDialog.Builder(this)
                // 内容必须要填写
                .setMessage(getString(R.string.my_address_delete_tip))
                // 确定按钮文本
                .setConfirm(getString(R.string.common_confirm))
                // 设置 null 表示不显示取消按钮
                .setCancel(getString(R.string.common_cancel))
                // 设置点击按钮后不关闭对话框
                //.setAutoDismiss(false)
                .setListener(dialog -> deleteAddress(addressBean))
                .show();
    }

    private void deleteAddress(AddressBean addressBean) {
        EasyHttp.post(this)
                .api(new AddressDeleteApi()
                        .setId(addressBean.getId()))
                .request(new HttpCallback<HttpData<Void>>(this) {
                    @Override
                    public void onSucceed(HttpData<Void> result) {
                        super.onSucceed(result);
                        initData();
                    }
                });
    }

    private void updateAddress(AddressBean addressBean) {
        EasyHttp.post(this)
                .api(new AddressAddApi()
                        .setId(addressBean.getId())
                        .setName(addressBean.getName())
                        .setTel(addressBean.getTel())
                        .setProvince(addressBean.getProvince())
                        .setCity(addressBean.getCity())
                        .setCounty(addressBean.getCounty())
                        .setAreaCode(addressBean.getAreaCode())
                        .setAddressDetail(addressBean.getAddressDetail())
                        .setDefault(true)
                )
                .request(new HttpCallback<HttpData<Integer>>(this) {
                    @Override
                    public void onSucceed(HttpData<Integer> result) {
                        super.onSucceed(result);
                        initData();
                    }
                });
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
                    public void onSucceed(HttpData<AddressListBean> result) {
                        super.onSucceed(result);
                        refreshAddress(result.getData());
                    }
                });
    }

    private void refreshAddress(AddressListBean addressListBean) {
        if (addressListBean == null) {
            return;
        }
        mList.clear();
        mList.addAll(addressListBean.getList());
        mAddressListAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_addaddress) {
            startActivityForResult(AddressActivity.class, (resultCode, data) -> {
                if (RESULT_ADDRESS_ADD == resultCode) {
                    initData();
                }
            });
        }
    }
}