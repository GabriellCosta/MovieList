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
import me.tigrao.movielist.data.MovieItemVO
import me.tigrao.movielist.detail.ui.DetailActivity
import me.tigrao.movielist.list.R

internal class MovieListAdapter :
    PagedListAdapter<MovieItemVO, MovieListAdapter.MovieListViewHolder>(RepoDiffConfig()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MovieListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val item = getItem(position)!!
        holder.bind(item)
    }

    internal class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val posterView by bind<ImageView>(R.id.image_list_movie)
        private val titleView by bind<TextView>(R.id.txt_list_movie_title)
        private val overviewView by bind<TextView>(R.id.txt_list_movie_overview)
        private val releaseDateView by bind<TextView>(R.id.txt_list_movie_release_date)
        private val genresView by bind<TextView>(R.id.txt_list_moive_genre)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(item: MovieItemVO) {
            titleView.text = item.title
            overviewView.text = item.overview
            genresView.text = item.genre
            releaseDateView.text = item.releaseDate

            Glide.with(posterView)
                .load("https://image.tmdb.org/t/p/w185/${item.posterPath}")
                .apply(RequestOptions.circleCropTransform())
                .into(posterView)
        }

        override fun onClick(v: View) {
            v.context.startActivity(DetailActivity(v.context))
        }
    }
}
