package com.vivo.wenruan.viewpagerdemo;

import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

public class CycleScrollOnPageChangeListener implements ViewPager.OnPageChangeListener {
    private List<View> viewList;
    private ViewPager viewPager;

    public CycleScrollOnPageChangeListener() {

    }

    public CycleScrollOnPageChangeListener(List<View> viewList, ViewPager viewPager) {
        this.viewList = viewList;
        this.viewPager = viewPager;
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        if (v == 0) {
            if (i == 0) {
                viewPager.setCurrentItem(viewList.size() - 2, false);
            } else if(i == (viewList.size() - 1)) {
                viewPager.setCurrentItem(1,false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
