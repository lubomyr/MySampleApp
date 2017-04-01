package com.sample.app.fragment_with_viewholder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.app.R;
import com.sample.app.entity.Customer;
import com.sample.app.fragment_with_viewholder.adapters.ViewHolderClickAdapter;
import com.sample.app.repository.CustomerRepository;

import java.util.List;

public class FragmentWithViewHolder extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView      = inflater.inflate(R.layout.fragment_with_viewholder, container, false);
        List<Customer> customerList = CustomerRepository.getAll();

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        //ViewHolderAdapter viewHolderAdapter = new ViewHolderAdapter(R.layout.cust_customer_list, customerList);
        ViewHolderClickAdapter viewHolderAdapter = new ViewHolderClickAdapter();
        viewHolderAdapter.setList(customerList);
        recyclerView.setAdapter(viewHolderAdapter);

        return rootView;
    }
}

