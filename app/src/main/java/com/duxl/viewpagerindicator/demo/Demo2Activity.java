package com.duxl.viewpagerindicator.demo;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.duxl.viewpagerindicator.demo.adapter.PageIndicatorAdapter;
import com.duxl.viewpagerindicator.demo.fragments.RecyclerFragment;
import com.duxl.viewpagerindicator.demo.fragments.SimpleFragment;
import com.duxl.viewpagerindicator.demo.utils.DataUtil;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 和ViewPager配合使用
 * create by duxl 2020/7/20
 */
public class Demo2Activity extends BaseActivity {

    @BindView(R.id.indicator)
    ScrollIndicatorView mIndicatorView;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    protected IndicatorViewPager mIndicatorViewPager;

    protected List<String> mItems = DataUtil.getItemsA();

    @Override
    public int getLayoutResId() {
        return R.layout.indicator_viewpager_layout;
    }

    @Override
    public void initView() {
        initIndicatorViewPager();
        initTab();
        showTab();
    }

    protected void initIndicatorViewPager() {
        mIndicatorViewPager = new IndicatorViewPager(mIndicatorView, mViewPager);
    }

    protected void initTab() {
        mIndicatorView.setBackgroundColor(Color.parseColor("#234577"));
        mIndicatorViewPager = new IndicatorViewPager(mIndicatorView, mViewPager);
        mIndicatorView.setOnTransitionListener(new OnTransitionTextListener() {
            @Override
            public TextView getTextView(View tabItemView, int position) {
                TextView textView = super.getTextView(tabItemView, position);
                textView.setSingleLine();
                textView.getPaint().setFakeBoldText(true);
                textView.requestLayout();
                return textView;
            }
        }
                .setColor(ContextCompat.getColor(this, R.color.text_selectColor),
                        ContextCompat.getColor(this, R.color.text_unSelectColor))
                .setSize(18, 15));
    }

    protected void showTab() {
        String[] tabs = new String[mItems.size()];
        List<Fragment> fragments = new ArrayList();
        for (int i = 0; i < mItems.size(); i++) {
            tabs[i] = mItems.get(i);
            if (i == 3) {
                fragments.add(SimpleFragment.newInstance(mItems.get(i)));
            } else {
                fragments.add(RecyclerFragment.newInstance(mItems.get(i)));
            }
        }

        PageIndicatorAdapter pageIndicatorAdapter = new PageIndicatorAdapter(getSupportFragmentManager(), this, fragments, tabs);
        mIndicatorViewPager.setAdapter(pageIndicatorAdapter);
    }
}
