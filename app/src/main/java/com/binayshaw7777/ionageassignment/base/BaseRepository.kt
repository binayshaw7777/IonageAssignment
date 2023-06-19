package com.binayshaw7777.ionageassignment.base

import android.content.Context
import com.binayshaw7777.ionageassignment.network.retrofit.ApiService
import com.binayshaw7777.ionageassignment.network.retrofit.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseRepository(val context: Context) {
    protected fun getRetrofit() = RetrofitService.getInstance(context).retrofitInstance

    private val apiService = getRetrofit().create(ApiService::class.java)

    suspend fun getUsers() = withContext(Dispatchers.IO) {
//        apiService.getUsers()
    }
}