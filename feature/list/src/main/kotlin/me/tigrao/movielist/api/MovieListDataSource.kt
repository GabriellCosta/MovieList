package me.tigrao.movielist.api

import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.tigrao.aegis.network.ui.UiStateLiveData
import me.tigrao.aegis.network.ui.uiAwait
import me.tigrao.movielist.data.MovieItemVO

private const val FIRST_PAGE = 1

internal class MovieListDataSource(
    private val repository: MovieListRepository,
    private val listState: UiStateLiveData<Unit>
) :
    PageKeyedDataSource<Int, MovieItemVO>() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private lateinit var movieListTransform: MovieListTransform

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, MovieItemVO>
    ) {

        coroutineScope.launch {
            val genreList = repository.fetchGenres().await()

            movieListTransform = MovieListTransform(genreList)

            repository.fetchMovieList(FIRST_PAGE).uiAwait(listState) {

                val result = it.results.map(movieListTransform::map)

                callback.onResult(result, 0, nextPageCalculate(FIRST_PAGE))
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, MovieItemVO>
    ) {
        coroutineScope.launch {
            repository.fetchMovieList(params.key).uiAwait(listState) {

                val result = it.results.map(movieListTransform::map)

                callback.onResult(result, nextPageCalculate(params.key))
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, MovieItemVO>
    ) {
        //Not Implementable
    }

    private fun nextPageCalculate(currentPage: Int) = currentPage + 1
}
