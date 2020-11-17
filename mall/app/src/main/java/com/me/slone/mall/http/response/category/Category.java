package com.me.slone.mall.http.response.category;

import java.io.Serializable;

/**
 * Author：diankun
 * Time：20-11-17 上午10:13
 * Description:
 */
public class Category implements Serializable {

    /**
     * "id": 1005010,
     * "name": "炒货",
     * "keywords": "",
     * "desc": "精选原产地，美味加营养",
     * "pid": 1005002,
     * "iconUrl": "http://yanxuan.nosdn.127.net/6c43063003207168c1d8e83a923e8515.png",
     * "picUrl": "http://yanxuan.nosdn.127.net/3972963a4b6f9588262d2a667f4c1c73.png",
     * "level": "L2",
     * "sortOrder": 5,
     * "addTime": "2018-02-01 00:00:00",
     * "updateTime": "2018-02-01 00:00:00",
     * "deleted": false
     */

    private int id;
    private String name;
    private String keywords;
    private String desc;
    private int pid;
    private String iconUrl;
    private String picUrl;
    private String level;
    private int sortOrder;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getDesc() {
        return desc;
    }

    public int getPid() {
        return pid;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getLevel() {
        return level;
    }

    public int getSortOrder() {
        return sortOrder;
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

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
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
