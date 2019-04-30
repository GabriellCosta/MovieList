package me.tigrao.movielist.api

import me.tigrao.movielist.data.GenreItemDTO
import me.tigrao.movielist.data.GenreResponseDTO
import me.tigrao.movielist.data.MovieItemDTO
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieListTransformTest {

    private val movieListTransform = MovieListTransform(GenreMapTransform(createGenreDTOMock()))

    fun createGenreDTOMock(): GenreResponseDTO {
        return GenreResponseDTO(
            listOf(
                GenreItemDTO(
                    1,
                    "Action"
                )
            )
        )
    }

    fun createMovieResponseMock() =
        MovieItemDTO(
            title = "Movie",
            overview = "Overview",
            releaseDate = "2019-04-04",
            posterPath = "posterPath",
            genre = listOf(1)
        )

    @Test
    fun givenAMovieItem_withTitle_MovieVOShouldBeTheSame() {
        val movieDTO = createMovieResponseMock()

        val result = movieListTransform.map(movieDTO)

        assertEquals(movieDTO.title, result.title)
    }

    @Test
    fun givenMovieItem_withOverview_MovieVOShouldBetheSame() {
        val movieDTO = createMovieResponseMock()

        val result = movieListTransform.map(movieDTO)

        assertEquals(movieDTO.overview, result.overview)
    }

    @Test
    fun givenMovieItem_withPosterPath_MovieVOShouldBetheSame() {
        val movieDTO = createMovieResponseMock()

        val result = movieListTransform.map(movieDTO)

        assertEquals(movieDTO.posterPath, result.posterPath)
    }

    @Test
    fun givenMovieItem_withNullPosterPath_MovieVOPosterPathShouldBeEmptyString() {
        val movieDTO = MovieItemDTO(
            title = "Movie",
            overview = "Overview",
            releaseDate = "2019-04-04",
            posterPath = null,
            genre = listOf(1)
        )

        val result = movieListTransform.map(movieDTO)

        assertEquals("", result.posterPath)
    }

    @Test
    fun givenMovieItem_withReleaseDate_MovieVOShouldBetheSame() {
        val movieDTO = createMovieResponseMock()

        val result = movieListTransform.map(movieDTO)

        assertEquals(movieDTO.releaseDate, result.releaseDate)
    }

    @Test
    fun givenMovieItem_withGenreList_MovieVOShouldHaveConvertedGenreList() {
        val movieDTO = createMovieResponseMock()

        val result = movieListTransform.map(movieDTO)

        assertEquals(listOf("Action").toString(), result.genre)
    }
}
