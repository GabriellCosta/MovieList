package me.tigrao.movielist.api

import me.tigrao.movielist.data.GenreResponseDTO

internal class GenreMapTransform(genreList: GenreResponseDTO) {

    private val genreMap: Map<Int, String> = genreList.genres.map {
        it.id to it.name
    }
        .toMap()

    fun map(genresId: List<Int>): List<String> {
        return genresId.map { genreId ->
            genreMap[genreId]!!
        }
    }
}
