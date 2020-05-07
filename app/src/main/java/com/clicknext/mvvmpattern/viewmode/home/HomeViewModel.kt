package com.clicknext.mvvmpattern.viewmode.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clicknext.mvvmpattern.service.ApiService
import com.clicknext.mvvmpattern.service.Service
import com.clicknext.mvvmpattern.service.model.home.GetPhotosResultModel
import com.clicknext.mvvmpattern.service.repo.HomeRepo


class HomeViewModel : ViewModel(){

    val photoLiveData = MutableLiveData<GetPhotosResultModel>()

    fun getPhoto(page:String,limit:String): MutableLiveData<GetPhotosResultModel> {
        val api = Service.instance.getRetrofit().create(ApiService::class.java)
        HomeRepo(api).callGetPhoto(page,limit)?.observeForever {
            photoLiveData.postValue(it.data)
        }

        return photoLiveData
    }


}