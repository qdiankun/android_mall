package com.me.slone.mall.http.response.goods;

/**
 * Author：diankun
 * Time：20-11-2 上午11:30
 * Description:
 */
public class TopicBean {

    /**
     * "id": 264,
     * "title": "设计师们推荐的应季好物",
     * "subtitle": "原创设计春款系列上新",
     * "price": 29.9,
     * "readCount": "77.7k",
     * "picUrl": "https://yanxuan.nosdn.127.net/14918201901050274.jpg"
     */

    private int id;
    private String title;
    private String subtitle;
    private float price;
    private String readCount;
    private String picUrl;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public float getPrice() {
        return price;
    }

    public String getReadCount() {
        return readCount;
    }

    public String getPicUrl() {
        return picUrl;
    }
}
