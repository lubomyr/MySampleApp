package com.sample.app.fragment_with_listview.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.sample.app.databinding.ItemCustomerDatabindingBinding;
import com.sample.app.entity.Customer;

import java.util.List;

public class ListAdapterWithDataBinding extends ArrayAdapter<Customer> {
    private Context mContext;
    private int mResources;


    public ListAdapterWithDataBinding(Context context, int resources, List<Customer> list) {
        super(context, resources, list);
        this.mResources = resources;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ItemCustomerDatabindingBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(
                    LayoutInflater.from(getContext()),
                    mResources, parent, false);
            convertView = binding.getRoot();
        } else {
            binding = (ItemCustomerDatabindingBinding) convertView.getTag();
        }

        Customer item = this.getItem(position);
        binding.setItem(item);
        convertView.setTag(binding);
        binding.executePendingBindings();
        return convertView;
    }
}
