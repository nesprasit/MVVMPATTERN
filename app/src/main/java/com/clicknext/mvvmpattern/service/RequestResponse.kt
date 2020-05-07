package com.clicknext.mvvmpattern.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.clicknext.mvvmpattern.utils.ServiceResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestResponse {
    fun <T> request(call: Call<T>?): LiveData<ServiceResource<T?>>? {
        val data = MutableLiveData<ServiceResource<T?>>()
        try {
            call?.enqueue(object : Callback<T> {
                override fun onResponse(
                    call: Call<T>,
                    response: Response<T>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        data.postValue(ServiceResource.success(response.body()))
                    } else
                        data.postValue(ServiceResource.error(response.message(), null))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    data.postValue(ServiceResource.network("Cannot connect Server", null))
                }
            })
        }catch (e: Exception){
            data.postValue(ServiceResource.error("", null))
        }
        return data
    }

}