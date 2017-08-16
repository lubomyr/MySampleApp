package com.sample.app.fragment_with_expandableview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView

import com.sample.app.R
import com.sample.app.fragment_with_expandableview.adapters.ExpandableAdapter
import com.sample.app.repository.CustomerRepository

class FragmentWithExpandableView : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_with_expandableview, container, false)
        val customerList = CustomerRepository.all

        val expandableListView = rootView.findViewById(R.id.expandableListView) as ExpandableListView
        val expandableAdapter = ExpandableAdapter(context, customerList)
        expandableListView.setAdapter(expandableAdapter)

        return rootView
    }
}

