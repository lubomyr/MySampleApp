package com.sample.app.api

import com.google.gson.GsonBuilder
import com.sample.app.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitUtil {

    private var mRetrofit: Retrofit? = null

    val simpleRetrofit: Retrofit
        get() {
            if (mRetrofit == null) {
                val okHttpClient = OkHttpClient.Builder()
                        .readTimeout(60, TimeUnit.SECONDS)
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .build()
                var url = ApiConstant.DOMAIN
                if (BuildConfig.DEBUG)
                    url = ApiConstant.DOMAIN

                val gson = GsonBuilder()
                        .setLenient()
                        .create()

                mRetrofit = Retrofit.Builder()
                        .baseUrl(url)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
            }
            return mRetrofit!!
        }
}
