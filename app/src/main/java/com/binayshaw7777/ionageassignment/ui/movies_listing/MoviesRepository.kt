package com.binayshaw7777.ionageassignment.ui.movies_listing

import android.content.Context
import com.binayshaw7777.ionageassignment.base.BaseRepository
import com.binayshaw7777.ionageassignment.network.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MoviesRepository(context: Context) : BaseRepository(context) {

    private val apiService = getRetrofit().create(ApiService::class.java)

    suspend fun fetchMovieSearchRequest(searchQuery: String) = withContext(Dispatchers.IO) {
        apiService.fetchMovieSearchRequest(searchQuery, 1)
    }

    suspend fun fetchMovieDetailsRequest(imdbID: String) = withContext(Dispatchers.IO) {
        apiService.fetchMovieDetailsRequest(imdbID)
    }
}