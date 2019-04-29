package me.tigrao.movielist.api

import kotlinx.coroutines.Deferred
import me.tigrao.movielist.data.GenreResponseDTO
import me.tigrao.movielist.data.MovieListResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieListapi {

    @GET("3/movie/upcoming?language=pt-BR&page=1")
    fun fetchRepositoriesAsync(@Query("page") page: Int): Deferred<MovieListResponseDTO>

    @GET("3/genre/movie/list?language=pt-BR")
    fun fetchGenres(): Deferred<GenreResponseDTO>
}
