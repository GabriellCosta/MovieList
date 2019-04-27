package me.tigrao.movielist.api

import androidx.paging.DataSource
import me.tigrao.aegis.network.ui.UiStateLiveData
import me.tigrao.movielist.data.MovieItemDTO

internal class DataSourceFactory(private val repository: MovieListRepository) :
    DataSource.Factory<Int, MovieItemDTO>() {

    val dataSourceLiveData = UiStateLiveData<Unit>()

    override fun create(): DataSource<Int, MovieItemDTO> {
        return MovieListDataSource(repository, dataSourceLiveData)
    }
}
