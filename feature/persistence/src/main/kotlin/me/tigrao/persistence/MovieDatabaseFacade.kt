package me.tigrao.persistence

import android.content.Context
import androidx.room.Room
import me.tigrao.movielist.data.MovieItemVO

class MovieDatabaseFacade(context: Context) {

    private val movieDatabase: MovieDatabase = Room
        .databaseBuilder(context, MovieDatabase::class.java, "MOVIE_DATABASE")
        .fallbackToDestructiveMigration()
        .build()

    fun save(movieItemVO: MovieItemVO) {
        movieDatabase.movieDAO().insertMovie(movieItemVO)
    }

    fun fetchMovies() = movieDatabase.movieDAO().fetchMovies()
}
