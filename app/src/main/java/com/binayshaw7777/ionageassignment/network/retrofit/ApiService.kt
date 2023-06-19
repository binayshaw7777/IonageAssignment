package com.binayshaw7777.ionageassignment.network.retrofit

import com.binayshaw7777.ionageassignment.model.ApiResponse
import com.binayshaw7777.ionageassignment.model.MovieDetails
import com.binayshaw7777.ionageassignment.network.NetworkResponse
import com.binayshaw7777.ionageassignment.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(" ")
    suspend fun fetchMovieSearchRequest(
        @Query("s") searchQuery: String,
        @Query("page") pageNumber: Int = 1,
        @Query("apikey") apiKey: String = Constants.API_KEY,
    ): NetworkResponse<ApiResponse>

    @GET(" ")
    suspend fun fetchMovieDetailsRequest(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey: String = Constants.API_KEY,
    ): NetworkResponse<MovieDetails>
}