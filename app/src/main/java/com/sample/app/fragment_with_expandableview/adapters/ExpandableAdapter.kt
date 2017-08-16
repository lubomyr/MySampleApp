package com.sample.app.fragment_with_expandableview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

import com.sample.app.R
import com.sample.app.entity.Customer

class ExpandableAdapter(private val context: Context, private var itemList: List<Customer>?) : BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        val childList = itemList
        return childList!![groupPosition]
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean,
                              view: View?, parent: ViewGroup): View {
        var view = view

        val item = getChild(groupPosition, childPosition) as Customer
        if (view == null) {
            val infalInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = infalInflater.inflate(R.layout.item_customer, null)
        }

        val nameView = view!!.findViewById(R.id.nameTextView) as TextView
        nameView.text = item.name
        val cityView = view.findViewById(R.id.cityTextView) as TextView
        cityView.text = item.city
        val countryView = view.findViewById(R.id.countryTextView) as TextView
        countryView.text = item.country

        return view
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1

    }

    override fun getGroup(groupPosition: Int): Any {
        return itemList!![groupPosition]
    }

    override fun getGroupCount(): Int {
        return if (itemList != null) itemList!!.size else 0
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isLastChild: Boolean, view: View?,
                              parent: ViewGroup): View {
        var view = view

        val item = getGroup(groupPosition) as Customer
        if (view == null) {
            val inf = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inf.inflate(R.layout.expandable_heading, null)
        }

        val heading = view!!.findViewById(R.id.heading) as TextView
        heading.text = item.name

        return view
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    fun setDataList(itemList: List<Customer>) {
        this.itemList = itemList
    }

}
