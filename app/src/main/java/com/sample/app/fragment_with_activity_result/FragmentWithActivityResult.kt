package com.sample.app.fragment_with_activity_result

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.sample.app.R
import com.sample.app.fragment_with_activity_result.ActivityWithResult.Companion.KEY_RESULT

class FragmentWithActivityResult : Fragment() {
    private var resultView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_with_activity_result, container, false)

        resultView = rootView.findViewById(R.id.result) as TextView
        bindButton(rootView)

        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("activityResult", "activityResult")
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_TEXT -> {
                    val result = data!!.getStringExtra(KEY_RESULT)
                    val resultStr = "result is: " + result
                    resultView!!.text = resultStr
                }
            }
        }
    }

    private fun bindButton(rootView: View) {
        val button = rootView.findViewById(R.id.button) as Button
        button.setOnClickListener { runActivityforResult() }
    }

    private fun runActivityforResult() {
        val intent = Intent(activity, ActivityWithResult::class.java)
        startActivityForResult(intent, REQUEST_TEXT)
    }

    companion object {
        internal val REQUEST_TEXT = 0
    }
}