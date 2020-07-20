package com.duxl.viewpagerindicator.demo.utils;

import android.content.Context;

/**
 * TODO desc
 * create by duxl 2020/7/20
 */
public class DisplayUtil {

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
