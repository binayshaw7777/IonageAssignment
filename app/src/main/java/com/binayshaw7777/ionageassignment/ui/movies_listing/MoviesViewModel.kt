package com.binayshaw7777.ionageassignment.ui.movies_listing

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.binayshaw7777.ionageassignment.base.BaseViewModel
import com.binayshaw7777.ionageassignment.model.ApiResponse
import com.binayshaw7777.ionageassignment.model.MovieDetails
import com.binayshaw7777.ionageassignment.network.onError
import com.binayshaw7777.ionageassignment.network.onException
import com.binayshaw7777.ionageassignment.network.onSuccess
import com.binayshaw7777.ionageassignment.utils.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MoviesViewModel(application: Application) : BaseViewModel(application) {

    private val repository = MoviesRepository(application)
    val movieSearchResponse = MutableLiveData<ApiResponse>()
    val movieDetailsResponse = MutableLiveData<MovieDetails>()

    fun fetchMovieSearchRequest(searchQuery: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = processCoroutine({ repository.fetchMovieSearchRequest(searchQuery) })
        response.onSuccess {
            movieSearchResponse.postValue(it)
        }.onError {
            Logger.debugLog("error: $it")
        }.onException {
            Logger.debugLog("exception: $it")
        }
    }

    fun fetchMovieDetailsRequest(imdbID: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = processCoroutine({ repository.fetchMovieDetailsRequest(imdbID) })
        response.onSuccess {
            movieDetailsResponse.postValue(it)
        }.onError {
            Logger.debugLog("error: $it")
        }.onException {
            Logger.debugLog("exception: $it")
        }
    }

}