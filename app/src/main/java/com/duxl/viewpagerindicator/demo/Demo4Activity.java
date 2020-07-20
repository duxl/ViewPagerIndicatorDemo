package com.duxl.viewpagerindicator.demo;

import androidx.core.content.ContextCompat;

import com.duxl.viewpagerindicator.demo.utils.DisplayUtil;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

/**
 * 下划线样式（等于tab宽度）
 * create by duxl 2020/7/20
 */
public class Demo4Activity extends Demo2Activity {

    @Override
    protected void initTab() {
        mIndicatorView.setOnTransitionListener(new OnTransitionTextListener()
                .setColor(ContextCompat.getColor(this, R.color.text_selectColor), ContextCompat.getColor(this, R.color.text_unSelectColor))
                .setSize(13, 13));

        ColorBar colorBar = new ColorBar(this, ContextCompat.getColor(this, R.color.text_selectColor), DisplayUtil.dip2px(this, 1));
        colorBar.setWidth(getTabWidth());
        mIndicatorView.setScrollBar(colorBar);
    }

    public int getTabWidth() {
        return 0;
    }
}
