package com.me.slone.mall;

import android.app.Application;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.hjq.bar.TitleBar;
import com.hjq.bar.style.TitleBarLightStyle;
import com.hjq.toast.ToastInterceptor;
import com.hjq.toast.ToastUtils;
import com.me.slone.mall.other.CrashHandler;

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
                return new ColorDrawable(ContextCompat.getColor(application, R.color.colorPrimary));
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
