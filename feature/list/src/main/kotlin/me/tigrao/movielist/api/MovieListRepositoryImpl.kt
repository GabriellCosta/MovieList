package me.tigrao.movielist.api

internal class MovieListRepositoryImpl(private val api: MovieListapi) : MovieListRepository {

    override fun fetchMovieList(page: Int) =
        api.fetchRepositoriesAsync(page)
}
