package com.sample.app.fragment_with_viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.app.R
import com.sample.app.fragment_with_viewpager.adapter.CustomerPagerAdapter
import com.sample.app.repository.CustomerRepository

class FragmentWithViewPager : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_with_viewpager, container, false)
        val customerList = CustomerRepository.all

        val viewPager = rootView.findViewById(R.id.pager) as ViewPager
        val adapter = CustomerPagerAdapter(context, customerList)
        viewPager.adapter = adapter

        return rootView
    }
}

