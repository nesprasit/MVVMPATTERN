package com.clicknext.mvvmpattern.service.model.home

import com.google.gson.annotations.SerializedName

class GetPhotosResultModel : ArrayList<GetPhotosResultModelItem>()
data class GetPhotosResultModelItem(
    val author: String,
    @SerializedName("download_url")
    val downloadUrl: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)
