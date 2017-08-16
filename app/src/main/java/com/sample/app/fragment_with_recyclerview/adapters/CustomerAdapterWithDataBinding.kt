package com.sample.app.fragment_with_recyclerview.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sample.app.R
import com.sample.app.databinding.ItemCustomerDatabindingBinding
import com.sample.app.entity.Customer
import com.sample.app.fragment_with_recyclerview.adapters.CustomerAdapterWithDataBinding.ViewHolder

class CustomerAdapterWithDataBinding(private val mContext: Context, private val mResources: Int) : RecyclerView.Adapter<ViewHolder>() {
    private var itemList: List<Customer>? = null
    private var mOnItemClickListener: CustomerAdapterWithDataBinding.OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemCustomerDatabindingBinding>(LayoutInflater.from(
                parent.context), mResources, parent, false)

        return ViewHolder(binding, mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList!![position]
        holder.setItem(item)
        holder.binding.setItem(item)

        holder.binding.executePendingBindings()

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

    fun setOnItemClickListener(onItemClickListener: CustomerAdapterWithDataBinding.OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(categoriesInfo: Customer)
    }

    inner class ViewHolder(val binding: ItemCustomerDatabindingBinding, private val mOnItemClickListener: CustomerAdapterWithDataBinding.OnItemClickListener?) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private var item: Customer? = null

        init {
            itemView.findViewById(R.id.item).setOnClickListener(this@ViewHolder)
        }

        fun setItem(item: Customer) {
            this.item = item
        }

        override fun onClick(v: View) {
            mOnItemClickListener?.onItemClick(item!!)
        }
    }
}
