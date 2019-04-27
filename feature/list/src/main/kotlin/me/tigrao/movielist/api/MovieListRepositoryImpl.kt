package me.tigrao.movielist.api

import kotlinx.coroutines.Deferred
import me.tigrao.movielist.data.GenreResponseDTO

internal class MovieListRepositoryImpl(private val api: MovieListapi) : MovieListRepository {

    override fun fetchMovieList(page: Int) =
        api.fetchRepositoriesAsync(page)

    override fun fetchGenres(): Deferred<GenreResponseDTO> =
        api.fetchGenres()
}
