package me.tigrao.movielist.di

import me.tigrao.aegis.network.NetworkClient
import me.tigrao.movielist.api.DataSourceFactory
import me.tigrao.movielist.api.MovieListapi
import me.tigrao.movielist.api.MovieListRepository
import me.tigrao.movielist.api.MovieListRepositoryImpl
import me.tigrao.movielist.viewmodel.MovieListViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val movieListModule = Kodein.Module("movieListModule") {

    bind<MovieListapi>() with singleton {
        NetworkClient.getApi(MovieListapi::class.java)
    }

    bind<DataSourceFactory>() with singleton {
        DataSourceFactory(instance())
    }

    bind<MovieListRepository>() with singleton {
        MovieListRepositoryImpl(instance())
    }

    bind<MovieListViewModel>() with provider {
        MovieListViewModel(instance())
    }
}
