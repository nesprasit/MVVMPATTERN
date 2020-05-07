package com.clicknext.mvvmpattern.service.repo

import androidx.lifecycle.LiveData
import com.clicknext.mvvmpattern.service.ApiService
import com.clicknext.mvvmpattern.service.RequestResponse
import com.clicknext.mvvmpattern.service.model.home.GetPhotosResultModel
import com.clicknext.mvvmpattern.utils.ServiceResource

class HomeRepo(val api : ApiService) {

    fun callGetPhoto(page:String,limit:String):
            LiveData<ServiceResource<GetPhotosResultModel?>>? = RequestResponse().request(api.getPhotos(page,limit))
}