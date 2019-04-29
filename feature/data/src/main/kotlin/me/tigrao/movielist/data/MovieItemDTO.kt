package me.tigrao.movielist.data

import com.google.gson.annotations.SerializedName

data class MovieItemDTO(
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("genre_ids")
    val genre: List<Int>
)
