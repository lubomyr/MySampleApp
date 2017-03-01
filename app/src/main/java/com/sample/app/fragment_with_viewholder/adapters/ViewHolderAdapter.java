package com.sample.app.fragment_with_viewholder.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sample.app.R;
import com.sample.app.entity.Customer;

import java.util.List;

public class ViewHolderAdapter extends RecyclerView.Adapter<ViewHolderAdapter.ViewHolder> {
    private int resources;
    private List<Customer> items;

    public ViewHolderAdapter(int resources, List<Customer> items) {
        this.items = items;
        this.resources = resources;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(resources, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Customer item = items.get(position);
        holder.nameTextView.setText(item.getName());
        holder.cityTextView.setText(item.getCity());
        holder.countryTextView.setText(item.getCountry());
        holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView cityTextView;
        TextView countryTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView  = (TextView) itemView.findViewById(R.id.nameTextView);
            cityTextView = (TextView) itemView.findViewById(R.id.cityTextView);
            countryTextView = (TextView) itemView.findViewById(R.id.countryTextView);
        }
    }
}
