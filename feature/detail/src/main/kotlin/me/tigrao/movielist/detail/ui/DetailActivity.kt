package me.tigrao.movielist.detail.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.tigrao.movielist.detail.R
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

class DetailActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()

    companion object {

        operator fun invoke(context: Context) : Intent {
            return Intent(context, DetailActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)
    }

}
