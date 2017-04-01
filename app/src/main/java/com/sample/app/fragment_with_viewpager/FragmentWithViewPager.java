package com.sample.app.fragment_with_viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.app.R;
import com.sample.app.entity.Customer;
import com.sample.app.fragment_with_viewpager.adapter.CustomerPagerAdapter;
import com.sample.app.repository.CustomerRepository;

import java.util.List;

public class FragmentWithViewPager extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_with_viewpager, container, false);
        List<Customer> customerList = CustomerRepository.getAll();

        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.pager);
        CustomerPagerAdapter adapter = new CustomerPagerAdapter(getContext(), customerList);
        viewPager.setAdapter(adapter);

        return rootView;
    }
}

