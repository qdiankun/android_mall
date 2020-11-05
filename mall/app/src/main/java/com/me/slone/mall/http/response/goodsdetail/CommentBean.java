package com.me.slone.mall.http.response.goodsdetail;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-5 下午2:51
 * Description:评论
 */
public class CommentBean {

    /**
     * "addTime": "2020-02-10 21:16:00",
     * "picList": [
     * "http://localhost:8080/wx/storage/fetch/0bowbmr9eymb0hl19rhu.jpg"
     * ],
     * "adminContent": "gggg",
     * "nickname": "slone",
     * "id": 1012,
     * "avatar": "https://yanxuan.nosdn.127.net/80841d741d7fa3073e0ae27bf487339f.jpg?imageView&quality=90&thumbnail=64x64",
     * "content": "呃呃呃呃呃呃呃呃呃"
     */

    private String addTime;
    private List<String> picList;
    private String adminContent;
    private String nickname;
    private int id;
    private String avatar;
    private String content;

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public void setAdminContent(String adminContent) {
        this.adminContent = adminContent;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddTime() {
        return addTime;
    }

    public List<String> getPicList() {
        return picList;
    }

    public String getAdminContent() {
        return adminContent;
    }

    public String getNickname() {
        return nickname;
    }

    public int getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getContent() {
        return content;
    }
}
