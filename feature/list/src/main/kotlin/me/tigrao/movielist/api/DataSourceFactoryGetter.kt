package me.tigrao.movielist.api

import androidx.paging.DataSource
import me.tigrao.aegis.network.ui.UiStateLiveData
import me.tigrao.movielist.data.MovieItemVO

interface DataSourceFactoryGetter {

    val dataSourceLiveData: UiStateLiveData<Unit>

    fun getDataSource(): DataSource.Factory<Int, MovieItemVO>
}
