package me.tigrao.movielist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import me.tigrao.movielist.api.DataSourceFactory
import me.tigrao.movielist.data.MovieItemDTO

private const val PAGE_SIZE = 3

internal class MovieListViewModel(factory: DataSourceFactory) : ViewModel() {

    val uiState = factory.dataSourceLiveData
    private val pagedLiveData: LiveData<PagedList<MovieItemDTO>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(true)
            .build()
        pagedLiveData = LivePagedListBuilder(factory, config).build()
    }

    fun fetchRepositories(): LiveData<PagedList<MovieItemDTO>> {
        return pagedLiveData
    }
}
