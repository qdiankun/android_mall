package com.me.slone.mall.http.response.category;

import java.util.List;
import java.util.Map;

/**
 * Author：diankun
 * Time：20-11-17 上午10:15
 * Description:
 */
public class GoodCategory {

    private Map<String,List<Category>> allList;
    private Category currentCategory;
    private List<Category> categoryList;
    private List<Category> currentSubCategory;

    public Map<String, List<Category>> getAllList() {
        return allList;
    }

    public void setAllList(Map<String, List<Category>> allList) {
        this.allList = allList;
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void setCurrentSubCategory(List<Category> currentSubCategory) {
        this.currentSubCategory = currentSubCategory;
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public List<Category> getCurrentSubCategory() {
        return currentSubCategory;
    }
}
