package com.me.slone.mall.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * Author：diankun
 * Time：20-11-17 下午2:56
 * Description: 分类列表
 */
public class CategoryListApi implements IRequestApi {

    private int categoryId;

    @Override
    public String getApi() {
        return "goods/list";
    }

    public CategoryListApi setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
