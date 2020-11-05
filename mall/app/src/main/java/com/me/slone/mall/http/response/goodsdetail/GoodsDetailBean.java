package com.me.slone.mall.http.response.goodsdetail;

import com.me.slone.mall.http.response.goods.BrandBean;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-5 下午2:36
 * Description: 商品详情
 */
public class GoodsDetailBean {

    private List<SpecificationListBean> specificationList;
    private List<GrouponDetailBean> groupon;
    private List<IssueBean> issue;
    private int userHasCollect;
    private String shareImage;
    private CommentListBean comment;
    private boolean share;
    private List<AttibuteBean> attribute;
    private BrandBean brand;
    private List<ProductBean> productList;
    private GoodsDetailInfoBean info;

    public void setSpecificationList(List<SpecificationListBean> specificationList) {
        this.specificationList = specificationList;
    }

    public void setGroupon(List<GrouponDetailBean> groupon) {
        this.groupon = groupon;
    }

    public void setIssue(List<IssueBean> issue) {
        this.issue = issue;
    }

    public void setUserHasCollect(int userHasCollect) {
        this.userHasCollect = userHasCollect;
    }

    public void setShareImage(String shareImage) {
        this.shareImage = shareImage;
    }

    public void setComment(CommentListBean comment) {
        this.comment = comment;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public void setAttribute(List<AttibuteBean> attribute) {
        this.attribute = attribute;
    }

    public void setBrand(BrandBean brand) {
        this.brand = brand;
    }

    public void setProductList(List<ProductBean> productList) {
        this.productList = productList;
    }

    public void setInfo(GoodsDetailInfoBean info) {
        this.info = info;
    }

    public List<SpecificationListBean> getSpecificationList() {
        return specificationList;
    }

    public List<GrouponDetailBean> getGroupon() {
        return groupon;
    }

    public List<IssueBean> getIssue() {
        return issue;
    }

    public int getUserHasCollect() {
        return userHasCollect;
    }

    public String getShareImage() {
        return shareImage;
    }

    public CommentListBean getComment() {
        return comment;
    }

    public boolean isShare() {
        return share;
    }

    public List<AttibuteBean> getAttribute() {
        return attribute;
    }

    public BrandBean getBrand() {
        return brand;
    }

    public List<ProductBean> getProductList() {
        return productList;
    }

    public GoodsDetailInfoBean getInfo() {
        return info;
    }
}
