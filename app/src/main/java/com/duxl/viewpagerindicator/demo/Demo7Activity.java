package com.duxl.viewpagerindicator.demo;

import android.graphics.Color;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.duxl.viewpagerindicator.demo.adapter.CustomPageIndicatorAdapter;
import com.duxl.viewpagerindicator.demo.adapter.CustomPageIndicatorAdapter.IndicatorItem;
import com.duxl.viewpagerindicator.demo.fragments.RecyclerFragment;
import com.duxl.viewpagerindicator.demo.fragments.SimpleFragment;
import com.duxl.viewpagerindicator.demo.utils.DisplayUtil;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 完全自定义效果
 * create by duxl 2020/7/20
 */
public class Demo7Activity extends BaseActivity {

    @BindView(R.id.indicator)
    ScrollIndicatorView mIndicatorView;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private IndicatorViewPager mIndicatorViewPager;
    static List<IndicatorItem> mTabs = new ArrayList();

    static {
        mTabs.add(new IndicatorItem("实时热销", "秒级更新"));
        mTabs.add(new IndicatorItem("服饰箱包", "出行必备"));
        mTabs.add(new IndicatorItem("美妆护肤", "9.9抢购"));
        mTabs.add(new IndicatorItem("生鲜美食", "冷链配送"));
        mTabs.add(new IndicatorItem("家居生活", "日常必备"));
        mTabs.add(new IndicatorItem("品质大牌", "低至五折"));
        mTabs.add(new IndicatorItem("母婴玩具", "爱宠必买"));
        mTabs.add(new IndicatorItem("数码家电", "1元起抢"));
        mTabs.add(new IndicatorItem("智能家居", "全屋定制"));
        mTabs.add(new IndicatorItem("猜你喜欢", "千人千面"));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.indicator_viewpager_layout;
    }

    @Override
    public void initView() {
        mIndicatorView.setBackgroundColor(Color.parseColor("#F4F4F4"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.topMargin = DisplayUtil.dip2px(this, 10);
        layoutParams.bottomMargin = DisplayUtil.dip2px(this, 10);

        mIndicatorView.setLayoutParams(layoutParams);

        initTab();
        showTab();
    }

    private void initTab() {
        mIndicatorViewPager = new IndicatorViewPager(mIndicatorView, mViewPager);
    }

    private void showTab() {
        List<Fragment> fragments = new ArrayList();
        for (int i = 0; i < mTabs.size(); i++) {
            if (i % 2 == 0) {
                fragments.add(SimpleFragment.newInstance(mTabs.get(i).title));
            } else {
                fragments.add(RecyclerFragment.newInstance(mTabs.get(i).title));
            }
        }
        CustomPageIndicatorAdapter pageIndicatorAdapter = new CustomPageIndicatorAdapter(getSupportFragmentManager(), this, mViewPager, mTabs, fragments);
        mIndicatorViewPager.setAdapter(pageIndicatorAdapter);
    }
}
