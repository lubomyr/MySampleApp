package com.sample.app.activity_tab_pager

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.sample.app.R
import com.sample.app.activity_tab_pager.adapter.TabPagerAdapter
import com.sample.app.activity_tab_pager.fragments.Tab1Fragment
import com.sample.app.activity_tab_pager.fragments.Tab2Fragment
import com.sample.app.activity_tab_pager.fragments.Tab3Fragment

class ActivityWithTabPager : AppCompatActivity() {
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_tabpager)

        initToolbar()
        mViewPager = findViewById(R.id.viewpager) as ViewPager

        val tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)

        setupViewPager(mViewPager!!)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        if (toolbar != null) {
            toolbar.setTitleTextColor(Color.WHITE)
            //setSupportActionBar(toolbar);
            val actionBar = supportActionBar
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true)
                actionBar.setHomeButtonEnabled(true)
                actionBar.title = getString(R.string.activity_tab_pager)
                val res = resources
                val upArrow = res.getDrawable(R.mipmap.ic_arrow)
                if (upArrow != null) {
                    upArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
                    actionBar.setHomeAsUpIndicator(upArrow)
                }
            }
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = TabPagerAdapter(supportFragmentManager)

        val tab1Fragment = Tab1Fragment()
        adapter.addFragment(tab1Fragment, "Tab1")
        val tab2Fragment = Tab2Fragment()
        adapter.addFragment(tab2Fragment, "Tab2")
        val tab3Fragment = Tab3Fragment()
        adapter.addFragment(tab3Fragment, "Tab3")

        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 4
    }
}
