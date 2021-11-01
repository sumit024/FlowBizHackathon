package com.app_devs.stackoverflow.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app_devs.stackoverflow.model.APIResponse
import com.app_devs.stackoverflow.repository.StackOverflowRepo

import com.app_devs.stackoverflow.retrofit.RetroService
import com.app_devs.stackoverflow.retrofit.RetrofitInstance
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel:ViewModel() {
    var data=MutableLiveData<APIResponse>()
    private var job:Job?=null
    fun getQuestionsObservable():MutableLiveData<APIResponse>
    {
        return data;
    }
    fun getQuestions()
    {
        job=CoroutineScope(Dispatchers.IO).launch {
            val response=StackOverflowRepo().getResponse()
            withContext(Dispatchers.Main){
                if(response.isSuccessful)
                {

                    Log.d("sumit",response.body().toString())
                    data.value=response.body()
                }
                else
                {
                    Log.d("sumit","failed")
                }
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}