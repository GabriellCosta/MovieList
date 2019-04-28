package me.tigrao.movielist.detail.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.tigrao.aegis.commons.ui.bind
import me.tigrao.movielist.data.MovieItemVO
import me.tigrao.movielist.detail.R
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

class DetailActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()

    private val posterView by bind<ImageView>(R.id.image_list_movie)
    private val titleView by bind<TextView>(R.id.txt_list_movie_title)
    private val overviewView by bind<TextView>(R.id.txt_list_movie_overview)
    private val releaseDateView by bind<TextView>(R.id.txt_list_movie_release_date)
    private val genresView by bind<TextView>(R.id.txt_list_moive_genre)

    companion object {

        private const val EXTRA_DETAIL_ITEM = "EXTRA_DETAIL_ITEM"

        operator fun invoke(context: Context, item: MovieItemVO) : Intent {
            return Intent(context, DetailActivity::class.java)
                .putExtra(EXTRA_DETAIL_ITEM, item)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        prepareView()
    }

    private fun prepareView() {
        val vo = intent.extras!![EXTRA_DETAIL_ITEM] as MovieItemVO

        bind(vo)
    }

    private fun bind(item: MovieItemVO) {
        titleView.text = item.title
        overviewView.text = item.overview
        genresView.text = item.genre
        releaseDateView.text = item.releaseDate

        Glide.with(posterView)
            .load("https://image.tmdb.org/t/p/w185/${item.posterPath}")
            .apply(RequestOptions.circleCropTransform())
            .into(posterView)
    }
}
