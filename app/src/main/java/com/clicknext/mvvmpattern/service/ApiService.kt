package com.clicknext.mvvmpattern.service

import com.clicknext.mvvmpattern.service.model.home.GetPhotosResultModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{

    @GET("list")
    fun getPhotos(
        @Query("page") page:String,
        @Query("limit") limit:String) : Call<GetPhotosResultModel>
}