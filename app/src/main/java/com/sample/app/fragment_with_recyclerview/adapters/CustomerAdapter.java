package com.sample.app.fragment_with_recyclerview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.app.R;
import com.sample.app.entity.Customer;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    private List<Customer> itemList;
    private OnItemClickListener  mOnItemClickListener;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cust_customer_list, parent, false);

        return new ViewHolder(itemView, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Customer item = itemList.get(position);
        holder.setItem(item);
        holder.nameTextView.setText(item.getName());
        holder.cityTextView.setText(item.getCity());
        holder.countryTextView.setText(item.getCountry());
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public void setList(List<Customer> list){
        this.itemList = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(Customer categoriesInfo);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameTextView;
        private TextView cityTextView;
        private TextView countryTextView;
        private CustomerAdapter.OnItemClickListener mOnItemClickListener;
        private Customer item;

        public ViewHolder(View itemView, CustomerAdapter.OnItemClickListener onItemClickListener) {
            super(itemView);
            mOnItemClickListener = onItemClickListener;
            itemView.findViewById(R.id.item).setOnClickListener(ViewHolder.this);
            nameTextView  = (TextView) itemView.findViewById(R.id.nameTextView);
            cityTextView = (TextView) itemView.findViewById(R.id.cityTextView);
            countryTextView = (TextView) itemView.findViewById(R.id.countryTextView);
        }

        public void setItem(Customer item){
            this.item = item;
        }

        @Override
        public void onClick(View v) {
            if(mOnItemClickListener != null)
                mOnItemClickListener.onItemClick(item);
        }
    }
}
