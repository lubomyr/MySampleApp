package com.sample.app.fragment_with_listview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.sample.app.R
import com.sample.app.entity.Customer

class ListAdapter(context: Context, private val resource: Int, list: List<Customer>) : ArrayAdapter<Customer>(context, resource, list) {

    private class ViewHolder {
        internal var nameTextView: TextView? = null
        internal var cityTextView: TextView? = null
        internal var countryTextView: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val item = getItem(position)
        val viewHolder: ViewHolder

        if (convertView == null) {
            viewHolder = ListAdapter.ViewHolder()
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(resource, parent, false)
            viewHolder.nameTextView = convertView!!.findViewById(R.id.nameTextView) as TextView
            viewHolder.cityTextView = convertView.findViewById(R.id.cityTextView) as TextView
            viewHolder.countryTextView = convertView.findViewById(R.id.countryTextView) as TextView
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ListAdapter.ViewHolder
        }
        viewHolder.nameTextView!!.text = item!!.name
        viewHolder.cityTextView!!.text = item.city
        viewHolder.countryTextView!!.text = item.country

        return convertView
    }
}
