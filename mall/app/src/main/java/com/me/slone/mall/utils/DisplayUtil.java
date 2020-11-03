package com.me.slone.mall.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Author：diankun
 * Time：20-11-3 下午3:28
 * Description:
 */
public class DisplayUtil {


    /**
     * 获取屏幕显示内容像素宽度（不包括虚拟按键的高度）
     * @param context
     * @return 屏幕显示内容像素宽度
     */
    public static int getScreenContentWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * 获取屏幕显示内容像素高度（不包括虚拟按键的高度）
     * @param context
     * @return 屏幕显示内容像素高度
     */
    public static int getScreenContentHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

}
