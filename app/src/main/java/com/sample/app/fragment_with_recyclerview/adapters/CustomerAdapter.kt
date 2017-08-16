package com.sample.app.fragment_with_recyclerview.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.sample.app.R
import com.sample.app.entity.Customer

internal class CustomerAdapter(private val mContext: Context, private val mResources: Int) : RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {
    private var itemList: List<Customer>? = null
    private var mOnItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(mResources, parent, false)

        return ViewHolder(itemView, mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList!![position]
        holder.setItem(item)
        holder.nameTextView.text = item.name
        holder.cityTextView.text = item.city
        holder.countryTextView.text = item.country
    }

    override fun getItemCount(): Int {
        return if (itemList != null) itemList!!.size else 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setList(list: List<Customer>) {
        this.itemList = list
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(categoriesInfo: Customer)
    }

    internal inner class ViewHolder(itemView: View, private val mOnItemClickListener: CustomerAdapter.OnItemClickListener?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        internal val nameTextView: TextView
        internal val cityTextView: TextView
        internal val countryTextView: TextView
        private var item: Customer? = null

        init {
            itemView.findViewById(R.id.item).setOnClickListener(this@ViewHolder)
            nameTextView = itemView.findViewById(R.id.nameTextView) as TextView
            cityTextView = itemView.findViewById(R.id.cityTextView) as TextView
            countryTextView = itemView.findViewById(R.id.countryTextView) as TextView
        }

        fun setItem(item: Customer) {
            this.item = item
        }

        override fun onClick(v: View) {
            mOnItemClickListener?.onItemClick(item!!)
        }
    }
}
