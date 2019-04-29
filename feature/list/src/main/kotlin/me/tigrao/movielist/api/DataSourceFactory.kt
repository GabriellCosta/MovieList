package me.tigrao.movielist.api

import androidx.paging.DataSource
import me.tigrao.aegis.network.ui.UiStateLiveData
import me.tigrao.movielist.data.MovieItemVO

internal class DataSourceFactory(private val repository: MovieListRepository) :
    DataSource.Factory<Int, MovieItemVO>() {

    val dataSourceLiveData = UiStateLiveData<Unit>()

    override fun create(): DataSource<Int, MovieItemVO> {
        return MovieListDataSource(repository, dataSourceLiveData)
    }
}
