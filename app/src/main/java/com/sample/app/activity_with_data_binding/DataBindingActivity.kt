package com.sample.app.activity_with_data_binding

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.sample.app.R
import com.sample.app.databinding.ActivityWithDataBindingBinding

class DataBindingActivity : AppCompatActivity() {
    lateinit var binding: ActivityWithDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityWithDataBindingBinding>(this, R.layout.activity_with_data_binding)

        binding.myTextView.setText(R.string.activity_with_data_binding)
    }
}
