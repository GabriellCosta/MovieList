package me.tigrao.movielist.ui

import androidx.recyclerview.widget.DiffUtil
import me.tigrao.movielist.data.MovieItemDTO
import me.tigrao.movielist.data.MovieItemVO

internal class RepoDiffConfig : DiffUtil.ItemCallback<MovieItemVO>() {
    override fun areItemsTheSame(oldItem: MovieItemVO, newItem: MovieItemVO): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: MovieItemVO, newItem: MovieItemVO): Boolean {
        return oldItem == newItem
    }
}
