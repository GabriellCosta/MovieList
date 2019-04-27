package me.tigrao.movielist.data

import com.google.gson.annotations.SerializedName

internal class GenreResponseDTO(
    @SerializedName("genres")
    val genres : List<GenreItemDTO>
)
