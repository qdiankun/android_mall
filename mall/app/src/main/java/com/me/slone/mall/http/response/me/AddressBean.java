package com.me.slone.mall.http.response.me;

import java.io.Serializable;

/**
 * Author：diankun
 * Time：20-11-30 上午9:57
 * Description: 地址
 */
public class AddressBean implements Serializable {
    /**
     *                 "id": 2,
     *                 "name": "java",
     *                 "userId": 3,
     *                 "province": "黑龙江省",
     *                 "city": "哈尔滨市",
     *                 "county": "道里区",
     *                 "addressDetail": "测试",
     *                 "areaCode": "230102",
     *                 "postalCode": "",
     *                 "tel": "15262737892",
     *                 "isDefault": true,
     *                 "addTime": "2020-11-30 09:52:49",
     *                 "updateTime": "2020-11-30 09:52:49",
     *                 "deleted": false
     */
    private int id;
    private String name;
    private int userId;
    private String province;
    private String city;
    private String county;
    private String addressDetail;
    private String areaCode;
    private String postalCode;
    private String tel;
    private boolean isDefault;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getTel() {
        return tel;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public String getAddTime() {
        return addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
