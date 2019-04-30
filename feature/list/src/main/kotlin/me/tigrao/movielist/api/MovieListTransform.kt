package me.tigrao.movielist.api

import me.tigrao.movielist.data.MovieItemDTO
import me.tigrao.movielist.data.MovieItemVO
import java.util.UUID

internal class MovieListTransform(private val genreMapTransform: GenreMapTransform) {

    fun map(movieItemDTO: MovieItemDTO): MovieItemVO {

        return MovieItemVO(
            UUID.randomUUID().toString(),
            title = movieItemDTO.title,
            overview = movieItemDTO.overview,
            posterPath = movieItemDTO.posterPath,
            releaseDate = movieItemDTO.releaseDate,
            genre = genreMapTransform.map(movieItemDTO.genre).toString()
        )
    }
}
