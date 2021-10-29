package com.app_devs.stackoverflow.retrofit

import com.app_devs.stackoverflow.model.APIResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("questions?key=ZiXCZbWaOwnDgpVT9Hx8IA((&site=stackoverflow")
    fun getQuestions():Call<APIResponse>
}