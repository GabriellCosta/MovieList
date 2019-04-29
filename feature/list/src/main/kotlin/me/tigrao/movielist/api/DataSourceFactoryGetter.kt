package me.tigrao.movielist.api

import me.tigrao.aegis.network.ui.UiSuccess
import me.tigrao.movielist.util.NetworkAvailable
import me.tigrao.persistence.MovieDatabaseFacade

internal class DataSourceFactoryGetter(
    private val isNetworkAvailable: NetworkAvailable,
    private val dataSourceFactory: DataSourceFactory,
    private val movieDatabaseFacade: MovieDatabaseFacade
) {

    val dataSourceLiveData = dataSourceFactory.dataSourceLiveData

    fun getDataSource() = if (isNetworkAvailable.isNetworkAvailable)
        dataSourceFactory
    else {
        movieDatabaseFacade.fetchMovies().also {
            dataSourceLiveData.postValue(UiSuccess(Unit))
        }
    }
}
