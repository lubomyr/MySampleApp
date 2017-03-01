package com.sample.app.api.customer;

import com.sample.app.entity.Customer;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CustomerAPI {
    @GET("js/customers_mysql.php")
    Call<JsonElement> getCustomers1();

    @GET("js/customers_mysql.php")
    Call<List<Customer>> getCustomers2();
}
