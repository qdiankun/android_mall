package com.me.slone.mall.http.response.goods;

/**
 * Author：diankun
 * Time：20-11-2 上午11:23
 * Description:
 */
public class ChannelBean {

    /**
     * "id": 1005000,
     * "name": "居家",
     * "iconUrl": "http://yanxuan.nosdn.127.net/a45c2c262a476fea0b9fc684fed91ef5.png"
     */

    private int id;
    private String name;
    private String iconUrl;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}
