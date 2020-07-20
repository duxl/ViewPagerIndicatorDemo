package com.duxl.viewpagerindicator.demo;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;

import com.duxl.viewpagerindicator.demo.utils.DisplayUtil;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

/**
 * 背景色样式
 * create by duxl 2020/7/20
 */
public class Demo3Activity extends Demo2Activity {

    @Override
    public void initView() {
        super.initView();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                DisplayUtil.dip2px(this, 50)
        );
        mIndicatorView.setLayoutParams(layoutParams);
    }

    @Override
    protected void initTab() {
        mIndicatorView.setBackgroundColor(Color.parseColor("#234577"));
        mIndicatorView.setOnTransitionListener(new OnTransitionTextListener() {
            @Override
            public void onTransition(View view, int position, float selectPercent) {
                if (position == mIndicatorView.getCurrentItem()) {
                    view.setBackgroundResource(R.drawable.shape_radius100_64a2ff);
                } else {
                    view.setBackgroundResource(R.drawable.shape_radius100_e2e2e2);
                }

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int dp7 = DisplayUtil.dip2px(Demo3Activity.this, 7);
                layoutParams.topMargin = layoutParams.bottomMargin = dp7;
                if (position == 0) {
                    layoutParams.leftMargin = dp7 * 2;
                    layoutParams.rightMargin = dp7;
                } else if (position == mViewPager.getAdapter().getCount() - 1) {
                    layoutParams.leftMargin = dp7;
                    layoutParams.rightMargin = dp7 * 2;
                } else {
                    layoutParams.leftMargin = dp7;
                    layoutParams.rightMargin = dp7;
                }
                view.setLayoutParams(layoutParams);

                super.onTransition(view, position, selectPercent);
            }
        }
                .setColor(Color.parseColor("#FFFFFF"), Color.parseColor("#BEBEBE"))
                .setSize(13, 13));
    }
}
