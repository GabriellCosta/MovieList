package me.tigrao.movielist.api

import me.tigrao.movielist.data.GenreResponseDTO
import me.tigrao.movielist.data.MovieItemDTO
import me.tigrao.movielist.data.MovieItemVO
import java.util.UUID

internal class MovieListTransform(genreList: GenreResponseDTO) {

    private val genreMap : Map<Int, String> = genreList.genres.map {
        it.id to it.name
    }
        .toMap()

    fun map(movieItemDTO: MovieItemDTO) : MovieItemVO {

        return MovieItemVO(
            UUID.randomUUID().toString(),
            title = movieItemDTO.title,
            overview = movieItemDTO.overview,
            posterPath =  movieItemDTO.posterPath,
            releaseDate = movieItemDTO.releaseDate,
            genre = createGenreList(movieItemDTO.genre).toString()
        )
    }

    private fun createGenreList(genresId: List<Int>): List<String> {
        return genresId.map { genreId ->
            genreMap[genreId]!!
        }
    }
}
