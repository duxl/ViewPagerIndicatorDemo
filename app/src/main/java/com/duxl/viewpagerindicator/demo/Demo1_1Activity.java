package com.duxl.viewpagerindicator.demo;

import android.view.View;
import android.widget.LinearLayout;

import com.duxl.viewpagerindicator.demo.utils.DisplayUtil;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

/**
 * 单独使用Indicator（tab左对齐）
 * create by duxl 2020/7/20
 */
public class Demo1_1Activity extends Demo1Activity {
    @Override
    protected boolean getSplitAuto() {
        return false;
    }

    @Override
    protected OnTransitionTextListener getOnTransitionTextListener() {
        return new OnTransitionTextListener(){
            @Override
            public void onTransition(View view, int position, float selectPercent) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.leftMargin = DisplayUtil.dip2px(Demo1_1Activity.this, 15);
                view.setLayoutParams(layoutParams);
                super.onTransition(view, position, selectPercent);
            }
        }.setColor(text_selectColor, text_unSelectColor).setSize(14, 14);
    }
}
