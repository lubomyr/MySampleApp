package com.sample.app.fragment_with_listview.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sample.app.R;
import com.sample.app.entity.Customer;
import java.util.List;

public class ListAdapter extends ArrayAdapter<Customer> {
    private int resource;

    private static class ViewHolder {
        TextView nameTextView;
        TextView cityTextView;
        TextView countryTextView;
    }

    public ListAdapter(Context context, int resource, List<Customer> list) {
        super(context, resource, list);
        this.resource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Customer item = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ListAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(resource, parent, false);
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
            viewHolder.cityTextView = (TextView) convertView.findViewById(R.id.cityTextView);
            viewHolder.countryTextView = (TextView) convertView.findViewById(R.id.countryTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ListAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.nameTextView.setText(item.getName());
        viewHolder.cityTextView.setText(item.getCity());
        viewHolder.countryTextView.setText(item.getCountry());

        return convertView;
    }
}
