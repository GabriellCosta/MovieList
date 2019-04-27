package me.tigrao.movielist.data

import com.google.gson.annotations.SerializedName

internal class MovieListResponseDTO(
    @SerializedName("results")
    val results: List<MovieItemDTO>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)
