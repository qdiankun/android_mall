package com.me.slone.mall.http.response.goodsdetail;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-5 下午2:56
 * Description:
 */
public class CommentListBean {


    /**
     * "data": [
     * {
     * "addTime": "2020-02-10 21:16:00",
     * "picList": [
     * "http://localhost:8080/wx/storage/fetch/0bowbmr9eymb0hl19rhu.jpg"
     * ],
     * "adminContent": "gggg",
     * "nickname": "slone",
     * "id": 1012,
     * "avatar": "https://yanxuan.nosdn.127.net/80841d741d7fa3073e0ae27bf487339f.jpg?imageView&quality=90&thumbnail=64x64",
     * "content": "呃呃呃呃呃呃呃呃呃"
     * },
     * {
     * "addTime": "2018-02-01 00:00:00",
     * "picList": [
     * "https://yanxuan.nosdn.127.net/218783173f303ec6d8766810951d0790.jpg"
     * ],
     * "adminContent": "",
     * "nickname": "user123",
     * "id": 1,
     * "avatar": "",
     * "content": "布料很厚实，触感不错，洗过之后不缩水不掉色"
     * }
     * ],
     * "count": 97
     */

    private List<CommentBean> data;
    private int count;

    public void setData(List<CommentBean> data) {
        this.data = data;
    }

    public List<CommentBean> getData() {
        return data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
