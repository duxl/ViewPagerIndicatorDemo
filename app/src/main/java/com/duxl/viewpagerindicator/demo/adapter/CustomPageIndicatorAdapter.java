package com.duxl.viewpagerindicator.demo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.duxl.viewpagerindicator.demo.R;
import com.flyco.roundview.RoundTextView;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.List;

public class CustomPageIndicatorAdapter<T extends Fragment> extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

    private Context mContext;
    private ViewPager mViewPager;
    private List<IndicatorItem> mTabs;
    private List<T> mFragents;

    public CustomPageIndicatorAdapter(FragmentManager fragmentManager, Context context, ViewPager viewPager, List<IndicatorItem> tabs, List<T> fragments) {
        super(fragmentManager);
        mContext = context;
        mViewPager = viewPager;
        mTabs = tabs;
        mFragents = fragments;
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getIndicatorAdapter().notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getCount() {
        return mTabs.size();
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_custom_tab, null, false);
        }

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        RoundTextView tvDesc = convertView.findViewById(R.id.tvDesc);
        View vLine = convertView.findViewById(R.id.v_line);

        tvTitle.setText(mTabs.get(position).title);
        tvDesc.setText(mTabs.get(position).desc);

        tvTitle.setTextColor(Color.parseColor(mViewPager.getCurrentItem() == position ? "#FD3F46" : "#333333"));
        tvDesc.getDelegate().setBackgroundColor(Color.parseColor(mViewPager.getCurrentItem() == position ? "#FD3F46" : "#00000000"));
        tvDesc.setTextColor(Color.parseColor(mViewPager.getCurrentItem() == position ? "#FFFFFF" :"#AAAAAA"));
        vLine.setVisibility(position == getCount() - 1 ? View.GONE : View.VISIBLE);

        return convertView;
    }

    @Override
    public T getFragmentForPage(int position) {
        return mFragents.get(position);
    }


    @Override
    public int getItemPosition(Object object) {
        //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
        // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage
        return PagerAdapter.POSITION_NONE;
    }

    public static class IndicatorItem {
        public String title;
        public String desc;

        public IndicatorItem(String title, String desc) {
            this.title = title;
            this.desc = desc;
        }
    }
}
