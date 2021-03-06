package com.bingo.ybd.data.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {

    private const val TAG = "ServiceCreator"
    private const val BASE_URL = "http://193.112.205.254:8080/ybd/"
    //test ip:192.168.202.93 , normal ip : 193.112.205.254
    private val retrofit: Retrofit

    init {
        val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            Log.e(TAG, message)
        })
        logger.level = HttpLoggingInterceptor.Level.BASIC

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
        retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

            .build()
    }



    fun <T> create(serviceClass:Class<T>):T = retrofit.create(serviceClass)

    inline fun <reified  T> create():T = create(T::class.java)

}