package com.sample.app.fragment_with_retrofit.runnables;

import android.content.Context;

import com.sample.app.entity.Customer;
import com.sample.app.repository.CustomerRepository;

import java.lang.ref.WeakReference;
import java.util.List;

public class SaveCustomerRunnable implements Runnable {
    private WeakReference<Context> context;
    private List<Customer> customerList;

    public SaveCustomerRunnable(Context context, List<Customer> customerList) {
        this.context = new WeakReference<>(context);
        this.customerList = customerList;
    }

    @Override
    public void run() {
        if(context.get() != null) {
            CustomerRepository.saveAll(customerList);
        }
    }
}
