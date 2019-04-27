package me.tigrao.movielist.api

import kotlinx.coroutines.Deferred
import me.tigrao.movielist.data.GenreResponseDTO
import me.tigrao.movielist.data.MovieListResponseDTO

internal interface MovieListRepository {

    fun fetchMovieList(page: Int): Deferred<MovieListResponseDTO>

    fun fetchGenres(): Deferred<GenreResponseDTO>
}
