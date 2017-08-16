package com.sample.app.fragment_with_viewpager.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.sample.app.R
import com.sample.app.entity.Customer

class CustomerPagerAdapter(private val context: Context, private val CustomerList: List<Customer>) : PagerAdapter() {

    override fun getCount(): Int {
        return CustomerList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val nameTextView: TextView
        val cityTextView: TextView
        val countryTextView: TextView

        val item = CustomerList[position]

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_customer, container, false)
        container.addView(view)

        nameTextView = view.findViewById(R.id.nameTextView) as TextView
        cityTextView = view.findViewById(R.id.cityTextView) as TextView
        countryTextView = view.findViewById(R.id.countryTextView) as TextView

        nameTextView.text = item.name
        cityTextView.text = item.city
        countryTextView.text = item.country

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
} 
