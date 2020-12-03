package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.response.me.AddressBean;
import com.me.slone.mall.http.response.me.CouponItemBean;

/**
 * Author：diankun
 * Time：20-11-3 下午4:02
 * Description:
 */
public class AddressCheckAdapter extends MyAdapter<AddressBean> {

    private int addressId;

    public AddressCheckAdapter(@NonNull Context context) {
        super(context);
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder {

        private TextView addressNameTv, addressDetailTv;
        private CheckBox checkCb;

        public ViewHolder() {
            super(R.layout.address_checkout_item);
        }

        @Override
        public void onBindView(int position) {
            addressNameTv = (TextView) findViewById(R.id.tv_address_name);
            addressDetailTv = (TextView) findViewById(R.id.tv_address_detail);
            checkCb = (CheckBox) findViewById(R.id.cb_select);

            AddressBean addressBean = getItem(position);
            String name = addressBean.getName() + " " + addressBean.getTel();
            String address = new StringBuffer()
                    .append(addressBean.getProvince())
                    .append(addressBean.getCity())
                    .append(addressBean.getCounty())
                    .append(addressBean.getAddressDetail())
                    .toString();
            addressNameTv.setText(name);
            addressDetailTv.setText(address);
            if (addressBean.getId() == addressId) {
                checkCb.setChecked(true);
            } else {
                checkCb.setChecked(false);
            }
        }
    }

}
