package com.sample.app.fragment_with_listview.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.sample.app.databinding.ItemCustomerDatabindingBinding
import com.sample.app.entity.Customer

class ListAdapterWithDataBinding(context: Context, private val mResources: Int, list: List<Customer>) : ArrayAdapter<Customer>(context, mResources, list) {
    private val mContext: Context? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val binding: ItemCustomerDatabindingBinding
        if (convertView == null) {
            binding = DataBindingUtil.inflate<ItemCustomerDatabindingBinding>(
                    LayoutInflater.from(context),
                    mResources, parent, false)
            convertView = binding.root
        } else {
            binding = convertView.tag as ItemCustomerDatabindingBinding
        }

        val item = this.getItem(position)
        binding.setItem(item)
        convertView!!.tag = binding
        binding.executePendingBindings()
        return convertView
    }
}
