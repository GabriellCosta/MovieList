package me.tigrao.movielist.api

import me.tigrao.movielist.data.MovieItemDTO
import me.tigrao.movielist.data.MovieItemVO

internal class MovieListTransform {


    fun map(movieItemDTO: MovieItemDTO) : MovieItemVO {

        return MovieItemVO(
            title = movieItemDTO.title,
            overview = movieItemDTO.overview,
            posterPath =  movieItemDTO.posterPath,
            releaseDate = movieItemDTO.releaseDate,
            genre = listOf()
        )
    }
}
