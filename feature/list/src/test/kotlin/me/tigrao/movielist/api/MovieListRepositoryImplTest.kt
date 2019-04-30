package me.tigrao.movielist.api

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

@Suppress("DeferredResultUnused")
class MovieListRepositoryImplTest {

    private val api = mock<MovieListapi>()

    private val movieListRepositoryImpl = MovieListRepositoryImpl(api)

    @Test
    fun givenAMovieList_shouldCallApiFetchMovieList() {
        movieListRepositoryImpl.fetchMovieList(any())

        verify(api).fetchRepositoriesAsync(any())
    }

    @Test
    fun givenAMovieList_withPage2_ShouldCallApiFetchMovieListWithPage2() {
        movieListRepositoryImpl.fetchMovieList(2)

        verify(api).fetchRepositoriesAsync(2)
    }

    @Test
    fun givenAGenreList_shouldCallApiFetchGenres() {
        movieListRepositoryImpl.fetchGenres()

        verify(api).fetchGenres()
    }
}
