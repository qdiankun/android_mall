package com.me.slone.mall.http.response.goodsdetail;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-5 下午2:49
 * Description:
 */
public class SpecificationListBean {

    private String name;
    private List<SpecificationBean> valueList;

    public void setName(String name) {
        this.name = name;
    }

    public void setValueList(List<SpecificationBean> valueList) {
        this.valueList = valueList;
    }

    public String getName() {
        return name;
    }

    public List<SpecificationBean> getValueList() {
        return valueList;
    }
}
