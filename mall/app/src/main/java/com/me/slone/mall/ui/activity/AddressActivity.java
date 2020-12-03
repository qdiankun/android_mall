package com.me.slone.mall.ui.activity;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.google.gson.Gson;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.widget.view.SwitchButton;
import com.me.slone.mall.R;
import com.me.slone.mall.bean.JsonBean;
import com.me.slone.mall.common.Constants;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.AddressAddApi;
import com.me.slone.mall.http.response.me.AddressBean;
import com.me.slone.mall.ui.dialog.AddressDialog;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class AddressActivity extends MyActivity {

    private AppCompatTextView mAddressTv;
    private AppCompatEditText mNameEt, mPhoneEt, mAddressDetailEt, mAddressCodeEt;
    private SwitchButton mDefaultSb;
    private List<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();

    public static String ARG_ADDRESS = "arg_address";
    private AddressBean mAddressBean;
    private String mProvince = "";
    private String mCity = "";
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
        mAddressCodeEt = findViewById(R.id.et_address_code);
        mDefaultSb = findViewById(R.id.sb_default_switch);
        setOnClickListener(R.id.tv_address, R.id.btn_save, R.id.btn_cancel);
    }

    @Override
    protected void initData() {
        if(getIntent().getExtras() == null){
            return;
        }
        mAddressBean = (AddressBean) getIntent().getExtras().get(ARG_ADDRESS);
        if (mAddressBean != null) {
            mNameEt.setText(mAddressBean.getName());
            mPhoneEt.setText(mAddressBean.getTel());
            String address = mAddressBean.getProvince() + "/" + mAddressBean.getCity()
                    + "/" + mAddressBean.getCounty();
            mAddressTv.setText(address);
            mAddressCodeEt.setText(mAddressBean.getAreaCode());
            mProvince = mAddressBean.getProvince();
            mCity = mAddressBean.getCity();
            mArea = mAddressBean.getCounty();
            mAddressDetailEt.setText(mAddressBean.getAddressDetail());
            mDefaultSb.setChecked(mAddressBean.isDefault());
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_cancel) {
            finish();
        } else if (id == R.id.btn_save) {
            saveAddress();
        } else if (id == R.id.tv_address) {
//            showProvinceDialog();
            showPickerView();
        }
    }

    private void showProvinceDialog() {
        new AddressDialog.Builder(this)
                //.setTitle("选择地区")
                // 设置默认省份
                .setProvince(mProvince)
                // 设置默认城市（必须要先设置默认省份）
                .setCity(mCity)
                // 不选择县级区域
                //.setIgnoreArea()
                .setListener((dialog, province, city, area) -> {
                    String address = province + "/" + city + "/" + area;
                    if (!mAddressTv.getText().toString().trim().equals(address)) {
                        mProvince = province;
                        mCity = city;
                        mArea = area;
                        mAddressTv.setText(address);
                    }
                })
                .show();
    }


    private void showPickerView() {// 弹出选择器
        initJsonData();
        if (options1Items.isEmpty()) {
            return;
        }
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String province = options1Items.size() > 0 ?
                        options1Items.get(options1).getPickerViewText() : "";

                String city = options2Items.size() > 0
                        && options2Items.get(options1).size() > 0 ?
                        options2Items.get(options1).get(options2) : "";

                String area = options2Items.size() > 0
                        && options3Items.get(options1).size() > 0
                        && options3Items.get(options1).get(options2).size() > 0 ?
                        options3Items.get(options1).get(options2).get(options3) : "";

                String address = province + "/" + city + "/" + area;
                if (!mAddressTv.getText().toString().trim().equals(address)) {
                    mProvince = province;
                    mCity = city;
                    mArea = area;
                    mAddressTv.setText(address);
                }
            }
        })
                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();
        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private void initJsonData() {//解析数据

        //获取assets目录下的json文件数据
        String JsonData = ResourceUtils.readAssets2String("province.json");
        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> cityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String cityName = jsonBean.get(i).getCityList().get(c).getName();
                cityList.add(cityName);//添加城市
                ArrayList<String> city_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                /*if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    city_AreaList.add("");
                } else {
                    city_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                }*/
                city_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                province_AreaList.add(city_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(cityList);

            /**
             * 添加地区数据
             */
            options3Items.add(province_AreaList);
        }


    }

    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }


    private void saveAddress() {
        String name = mNameEt.getText().toString().trim();
        String phone = mPhoneEt.getText().toString().trim();
        String code = mAddressCodeEt.getText().toString().trim();
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
        if (TextUtils.isEmpty(code)) {
            toast(R.string.my_address_code_tip);
            return;
        }
        EasyHttp.post(this)
                .api(new AddressAddApi()
                        .setId(mAddressBean != null ? mAddressBean.getId() : 0)
                        .setName(name)
                        .setTel(phone)
                        .setProvince(mProvince)
                        .setCity(mCity)
                        .setCounty(mArea)
                        .setAreaCode(code)
                        .setAddressDetail(addressDetail)
                        .setDefault(isDefault))
                .request(new HttpCallback<HttpData<Integer>>(this) {
                    @Override
                    public void onSucceed(HttpData<Integer> result) {
                        if (mAddressBean != null) {
                            setResult(Constants.RESULT_ADDRESS_UPDATE);
                        } else {
                            setResult(Constants.RESULT_ADDRESS_ADD);
                        }
                        finish();
                    }
                });

    }
}