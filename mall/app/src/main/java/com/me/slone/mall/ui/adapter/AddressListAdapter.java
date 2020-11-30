package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.response.me.AddressBean;
import com.me.slone.mall.widget.AmountView;

/**
 * Author：diankun
 * Time：20-11-24 下午4:55
 * Description:
 */
public class AddressListAdapter extends MyAdapter<AddressBean> {

    public AddressListAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }


    private final class ViewHolder extends MyAdapter.ViewHolder {

        private TextView nameTv,addressTv;
        private CheckBox checkCb;

        public ViewHolder() {
            super(R.layout.address_item);
        }

        @Override
        public void onBindView(int position) {
            checkCb = (CheckBox) findViewById(R.id.cb_select);
            nameTv = (TextView) findViewById(R.id.tv_address_name);
            addressTv = (TextView) findViewById(R.id.tv_address_detail);
            AddressBean addressBean = getItem(position);
            checkCb.setChecked(addressBean.isDefault());
            String name = addressBean.getName() + "  " + addressBean.getTel();
            nameTv.setText(name);
            String address = addressBean.getProvince() + addressBean.getCity()
                    + addressBean.getCounty() + addressBean.getAddressDetail();
            addressTv.setText(address);
        }
    }
}
