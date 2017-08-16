package com.sample.app.fragment_with_activity_result

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.EditText
import com.sample.app.R

class ActivityWithResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_result)

        bindView()

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
                actionBar.title = "Activity with result"
                val res = resources
                val upArrow = res.getDrawable(R.mipmap.ic_arrow)
                if (upArrow != null) {
                    upArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
                    actionBar.setHomeAsUpIndicator(upArrow)
                }
            }
        }
    }

    private fun bindView() {
        val editView = findViewById(R.id.edit) as EditText
        val button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            val result = editView.text.toString()
            finishWithResult(result)
        }
    }

    private fun finishWithResult(result: String) {
        val conData = Bundle()
        conData.putString(KEY_RESULT, result)
        val intent = Intent()
        intent.putExtras(conData)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    companion object {
        internal val KEY_RESULT = "result"
    }
}
