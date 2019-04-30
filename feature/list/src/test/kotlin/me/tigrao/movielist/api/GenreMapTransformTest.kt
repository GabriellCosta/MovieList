package me.tigrao.movielist.api

import junit.framework.Assert.*
import me.tigrao.movielist.data.GenreItemDTO
import me.tigrao.movielist.data.GenreResponseDTO
import org.junit.Before
import org.junit.Test

class GenreMapTransformTest {

    private lateinit var genreMapTransform: GenreMapTransform

    @Before
    fun setup() {
        genreMapTransform = GenreMapTransform(createGenreDTOMock())
    }

    fun createGenreDTOMock(): GenreResponseDTO {
        return GenreResponseDTO(
            listOf(
                GenreItemDTO(
                    1,
                    "Action"
                ),
                GenreItemDTO(
                    2,
                    "Terror"
                ),
                GenreItemDTO(
                    3,
                    "Horror"
                ),
                GenreItemDTO(
                    4,
                    "Tigers"
                )
            )
        )
    }

    @Test
    fun givenAGenreDTO_withFourItems_ShouldHaveSameSizeList() {
        val genreList = createGenreDTOMock()
        genreMapTransform = GenreMapTransform(genreList)

        val result = genreMapTransform.map(listOf(1, 2, 3, 4))

        assertEquals(genreList.genres.size, result.size)
    }

    @Test
    fun givenAGenreWithId_shouldCreateList_withKeyAsIdAndValueAsName() {
        val genreList = createGenreDTOMock()
        genreMapTransform = GenreMapTransform(genreList)

        val result = genreMapTransform.map(listOf(1))

        assertEquals("Action", result[0])
    }

    @Test
    fun givenListOfGenreIds_convertingUsingGenreMaps_ShouldReturnCorrectGenreNames() {
        val genreList = createGenreDTOMock()
        genreMapTransform = GenreMapTransform(genreList)

        val result = genreMapTransform.map(listOf(1, 2, 3, 4))

        val expected = listOf("Action", "Terror", "Horror", "Tigers")

        assertEquals(expected, result)
    }
}
