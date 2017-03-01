package com.sample.app.fragment_with_expandableview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.sample.app.R;
import com.sample.app.db.repository.CustomerRepository;
import com.sample.app.entity.Customer;
import com.sample.app.fragment_with_expandableview.adapters.ExpandableAdapter;

import java.util.List;

public class FragmentWithExpandableView  extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView      = inflater.inflate(R.layout.fragment_with_expandableview, container, false);
        List<Customer> customerList = CustomerRepository.getAll(getContext());

        ExpandableListView expandableListView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);
        ExpandableAdapter expandableAdapter = new ExpandableAdapter(getContext(), customerList);
        expandableListView.setAdapter(expandableAdapter);

        return rootView;
    }
}

