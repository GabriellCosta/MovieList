package me.tigrao.movielist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.tigrao.aegis.commons.ui.bind
import me.tigrao.movielist.data.MovieItemDTO
import me.tigrao.movielist.list.R

internal class MovieListAdapter  :
    PagedListAdapter<MovieItemDTO, MovieListAdapter.MovieListViewHolder>(RepoDiffConfig()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MovieListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val item = getItem(position)!!
        holder.bind(item)
    }

    internal class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val posterView by bind<ImageView>(R.id.image_list_movie)
        private val titleView by bind<TextView>(R.id.txt_list_movie_title)
        private val overviewView by bind<TextView>(R.id.txt_list_movie_overview)
        private val releaseDateView by bind<TextView>(R.id.txt_list_movie_release_date)

        fun bind(item: MovieItemDTO) {
            titleView.text = item.title
            overviewView.text = item.overview
            releaseDateView.text = item.releaseDate.toString()

            Glide.with(posterView)
                .load("https://image.tmdb.org/t/p/w185/${item.posterPath}")
                .apply(RequestOptions.circleCropTransform())
                .into(posterView)
        }
    }
}
