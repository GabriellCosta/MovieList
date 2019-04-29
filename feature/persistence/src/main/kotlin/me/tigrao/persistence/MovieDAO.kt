package me.tigrao.persistence

import androidx.room.Insert
import androidx.room.Query
import me.tigrao.movielist.data.MovieItemVO

interface MovieDAO {

    @Insert
    fun insertMovie(movieItemVO: MovieItemVO)

    @Query("SELECT * FROM MovieItemVO")
    fun fetchMovies() : List<MovieItemVO>

}
