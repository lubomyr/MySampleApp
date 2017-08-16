package com.sample.app.simple_activity

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.sample.app.R

class SimpleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

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
                actionBar.title = getString(R.string.simple_activity)
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
