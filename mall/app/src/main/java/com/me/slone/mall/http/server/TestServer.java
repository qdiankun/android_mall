package com.me.slone.mall.http.server;

import com.hjq.http.config.IRequestServer;
import com.hjq.http.model.BodyType;

/**
 * Author：diankun
 * Time：20-11-2 上午11:01
 * Description:
 */
public class TestServer implements IRequestServer {

    @Override
    public String getHost() {
        return "http://144.34.205.44:8080/";
    }

    @Override
    public String getPath() {
        return "wx/";
    }

    @Override
    public BodyType getType() {
        return BodyType.JSON;
    }

}
