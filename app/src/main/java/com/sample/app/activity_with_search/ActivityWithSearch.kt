package com.sample.app.activity_with_search

import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.view.Menu
import com.sample.app.R

class ActivityWithSearch : AppCompatActivity(), SearchView.OnQueryTextListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_search)

        initToolbar()
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.search_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        val searchManager = this.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setOnQueryTextListener(this)
        searchView.setOnCloseListener {
            // on close search do nothing
            false
        }
        searchView.setSearchableInfo(searchManager.getSearchableInfo(this.componentName))
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        if (TextUtils.isEmpty(newText)) {
            return false
        }
        if (newText.length > 2) {
            val s = newText.trim { it <= ' ' }.toUpperCase()
            // s - is entered search string
            return true
        }
        return false
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
                actionBar.title = getString(R.string.activity_with_search)
                val res = resources
                val upArrow = res.getDrawable(R.mipmap.ic_arrow)
                if (upArrow != null) {
                    upArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
                    actionBar.setHomeAsUpIndicator(upArrow)
                }
            }
        }
    }
}

