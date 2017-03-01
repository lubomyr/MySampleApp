package com.sample.app.fragment_with_retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.app.R;
import com.sample.app.api.RetrofitUtil;
import com.sample.app.api.customer.CustomerAPI;
import com.sample.app.db.repository.CustomerRepository;
import com.sample.app.entity.Customer;
import com.sample.app.fragment_with_retrofit.runnables.SaveCustomerRunnable;
import com.sample.app.utils.GsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FragmentWithRetrofit extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = RetrofitUtil.getSimpleRetrofit();
        CustomerAPI customerAPI = retrofit.create(CustomerAPI.class);

        //Call<JsonElement> call = customerAPI.getCustomers1();
        Call<List<Customer>> call = customerAPI.getCustomers2();
        call.enqueue(custCallback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView      = inflater.inflate(R.layout.fragment_with_retrofit, container, false);
        return rootView;
    }

    Callback<JsonElement> jsonCallback = new Callback<JsonElement>() {
        @Override
        public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
            Log.d("response","onResponse");
            if (response.body() != null) {
                JsonElement json = response.body();
                Log.d("response","response :" + json);
                List<Customer> customerList = GsonUtils.getGson().fromJson(json, new TypeToken<List<Customer>>(){}.getType());
                saveCustomerToDb(customerList);
            }
        }

        @Override
        public void onFailure(Call<JsonElement> call, Throwable t) {
            Log.d("response","onFailure");
            getCustomerfromDB();
        }
    };

    Callback<List<Customer>> custCallback = new Callback<List<Customer>>() {
        @Override
        public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
            Log.d("response","onResponse");
            if (response.body() != null) {
                List<Customer> customerList = response.body();
                saveCustomerToDb(customerList);
            }
        }

        @Override
        public void onFailure(Call<List<Customer>> call, Throwable t) {
            Log.d("response","onFailure");
            getCustomerfromDB();
        }
    };

    private void saveCustomerToDb(List<Customer> customerList) {
        SaveCustomerRunnable saveCustomerRunnable = new SaveCustomerRunnable(getContext(), customerList);
        Thread thread = new Thread(saveCustomerRunnable);
        thread.start();
    }

    private void getCustomerfromDB() {
        List<Customer> customerList = CustomerRepository.getAll(getContext());
    }
}