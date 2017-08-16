package com.sample.app

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.sample.app.activity_tab_pager.ActivityWithTabPager
import com.sample.app.activity_with_fragments.ActivityWithFragments
import com.sample.app.activity_with_search.ActivityWithSearch
import com.sample.app.callback.OnAddFragmentListener
import com.sample.app.fragment_with_activity_result.FragmentWithActivityResult
import com.sample.app.fragment_with_bottom_sheets.FragmentWithBottomSheets
import com.sample.app.fragment_with_capturing_photo.FragmentWithCapturingPhoto
import com.sample.app.fragment_with_dialog.FragmentWithDialog
import com.sample.app.fragment_with_expandableview.FragmentWithExpandableView
import com.sample.app.fragment_with_listview.FragmentWithListView
import com.sample.app.fragment_with_recyclerview.FragmentWithRecyclerView
import com.sample.app.fragment_with_retrofit.FragmentWithRetrofit
import com.sample.app.fragment_with_viewpager.FragmentWithViewPager
import com.sample.app.simple_activity.SimpleActivity
import com.sample.app.simple_fragment.SimpleFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnAddFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        addFragment(FragmentWithRetrofit(), false)
    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId
        when (id) {
            R.id.simple_activity -> {
                val intent1 = Intent(this, SimpleActivity::class.java)
                startActivity(intent1)
            }
            R.id.simple_fragment -> addFragment(SimpleFragment(), true)
            R.id.activity_with_search -> {
                val intent2 = Intent(this, ActivityWithSearch::class.java)
                startActivity(intent2)
            }
            R.id.activity_tab_pager -> {
                val intent3 = Intent(this, ActivityWithTabPager::class.java)
                startActivity(intent3)
            }
            R.id.activity_with_fragments -> {
                val intent4 = Intent(this, ActivityWithFragments::class.java)
                startActivity(intent4)
            }
            R.id.fragment_with_bottom_sheets -> addFragment(FragmentWithBottomSheets(), true)
            R.id.fragment_with_dialog -> addFragment(FragmentWithDialog(), true)
            R.id.fragment_with_retrofit -> addFragment(FragmentWithRetrofit(), true)
            R.id.fragment_with_listview -> addFragment(FragmentWithListView(), true)
            R.id.fragment_with_recyclerview -> addFragment(FragmentWithRecyclerView(), true)
            R.id.fragment_with_expandableview -> addFragment(FragmentWithExpandableView(), true)
            R.id.fragment_with_viewpager -> addFragment(FragmentWithViewPager(), true)
            R.id.fragment_with_activityresult -> addFragment(FragmentWithActivityResult(), true)
            R.id.fragment_with_capturing_photo -> addFragment(FragmentWithCapturingPhoto(), true)
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onAddFragment(fragment: Fragment, isAddToBackStack: Boolean) {
        addFragment(fragment, isAddToBackStack)
    }

    private fun addFragment(fragment: Fragment, isAddToBackStack: Boolean) {

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.flContent, fragment, fragment.javaClass.getName())

        if (isAddToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commitAllowingStateLoss()
    }
}

