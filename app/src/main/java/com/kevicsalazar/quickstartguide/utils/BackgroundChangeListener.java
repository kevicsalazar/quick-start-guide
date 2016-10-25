package com.kevicsalazar.quickstartguide.utils;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

public class BackgroundChangeListener implements ViewPager.OnPageChangeListener {

    private List<Integer> colors;
    private ViewPager viewPager;
    private OnPageSelected cb;
    private ArgbEvaluator argbEvaluator;

    public BackgroundChangeListener(List<Integer> colors, ViewPager viewPager) {
        this.colors = colors;
        this.viewPager = viewPager;
        this.argbEvaluator = new ArgbEvaluator();
    }

    public BackgroundChangeListener(List<Integer> colors, ViewPager viewPager, OnPageSelected cb) {
        this.colors = colors;
        this.viewPager = viewPager;
        this.argbEvaluator = new ArgbEvaluator();
        this.cb = cb;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position < (colors.size() - 1)) {
            viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors.get(position), colors.get(position + 1)));
        } else {
            viewPager.setBackgroundColor(colors.get(colors.size() - 1));
        }
    }

    @Override
    public void onPageSelected(int position) {
        cb.onPageSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public interface OnPageSelected {

        void onPageSelected(int position);

    }

}
