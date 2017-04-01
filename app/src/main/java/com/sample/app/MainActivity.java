package com.sample.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sample.app.activity_tab_pager.ActivityWithTabPager;
import com.sample.app.activity_with_search.ActivityWithSearch;
import com.sample.app.callback.OnAddFragmentListener;
import com.sample.app.fragment_with_activity_result.FragmentWithActivityResult;
import com.sample.app.fragment_with_bottom_sheets.FragmentWithBottomSheets;
import com.sample.app.fragment_with_capturing_photo.FragmentWithCapturingPhoto;
import com.sample.app.fragment_with_dialog.FragmentWithDialog;
import com.sample.app.fragment_with_expandableview.FragmentWithExpandableView;
import com.sample.app.fragment_with_listview.FragmentWithListView;
import com.sample.app.fragment_with_retrofit.FragmentWithRetrofit;
import com.sample.app.fragment_with_viewholder.FragmentWithViewHolder;
import com.sample.app.fragment_with_viewpager.FragmentWithViewPager;
import com.sample.app.simple_activity.SimpleActivity;
import com.sample.app.simple_fragment.SimpleFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnAddFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addFragment(new FragmentWithRetrofit(), false);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id) {
            case R.id.simple_activity:
                Intent intent1 = new Intent(this, SimpleActivity.class);
                startActivity(intent1);
                break;
            case R.id.simple_fragment:
                addFragment(new SimpleFragment(), true);
                break;
            case R.id.activity_with_search:
                Intent intent2 = new Intent(this, ActivityWithSearch.class);
                startActivity(intent2);
                break;
            case R.id.activity_tab_pager:
                Intent intent3 = new Intent(this, ActivityWithTabPager.class);
                startActivity(intent3);
                break;
            case R.id.fragment_with_bottom_sheets:
                addFragment(new FragmentWithBottomSheets(), true);
                break;
            case R.id.fragment_with_dialog:
                addFragment(new FragmentWithDialog(), true);
                break;
            case R.id.fragment_with_retrofit:
                addFragment(new FragmentWithRetrofit(), true);
                break;
            case R.id.fragment_with_listview:
                addFragment(new FragmentWithListView(), true);
                break;
            case R.id.fragment_with_recyclerview:
                addFragment(new FragmentWithViewHolder(), true);
                break;
            case R.id.fragment_with_expandableview:
                addFragment(new FragmentWithExpandableView(), true);
                break;
            case R.id.fragment_with_viewpager:
                addFragment(new FragmentWithViewPager(), true);
                break;
            case R.id.fragment_with_activityresult:
                addFragment(new FragmentWithActivityResult(), true);
                break;
            case R.id.fragment_with_capturing_photo:
                addFragment(new FragmentWithCapturingPhoto(), true);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onAddFragment(Fragment fragment, boolean isAddToBackStack) {
        addFragment(fragment, isAddToBackStack);
    }

    private void addFragment(Fragment fragment, boolean isAddToBackStack) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.flContent, fragment, fragment.getClass().getName());

        if (isAddToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commitAllowingStateLoss();
    }
}

