package com.app_devs.stackoverflow.retrofit

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private const val baseUrl="https://api.stackexchange.com/2.2/"
        fun getRetrofitInstance():Retrofit
        {
            val logging=HttpLoggingInterceptor()
            logging.level=HttpLoggingInterceptor.Level.BODY
            val client=okhttp3.OkHttpClient.Builder()
            client.addInterceptor(logging)

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}