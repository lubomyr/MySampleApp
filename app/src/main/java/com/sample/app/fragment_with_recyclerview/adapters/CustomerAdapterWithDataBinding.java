package com.sample.app.fragment_with_recyclerview.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.app.R;
import com.sample.app.databinding.ItemCustomerDatabindingBinding;
import com.sample.app.entity.Customer;

import java.util.List;

public class CustomerAdapterWithDataBinding extends RecyclerView.Adapter<CustomerAdapterWithDataBinding.ViewHolder> {
    private List<Customer> itemList;
    private CustomerAdapterWithDataBinding.OnItemClickListener mOnItemClickListener;
    private Context mContext;
    private int mResources;

    public CustomerAdapterWithDataBinding(Context context, int resources) {
        this.mContext = context;
        this.mResources = resources;
    }


    @Override
    public CustomerAdapterWithDataBinding.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCustomerDatabindingBinding binding = DataBindingUtil.inflate(LayoutInflater.from(
                parent.getContext()), mResources, parent, false);

        return new CustomerAdapterWithDataBinding.ViewHolder(binding, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(CustomerAdapterWithDataBinding.ViewHolder holder, int position) {
        Customer item = itemList.get(position);
        holder.setItem(item);
        holder.binding.setItem(item);

        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void setList(List<Customer> list) {
        this.itemList = list;
    }

    public void setOnItemClickListener(CustomerAdapterWithDataBinding.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(Customer categoriesInfo);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemCustomerDatabindingBinding binding;
        private CustomerAdapterWithDataBinding.OnItemClickListener mOnItemClickListener;
        private Customer item;

        public ViewHolder(ItemCustomerDatabindingBinding binding, CustomerAdapterWithDataBinding.OnItemClickListener onItemClickListener) {
            super(binding.getRoot());
            this.binding = binding;
            mOnItemClickListener = onItemClickListener;
            itemView.findViewById(R.id.item).setOnClickListener(CustomerAdapterWithDataBinding.ViewHolder.this);
        }

        public void setItem(Customer item) {
            this.item = item;
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null)
                mOnItemClickListener.onItemClick(item);
        }
    }
}
