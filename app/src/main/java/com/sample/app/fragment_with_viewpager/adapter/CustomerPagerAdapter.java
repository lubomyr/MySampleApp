package com.sample.app.fragment_with_viewpager.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sample.app.R;
import com.sample.app.entity.Customer;

import java.util.List;

public class CustomerPagerAdapter extends PagerAdapter {
    private Context context;
    private List<Customer> CustomerList;

    public CustomerPagerAdapter(Context context, List<Customer> CustomerList) {
        this.context = context;
        this.CustomerList = CustomerList;
    }

    @Override
    public int getCount() {
        return CustomerList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView nameTextView;
        TextView cityTextView;
        TextView countryTextView;

        Customer item = CustomerList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cust_customer_list, container, false);
        container.addView(view);

        nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        cityTextView = (TextView) view.findViewById(R.id.cityTextView);
        countryTextView = (TextView) view.findViewById(R.id.countryTextView);

        nameTextView.setText(item.getName());
        cityTextView.setText(item.getCity());
        countryTextView.setText(item.getCountry());

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        (container).removeView((LinearLayout) object);
    }
} 
