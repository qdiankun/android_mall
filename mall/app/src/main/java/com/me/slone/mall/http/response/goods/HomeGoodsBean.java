package com.me.slone.mall.http.response.goods;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-2 上午11:20
 * Description:首页商品
 */
public class HomeGoodsBean {

    private List<GoodsBean> newGoodsList;
    private List<CouponBean> couponList;
    private List<ChannelBean> channel;
    private List<GroupBean> grouponList;
    private List<BannerBean> banner;
    private List<BrandBean> brandList;
    private List<HotGoodsBean> hotGoodsList;
    private List<TopicBean> topicList;
    private List<FloorGoodsBean> floorGoodsList;

    public void setNewGoodsList(List<GoodsBean> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public void setCouponList(List<CouponBean> couponList) {
        this.couponList = couponList;
    }

    public void setChannel(List<ChannelBean> channel) {
        this.channel = channel;
    }

    public void setGrouponList(List<GroupBean> grouponList) {
        this.grouponList = grouponList;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public void setBrandList(List<BrandBean> brandList) {
        this.brandList = brandList;
    }

    public void setHotGoodsList(List<HotGoodsBean> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public void setTopicList(List<TopicBean> topicList) {
        this.topicList = topicList;
    }

    public void setFloorGoodsList(List<FloorGoodsBean> floorGoodsList) {
        this.floorGoodsList = floorGoodsList;
    }

    public List<GoodsBean> getNewGoodsList() {
        return newGoodsList;
    }

    public List<CouponBean> getCouponList() {
        return couponList;
    }

    public List<ChannelBean> getChannel() {
        return channel;
    }

    public List<GroupBean> getGrouponList() {
        return grouponList;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public List<BrandBean> getBrandList() {
        return brandList;
    }

    public List<HotGoodsBean> getHotGoodsList() {
        return hotGoodsList;
    }

    public List<TopicBean> getTopicList() {
        return topicList;
    }

    public List<FloorGoodsBean> getFloorGoodsList() {
        return floorGoodsList;
    }
}
