package com.app_devs.stackoverflow.repository

import com.app_devs.stackoverflow.model.APIResponse
import com.app_devs.stackoverflow.retrofit.RetroService
import com.app_devs.stackoverflow.retrofit.RetrofitInstance
import retrofit2.Response

class StackOverflowRepo {
    private val retrofitInstance=RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
    suspend fun getResponse():Response<APIResponse>{
        return retrofitInstance.getQuestions()
    }
}