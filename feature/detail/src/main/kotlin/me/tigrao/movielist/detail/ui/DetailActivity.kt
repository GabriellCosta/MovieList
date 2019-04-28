package me.tigrao.movielist.detail.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.tigrao.movielist.data.MovieItemVO
import me.tigrao.movielist.detail.R
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

class DetailActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()

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
    }

}
