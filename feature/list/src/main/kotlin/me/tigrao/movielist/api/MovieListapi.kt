package me.tigrao.movielist.api

import kotlinx.coroutines.Deferred
import me.tigrao.movielist.data.MovieListResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieListapi {

    @GET("3/movie/upcoming?api_key=1f54bd990f1cdfb230adb312546d765d&language=pt-BR&page=1")
    fun fetchRepositoriesAsync(@Query("page") page: Int): Deferred<MovieListResponseDTO>
}
