package com.duxl.viewpagerindicator.demo.adapter;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

import com.duxl.viewpagerindicator.demo.R;
import com.duxl.viewpagerindicator.demo.utils.DisplayUtil;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.List;

public class PageIndicatorAdapter<T extends Fragment> extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

    private Activity activity;

    private List<T> fragments;
    private String[] versions;
    private int textPadding = 10;

    public PageIndicatorAdapter(FragmentManager fragmentManager, Activity activity, List<T> fragments, String[] versions) {
        super(fragmentManager);
        this.activity = activity;
        this.fragments = fragments;
        this.versions = versions;
    }

    public PageIndicatorAdapter(FragmentManager fragmentManager, Activity activity, List<T> fragments, String[] versions, int textPadding) {
        super(fragmentManager);
        this.activity = activity;
        this.fragments = fragments;
        this.versions = versions;
        this.textPadding = textPadding;
    }


    @Override
    public int getCount() {
        return versions.length;
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(R.layout.layout_tab, container, false);
        }
        TextView textView = (TextView) convertView;
        textView.setText(versions[position]);

        int width = getTextWidth(textView);
        int padding = DisplayUtil.dip2px(activity.getApplicationContext(), textPadding);
        //因为wrap的布局 字体大小变化会导致textView大小变化产生抖动，这里通过设置textView宽度就避免抖动现象
        textView.setWidth(width + padding * 2);
        return convertView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {

        return fragments.get(position);
    }


    @Override
    public int getItemPosition(Object object) {
        //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
        // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage
        return PagerAdapter.POSITION_NONE;
    }

    private int getTextWidth(TextView textView) {
        if (textView == null) {
            return 0;
        }
        Rect bounds = new Rect();
        String text = textView.getText().toString();
        Paint paint = textView.getPaint();
        paint.getTextBounds(text, 0, text.length(), bounds);
        int width = bounds.left + bounds.width();
        return width;
    }
}
