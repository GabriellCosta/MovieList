package me.tigrao.movielist.data

import com.google.gson.annotations.SerializedName

class GenreResponseDTO(
    @SerializedName("genres")
    val genres: List<GenreItemDTO>
)
