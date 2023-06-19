package com.binayshaw7777.ionageassignment.network

import android.content.Context
import com.binayshaw7777.ionageassignment.network.retrofit.ApiService
import com.binayshaw7777.ionageassignment.network.retrofit.RetrofitService

/**
 * Base repository which can be used to get the singleton Retrofit instance
 */
open class BaseRepository(private val context: Context) {
    protected fun getRetrofit() = RetrofitService.getInstance(context).retrofitInstance

    private val apiService = getRetrofit().create(ApiService::class.java)

//    suspend fun getUsers() = withContext(Dispatchers.IO) {
//        apiService.getUsers()
//    }
}