package com.clicknext.mvvmpattern.service

import com.clicknext.mvvmpattern.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class Service {

    private val TIMEOUT:Long = 20
    private var okHttpClient: OkHttpClient.Builder

    private object HOLDER{
        val INSTANCE = Service()
    }
    companion object{
        val instance by lazy { HOLDER.INSTANCE }
    }

    init {
        okHttpClient = OkHttpClient.Builder()
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT,TimeUnit.SECONDS)

        if (BuildConfig.DEBUG){
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            okHttpClient.addInterceptor(logger)
        }
    }

    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://picsum.photos/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())
        .build()


}


















