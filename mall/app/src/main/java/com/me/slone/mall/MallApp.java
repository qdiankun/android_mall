package com.me.slone.mall;

import android.app.Application;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.hjq.bar.TitleBar;
import com.hjq.bar.style.TitleBarLightStyle;
import com.hjq.http.EasyConfig;
import com.hjq.http.config.IRequestServer;
import com.hjq.toast.ToastInterceptor;
import com.hjq.toast.ToastUtils;
import com.me.slone.mall.http.model.RequestHandler;
import com.me.slone.mall.http.server.TestServer;
import com.me.slone.mall.other.AppConfig;
import com.me.slone.mall.other.CrashHandler;

import okhttp3.OkHttpClient;

/**
 * Author：diankun
 * Time：20-10-29 下午4:52
 * Description: mall application
 */
public class MallApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initSdk(this);

        initNetWork(this);
    }

    private void initNetWork(MallApp mallApp) {
        IRequestServer server;
        if (AppConfig.isDebug()) {
            server = new TestServer();
        } else {
            server = new TestServer();
        }
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        EasyConfig.with(okHttpClient)
                // 是否打印日志
                .setLogEnabled(BuildConfig.DEBUG)
                // 设置服务器配置
                .setServer(server)
                // 设置请求处理策略
                .setHandler(new RequestHandler(mallApp))
                // 设置请求重试次数
                .setRetryCount(3)
                // 添加全局请求参数
                //.addParam("token", "6666666")
                // 添加全局请求头
                //.addHeader("time", "20191030")
                // 启用配置
                .into();
    }

    private void initSdk(MallApp application) {

        // 吐司工具类
        ToastUtils.init(application);
        // 设置 Toast 拦截器
        ToastUtils.setToastInterceptor(new ToastInterceptor() {
            @Override
            public boolean intercept(Toast toast, CharSequence text) {
                boolean intercept = super.intercept(toast, text);
                if (intercept) {
                    Log.e("Toast", "空 Toast");
                } else {
                    Log.i("Toast", text.toString());
                }
                return intercept;
            }
        });

        // 初始化标题栏全局样式
        TitleBar.initStyle(new TitleBarLightStyle(application) {

            @Override
            public Drawable getBackground() {
                return new ColorDrawable(ContextCompat.getColor(application, R.color.white));
            }

            @Override
            public Drawable getBackIcon() {
                return getDrawable(R.drawable.arrows_left_ic);
            }
        });

        // 本地异常捕捉
        CrashHandler.register(application);

    }
}
