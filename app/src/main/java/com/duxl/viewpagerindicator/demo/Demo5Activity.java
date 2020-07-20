package com.duxl.viewpagerindicator.demo;

import com.duxl.viewpagerindicator.demo.utils.DisplayUtil;

/**
 * 下划线样式（固定tab宽度）
 * create by duxl 2020/7/20
 */
public class Demo5Activity extends Demo4Activity {


    @Override
    public int getTabWidth() {
        return DisplayUtil.dip2px(this, 20);
    }
}
