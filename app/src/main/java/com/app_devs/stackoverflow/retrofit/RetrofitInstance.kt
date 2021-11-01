package com.app_devs.stackoverflow.retrofit

import com.app_devs.stackoverflow.utils.Constants
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {
    companion object{
        fun getRetrofitInstance():Retrofit
        {
            val logging=HttpLoggingInterceptor()
            logging.level=HttpLoggingInterceptor.Level.BODY
            val client=okhttp3.OkHttpClient.Builder()
            client.addInterceptor(logging)

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}