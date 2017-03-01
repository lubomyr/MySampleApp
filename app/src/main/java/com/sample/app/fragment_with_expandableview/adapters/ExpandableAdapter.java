package com.sample.app.fragment_with_expandableview.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.sample.app.R;
import com.sample.app.entity.Customer;

import java.util.List;

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Customer> itemList;

    public ExpandableAdapter(Context context, List<Customer> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        List<Customer> childList = itemList;
        return childList.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View view, ViewGroup parent) {

        Customer item = (Customer) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.cust_customer_list, null);
        }

        TextView nameView = (TextView) view.findViewById(R.id.nameTextView);
        nameView.setText((item.getName()));
        TextView cityView = (TextView) view.findViewById(R.id.cityTextView);
        cityView.setText((item.getCity()));
        TextView countryView = (TextView) view.findViewById(R.id.countryTextView);
        countryView.setText((item.getCountry()));

        return view;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;

    }

    @Override
    public Object getGroup(int groupPosition) {
        return itemList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return itemList != null ? itemList.size() : 0;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view,
                             ViewGroup parent) {

        Customer item = (Customer) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.expandable_heading, null);
        }

        TextView heading = (TextView) view.findViewById(R.id.heading);
        heading.setText(item.getName());

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void setDataList(List<Customer> itemList){
        this.itemList = itemList;
    }

}
