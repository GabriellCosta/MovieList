package me.tigrao.movielist.viewmodel

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import me.tigrao.movielist.api.DataSourceFactoryGetter
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MovieListViewModelTest {

    private val factory = mock<DataSourceFactoryGetter>()
    private lateinit var movieListViewModel: MovieListViewModel

    @Before
    fun setup() {
        whenever(factory.getDataSource()).thenReturn(mock())

        movieListViewModel = MovieListViewModel(factory)
    }

    @Test
    fun givenAUiState_shouldCameFromDataSourceFactory() {
        assertEquals(factory.dataSourceLiveData, movieListViewModel.uiState)
    }
}
