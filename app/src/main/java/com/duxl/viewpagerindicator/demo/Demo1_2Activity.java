package com.duxl.viewpagerindicator.demo;

import android.view.View;
import android.widget.LinearLayout;

import com.duxl.viewpagerindicator.demo.utils.DataUtil;
import com.duxl.viewpagerindicator.demo.utils.DisplayUtil;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.util.List;

/**
 * 单独使用Indicator（tab居中对齐）
 * create by duxl 2020/7/20
 */
public class Demo1_2Activity extends Demo1Activity {

    @Override
    public void initView() {
        super.initView();
        int height = DisplayUtil.dip2px(Demo1_2Activity.this, 40);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, height);
        mIndicatorView.setLayoutParams(layoutParams);
    }

    @Override
    protected List<String> getData() {
        return DataUtil.getItemC();
    }

    @Override
    protected boolean getSplitAuto() {
        return false;
    }

    @Override
    protected OnTransitionTextListener getOnTransitionTextListener() {
        return new OnTransitionTextListener() {
            @Override
            public void onTransition(View view, int position, float selectPercent) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.leftMargin = DisplayUtil.dip2px(Demo1_2Activity.this, 15);
                layoutParams.rightMargin = DisplayUtil.dip2px(Demo1_2Activity.this, 15);
                view.setLayoutParams(layoutParams);
                super.onTransition(view, position, selectPercent);
            }
        }.setColor(text_selectColor, text_unSelectColor).setSize(14, 14);
    }
}
