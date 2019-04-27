package me.tigrao.movielist.api

import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.tigrao.aegis.network.ui.UiStateLiveData
import me.tigrao.aegis.network.ui.uiAwait
import me.tigrao.movielist.data.MovieItemDTO

private const val FIRST_PAGE = 1

internal class MovieListDataSource(
    private val repository: MovieListRepository,
    private val listState: UiStateLiveData<Unit>
) :
    PageKeyedDataSource<Int, MovieItemDTO>() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, MovieItemDTO>
    ) {

        coroutineScope.launch {
            repository.fetchMovieList(FIRST_PAGE).uiAwait(listState) {
                callback.onResult(it.results, 0, nextPageCalculate(FIRST_PAGE))
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, MovieItemDTO>
    ) {
        coroutineScope.launch {
            repository.fetchMovieList(params.key).uiAwait(listState) {
                callback.onResult(it.results, nextPageCalculate(params.key))
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, MovieItemDTO>
    ) {
        //Not Implementable
    }

    private fun nextPageCalculate(currentPage: Int) = currentPage + 1
}
