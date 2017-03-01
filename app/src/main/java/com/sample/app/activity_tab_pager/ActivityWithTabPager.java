package com.sample.app.activity_tab_pager;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.sample.app.R;
import com.sample.app.activity_tab_pager.fragments.Tab1Fragment;
import com.sample.app.activity_tab_pager.fragments.Tab2Fragment;
import com.sample.app.activity_tab_pager.fragments.Tab3Fragment;
import com.sample.app.adapters.ViewPagerAdapter;

public class ActivityWithTabPager extends AppCompatActivity {
    private ViewPager        mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_tabpager);

        initToolbar();
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        setupViewPager(mViewPager);
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("deprecation")
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitleTextColor(Color.WHITE);
            //setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);
                actionBar.setTitle(getString(R.string.activity_tab_pager));
                Resources res = getResources();
                final Drawable upArrow = res.getDrawable(R.mipmap.ic_arrow);
                if (upArrow != null) {
                    upArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                    actionBar.setHomeAsUpIndicator(upArrow);
                }
            }
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Tab1Fragment tab1Fragment =  new Tab1Fragment();
        adapter.addFragment(tab1Fragment, "Tab1");
        Tab2Fragment tab2Fragment =  new Tab2Fragment();
        adapter.addFragment(tab2Fragment, "Tab2");
        Tab3Fragment tab3Fragment =  new Tab3Fragment();
        adapter.addFragment(tab3Fragment, "Tab3");

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
    }
}
