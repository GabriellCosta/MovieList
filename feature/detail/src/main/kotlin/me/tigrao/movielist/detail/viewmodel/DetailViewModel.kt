package me.tigrao.movielist.detail.viewmodel

import androidx.lifecycle.ViewModel
import me.tigrao.movielist.data.MovieItemVO
import me.tigrao.persistence.MovieDatabaseFacade

internal class DetailViewModel(private val movieDatabaseFacade: MovieDatabaseFacade) : ViewModel() {

    fun saveMovie(movieItemVO: MovieItemVO) {
        movieDatabaseFacade.save(movieItemVO)
    }
}
