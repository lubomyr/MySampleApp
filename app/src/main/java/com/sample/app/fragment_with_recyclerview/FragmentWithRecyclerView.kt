package com.sample.app.fragment_with_recyclerview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sample.app.R
import com.sample.app.fragment_with_recyclerview.adapters.CustomerAdapter
import com.sample.app.repository.CustomerRepository

class FragmentWithRecyclerView : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_with_recyclerview, container, false)
        val customerList = CustomerRepository.all

        val recyclerView = rootView.findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
        val viewHolderAdapter = CustomerAdapter(context, R.layout.item_customer)
        viewHolderAdapter.setList(customerList)
        recyclerView.adapter = viewHolderAdapter

        return rootView
    }
}

