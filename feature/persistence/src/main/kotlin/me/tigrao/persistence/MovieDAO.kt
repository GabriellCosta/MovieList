package me.tigrao.persistence

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import me.tigrao.movielist.data.MovieItemVO

@Dao
interface MovieDAO {

    @Insert
    fun insertMovie(movieItemVO: MovieItemVO)

    @Query("SELECT * FROM MovieItemVO")
    fun fetchMovies() : DataSource.Factory<Int, MovieItemVO>

}
