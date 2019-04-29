package me.tigrao.persistence

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.tigrao.movielist.data.MovieItemVO

class MovieDatabaseFacade(context: Context) {

    private val movieDatabase: MovieDatabase = Room
        .databaseBuilder(context, MovieDatabase::class.java, "MOVIE_DATABASE")
        .fallbackToDestructiveMigration()
        .build()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun save(movieItemVO: MovieItemVO) {
        coroutineScope.launch {
            movieDatabase.movieDAO().insertMovie(movieItemVO)
        }
    }

    fun fetchMovies() = movieDatabase.movieDAO().fetchMovies()
}
