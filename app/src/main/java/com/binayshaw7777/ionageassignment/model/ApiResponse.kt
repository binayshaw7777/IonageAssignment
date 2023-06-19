package com.binayshaw7777.ionageassignment.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("Search") val searchResults: List<SearchResult>?
)
