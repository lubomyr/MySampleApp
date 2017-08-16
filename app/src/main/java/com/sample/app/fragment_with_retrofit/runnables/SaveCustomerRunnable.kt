package com.sample.app.fragment_with_retrofit.runnables

import android.content.Context

import com.sample.app.entity.Customer
import com.sample.app.repository.CustomerRepository

import java.lang.ref.WeakReference

class SaveCustomerRunnable(context: Context, private val customerList: List<Customer>) : Runnable {
    private val context: WeakReference<Context>

    init {
        this.context = WeakReference(context)
    }

    override fun run() {
        if (context.get() != null) {
            CustomerRepository.saveAll(customerList)
        }
    }
}
