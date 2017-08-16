package com.sample.app.fragment_with_retrofit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import com.sample.app.R
import com.sample.app.api.RetrofitUtil
import com.sample.app.api.customer.CustomerAPI
import com.sample.app.entity.Customer
import com.sample.app.fragment_with_retrofit.runnables.SaveCustomerRunnable
import com.sample.app.repository.CustomerRepository
import com.sample.app.utils.GsonUtils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentWithRetrofit : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = RetrofitUtil.simpleRetrofit
        val customerAPI = retrofit.create(CustomerAPI::class.java)

        val call = customerAPI.customers1
        //Call<List<Customer>> call = customerAPI.getCustomers2();
        call.enqueue(jsonCallback)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_with_retrofit, container, false)
        return rootView
    }

    internal var jsonCallback: Callback<JsonElement> = object : Callback<JsonElement> {
        override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
            Log.d("response", "onResponse")
            if (response.body() != null) {
                val json = response.body()
                Log.d("response", "response :" + json)
                val customerList = GsonUtils.getGson()!!.fromJson<List<Customer>>(json, object : TypeToken<List<Customer>>() {

                }.type)
                saveCustomerToDb(customerList)
            }
        }

        override fun onFailure(call: Call<JsonElement>, t: Throwable) {
            Log.d("response", "onFailure")
            getCustomerfromDB()
        }
    }

    internal var custCallback: Callback<List<Customer>> = object : Callback<List<Customer>> {
        override fun onResponse(call: Call<List<Customer>>, response: Response<List<Customer>>) {
            Log.d("response", "onResponse")
            if (response.body() != null) {
                val customerList = response.body()
                if (customerList != null) {
                    saveCustomerToDb(customerList)
                }
            }
        }

        override fun onFailure(call: Call<List<Customer>>, t: Throwable) {
            Log.d("response", "onFailure")
            getCustomerfromDB()
        }
    }

    private fun saveCustomerToDb(customerList: List<Customer>) {
        val saveCustomerRunnable = SaveCustomerRunnable(context, customerList)
        val thread = Thread(saveCustomerRunnable)
        thread.start()
    }

    private fun getCustomerfromDB() {
        val customerList = CustomerRepository.all
    }
}