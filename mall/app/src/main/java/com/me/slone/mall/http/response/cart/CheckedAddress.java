package com.me.slone.mall.http.response.cart;

/**
 * Author：diankun
 * Time：20-12-2 上午11:34
 * Description:
 */
public class CheckedAddress {

    /**
     *             "id": 6,
     *             "name": "c++java",
     *             "userId": 6,
     *             "province": "山东省",
     *             "city": "济南市",
     *             "county": "天桥区",
     *             "addressDetail": "小区",
     *             "areaCode": "123456",
     *             "tel": "15262737894",
     *             "isDefault": true,
     *             "addTime": "2020-11-30 14:37:49",
     *             "updateTime": "2020-11-30 15:28:25",
     *             "deleted": false
     */
    private int id;
    private String name;
    private int userId;
    private String province;
    private String city;
    private String county;
    private String addressDetail;
    private String areaCode;
    private String tel;
    private boolean isDefault;
    private String addTime;
    private String updateTime;
    private boolean deleted;

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
}
