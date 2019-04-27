package me.tigrao.movielist.data

import com.google.gson.annotations.SerializedName
import java.util.Date

internal data class MovieItemDTO(
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: Date,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("genre_ids")
    val genre: List<Int>
)
