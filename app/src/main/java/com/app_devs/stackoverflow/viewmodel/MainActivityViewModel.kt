package com.app_devs.stackoverflow.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app_devs.stackoverflow.model.APIResponse

import com.app_devs.stackoverflow.retrofit.RetroService
import com.app_devs.stackoverflow.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel:ViewModel() {
    var data=MutableLiveData<APIResponse>()
    fun getQuestionsObservable():MutableLiveData<APIResponse>
    {
        return data;
    }
    fun getQuestions()
    {
        val retrofitInstance=RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
        val call=retrofitInstance.getQuestions()
        call.enqueue(object :Callback<APIResponse>{
            override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
               if(response.isSuccessful)
               {
                   Log.d("check",response.body().toString())
                   data.postValue(response.body())
               }
               else
               {
                   Log.d("check","failed")
               }
            }

            override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                Log.d("check","failed")
            }

        })
    }
}