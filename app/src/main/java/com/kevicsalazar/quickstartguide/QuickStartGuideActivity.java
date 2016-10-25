package com.kevicsalazar.quickstartguide;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevicsalazar.quickstartguide.utils.BackgroundChangeListener;
import com.kevicsalazar.quickstartguide.utils.PageIndicator;
import com.kevicsalazar.quickstartguide.utils.ParallaxPageTransformer;
import com.kevicsalazar.quickstartguide.utils.SimplePagerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

public class QuickStartGuideActivity extends AppCompatActivity {

    ViewPager mViewPager;
    PageIndicator indicator;
    TextView tvSkip;
    TextView tvDone;
    ImageView btnNext;

    private static List<Integer> colorList = Arrays.asList(
            Color.parseColor("#F44336"),
            Color.parseColor("#9C27B0"),
            Color.parseColor("#673AB7"),
            Color.parseColor("#2196F3"),
            Color.parseColor("#2196F3")
    );

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quickstartguide);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        indicator = (PageIndicator) findViewById(R.id.indicator);
        tvSkip = (TextView) findViewById(R.id.tvSkip);
        tvDone = (TextView) findViewById(R.id.tvDone);
        btnNext = (ImageView) findViewById(R.id.btnNext);

        SimplePagerAdapter pagerAdapter = new SimplePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(QuickStartPageFragment.newInstance());
        pagerAdapter.addFragment(QuickStartPageFragment.newInstance());
        pagerAdapter.addFragment(QuickStartPageFragment.newInstance());
        pagerAdapter.addFragment(QuickStartPageFragment.newInstance());
        pagerAdapter.addFragment(QuickStartPageFragment.newInstance());
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.addOnPageChangeListener(new BackgroundChangeListener(colorList, mViewPager, new BackgroundChangeListener.OnPageSelected() {
            @Override
            public void onPageSelected(int position) {
                if (position < 4) {
                    tvSkip.setVisibility(View.VISIBLE);
                    tvDone.setVisibility(View.GONE);
                    btnNext.setVisibility(View.VISIBLE);
                } else {
                    tvSkip.setVisibility(View.GONE);
                    tvDone.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.GONE);
                }
            }
        }));

        ParallaxPageTransformer pageTransformer = new ParallaxPageTransformer().addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.ivImage, -0.5f, -5f));
        mViewPager.setPageTransformer(true, pageTransformer);

        indicator.setIndicatorType(PageIndicator.IndicatorType.CIRCLE);
        indicator.setViewPager(mViewPager);

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tvDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }
        });

    }

}
