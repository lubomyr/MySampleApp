package com.sample.app.fragment_with_data_binding;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.app.databinding.FragmentDataBindingBinding;

public class DataBindingFragment extends Fragment {
    private FragmentDataBindingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDataBindingBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

}
