package com.duxl.viewpagerindicator.demo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duxl.viewpagerindicator.demo.utils.DataUtil;
import com.duxl.viewpagerindicator.demo.utils.DisplayUtil;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.util.List;

import butterknife.BindView;

/**
 * 单独使用Indicator
 * create by duxl 2020/7/20
 */
public class Demo1Activity extends BaseActivity {

    private int text_selectColor = Color.parseColor("#64A2FF");
    private int text_unSelectColor = Color.parseColor("#BEBEBE");
    private int indicator_color = text_selectColor;

    private List<String> mItems = DataUtil.getItemsB();


    @BindView(R.id.indicator)
    ScrollIndicatorView mIndicatorView;

    @Override
    public int getLayoutResId() {
        return R.layout.indicator_layout;
    }

    @Override
    public void initView() {
        ColorBar colorBar = new ColorBar(this, indicator_color, DisplayUtil.dip2px(this, 3));
        colorBar.setWidth(DisplayUtil.dip2px(this, 26));
        mIndicatorView.setScrollBar(colorBar);
        mIndicatorView.setSplitAuto(true);
        mIndicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(text_selectColor, text_unSelectColor).setSize(14, 14));
        mIndicatorView.setAdapter(new InnerIndicatorAdapter(this));
        mIndicatorView.setItemClickable(true);
        mIndicatorView.setOnItemSelectListener(new Indicator.OnItemSelectedListener() {
            @Override
            public void onItemSelected(View selectItemView, int position, int prePosition) {
                showToast(mItems.get(position));
            }
        });
    }

    private class InnerIndicatorAdapter extends Indicator.IndicatorAdapter {

        private Context mContext;

        public InnerIndicatorAdapter(Context context) {
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_tab, parent, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(mItems.get(position));
            return textView;
        }
    }
}
