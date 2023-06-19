package com.binayshaw7777.ionageassignment.model

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("imdbID") val imdbId: String,
    @SerializedName("Poster") val posterLink: String,
)
