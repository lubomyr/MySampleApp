package com.sample.app.activity_with_fragments

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.sample.app.R

class ActivityWithFragments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_fragments)

        initToolbar()
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
                actionBar.title = getString(R.string.activity_with_fragments)
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
