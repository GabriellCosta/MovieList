package me.tigrao.movielist.ui

import androidx.recyclerview.widget.DiffUtil
import me.tigrao.movielist.data.MovieItemDTO

internal class RepoDiffConfig : DiffUtil.ItemCallback<MovieItemDTO>() {
    override fun areItemsTheSame(oldItem: MovieItemDTO, newItem: MovieItemDTO): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: MovieItemDTO, newItem: MovieItemDTO): Boolean {
        return oldItem == newItem
    }
}
