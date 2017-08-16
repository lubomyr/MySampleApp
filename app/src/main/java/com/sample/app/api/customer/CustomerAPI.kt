package com.sample.app.api.customer

import com.google.gson.JsonElement
import com.sample.app.entity.Customer
import retrofit2.Call
import retrofit2.http.GET

interface CustomerAPI {
    @get:GET("js/customers_mysql.php")
    val customers1: Call<JsonElement>

    @get:GET("js/customers_mysql.php")
    val customers2: Call<List<Customer>>
}
