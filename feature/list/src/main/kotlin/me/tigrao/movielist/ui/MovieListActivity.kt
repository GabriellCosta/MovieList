package me.tigrao.movielist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.tigrao.aegis.commons.di.viewModel
import me.tigrao.aegis.commons.ui.bind
import me.tigrao.aegis.network.ui.observeOnError
import me.tigrao.aegis.network.ui.observeOnLoading
import me.tigrao.aegis.network.ui.observeOnSuccess
import me.tigrao.movielist.list.R
import me.tigrao.movielist.viewmodel.MovieListViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

internal class MovieListActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()

    private val recyclerView by bind<RecyclerView>(R.id.rv_movie_list)
    private val loadingView by bind<View>(R.id.loading_movie_list)

    private val movieListAdapter = MovieListAdapter()

    private val viewModel: MovieListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_movie_list)

        prepareState()
        prepareList()

        viewModel.fetchRepositories()
            .observe(this, Observer(movieListAdapter::submitList))
    }

    private fun prepareState() {
        viewModel.uiState.observeOnSuccess(this) { Unit ->
            loadingView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE

            Toast.makeText(this, "Deu Bom Mlk : )", Toast.LENGTH_LONG).show()

        }
            .observeOnLoading(this) {
            }
            .observeOnError(this) {
                Toast.makeText(this, "Deu Ruim", Toast.LENGTH_LONG).show()
            }
    }

    private fun prepareList() {
        val createLayoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            createLayoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.adapter = movieListAdapter
        recyclerView.layoutManager = createLayoutManager
    }
}
