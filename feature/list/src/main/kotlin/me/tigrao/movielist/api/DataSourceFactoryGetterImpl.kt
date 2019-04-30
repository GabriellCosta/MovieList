package me.tigrao.movielist.api

import me.tigrao.aegis.network.ui.UiSuccess
import me.tigrao.movielist.util.NetworkAvailable
import me.tigrao.persistence.MovieDatabaseFacade

internal class DataSourceFactoryGetterImpl(
    private val isNetworkAvailable: NetworkAvailable,
    private val dataSourceFactory: DataSourceFactory,
    private val movieDatabaseFacade: MovieDatabaseFacade
) : DataSourceFactoryGetter {

    override val dataSourceLiveData = dataSourceFactory.dataSourceLiveData

    override fun getDataSource() = if (isNetworkAvailable.isNetworkAvailable)
        dataSourceFactory
    else {
        movieDatabaseFacade.fetchMovies().also {
            dataSourceLiveData.postValue(UiSuccess(Unit))
        }
    }
}
