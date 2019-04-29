package me.tigrao.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import me.tigrao.movielist.data.MovieItemVO

@Database(entities = [MovieItemVO::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDAO() : MovieDAO

}
