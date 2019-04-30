package me.tigrao.movielist.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import me.tigrao.aegis.commons.di.viewModel
import me.tigrao.aegis.commons.ui.bind
import me.tigrao.aegis.network.ui.ErrorData
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
    private val toolbar by bind<Toolbar>(R.id.toolbar_movie_list)
    private val movieListAdapter = MovieListAdapter()

    private val viewModel: MovieListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_movie_list)

        prepareUi()
    }

    private fun prepareUi() {
        prepareState()
        prepareList()
        prepareToolbar()

        viewModel.fetchRepositories()
            .observe(this, Observer(movieListAdapter::submitList))
    }

    private fun prepareToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun prepareState() {
        viewModel.uiState.observeOnSuccess(this, ::onSuccess)
            .observeOnLoading(this, ::onLoading)
            .observeOnError(this, ::onError)
    }

    private fun onSuccess() {
        loadingView.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE

        Toast.makeText(this, "Deu Bom Mlk : )", Toast.LENGTH_LONG).show()
    }

    private fun onLoading() {
        loadingView.visibility = View.VISIBLE
    }

    private fun onError(errorData: ErrorData) {
        errorData.throwable.printStackTrace()

        val rootView = window.decorView.rootView
        Snackbar.make(rootView, "Um erro ocorreu", Snackbar.LENGTH_INDEFINITE)
            .show()
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_sort)
            sort()

        return super.onOptionsItemSelected(item)
    }

    private fun sort() {
        Toast.makeText(this, "Sort", Toast.LENGTH_LONG).show()
    }
}
