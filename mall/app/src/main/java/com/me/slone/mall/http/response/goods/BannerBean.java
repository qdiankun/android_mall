package com.me.slone.mall.http.response.goods;

/**
 * Author：diankun
 * Time：20-11-2 上午11:27
 * Description:
 */
public class BannerBean {

    /**
     * "id": 1,
     * "name": "合作 谁是你的菜",
     * "link": "",
     * "url": "http://yanxuan.nosdn.127.net/65091eebc48899298171c2eb6696fe27.jpg",
     * "position": 1,
     * "content": "合作 谁是你的菜",
     * "enabled": true,
     * "addTime": "2018-02-01 00:00:00",
     * "updateTime": "2018-02-01 00:00:00",
     * "deleted": false
     */
    private int id;
    private String name;
    private String link;
    private String url;
    private int position;
    private String content;
    private boolean enabled;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public String getLink() {
        return link;
    }

    public String getUrl() {
        return url;
    }

    public int getPosition() {
        return position;
    }

    public String getContent() {
        return content;
    }

    public boolean isEnabled() {
        return enabled;
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

