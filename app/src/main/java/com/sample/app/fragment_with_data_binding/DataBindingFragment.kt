package com.sample.app.fragment_with_data_binding


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sample.app.databinding.FragmentDataBindingBinding

class DataBindingFragment : Fragment() {
    private var binding: FragmentDataBindingBinding? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentDataBindingBinding.inflate(inflater, container, false)

        return binding!!.root
    }

}
