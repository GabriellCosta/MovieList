package me.tigrao.movielist.data

import com.google.gson.annotations.SerializedName

internal class GenreItemDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
