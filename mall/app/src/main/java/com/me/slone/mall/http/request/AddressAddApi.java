package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-30 上午9:59
 * Description:
 */
public class AddressAddApi implements IRequestApi {

    private String name;
    private String tel;
    private String province;
    private String city;
    private String county;
    private String areaCode;
    private String addressDetail;
    private boolean isDefault;

    @Override
    public String getApi() {
        return "address/save";
    }

    public AddressAddApi setName(String name) {
        this.name = name;
        return this;
    }

    public AddressAddApi setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public AddressAddApi setProvince(String province) {
        this.province = province;
        return this;
    }

    public AddressAddApi setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressAddApi setCounty(String county) {
        this.county = county;
        return this;
    }

    public AddressAddApi setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
        return this;
    }

    public AddressAddApi setDefault(boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    public AddressAddApi setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }
}
