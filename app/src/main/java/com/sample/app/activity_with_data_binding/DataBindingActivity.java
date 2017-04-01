package com.sample.app.activity_with_data_binding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sample.app.R;
import com.sample.app.databinding.ActivityWithDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {
    ActivityWithDataBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_with_data_binding);

        binding.myTextView.setText(R.string.activity_with_data_binding);
    }
}
