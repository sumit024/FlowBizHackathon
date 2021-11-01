package com.app_devs.stackoverflow.retrofit

import com.app_devs.stackoverflow.utils.Constants
import com.app_devs.stackoverflow.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("2.2/questions")
    suspend fun getQuestions(
        @Query("key")key:String= Constants.API_KEY,
        @Query("order")order:String="desc",
        @Query("sort")sort:String="activity",
        @Query("site")site:String="stackoverflow"
    ):Response<APIResponse>
}