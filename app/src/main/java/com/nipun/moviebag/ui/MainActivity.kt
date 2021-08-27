package com.nipun.moviebag.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ActionMenuView
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nipun.moviebag.R
import com.nipun.moviebag.adapter.movie.MoviesAdapter
import com.nipun.moviebag.adapter.trendingMovie.TrendingMoviesAdapter
import com.nipun.moviebag.clickListener.ImageClickListener
import com.nipun.moviebag.databinding.ActivityMainBinding
import com.nipun.moviebag.model.movieList.Movie
import com.nipun.moviebag.model.topRated.Result
import com.nipun.moviebag.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ImageClickListener {

    val viewModel by viewModels<MoviesViewModel>()
    private lateinit var binding: ActivityMainBinding
    private var moviesList = mutableListOf<Movie>()
    private var topRated = mutableListOf<Result>()
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var trendingMoviesAdapter: TrendingMoviesAdapter

    var page = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /**
         * starting the shimmer effect
         */
        binding.apply {
            shimmerFrameLayout.startShimmerAnimation()
        }

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        setMoviesListRecycler(layoutManager)

        setTrendingMoviesRecycler()

        callApi(viewModel)

        pagination(layoutManager, viewModel, this)


    }

    /**
     * calling the api  here.
     */

    private fun callApi(viewModel: MoviesViewModel) {

        viewModel.getMoviesViewModel(1).observe(this, Observer {
            shimmerDisplay()
            moviesList.clear()
            val res = it.data!!
            moviesList.addAll(res)
            Log.d("Nipun", moviesList.size.toString())
            moviesAdapter.notifyDataSetChanged()
            trendingMoviesAdapter.notifyDataSetChanged()
        })
        viewModel.getTopRatedViewModel(1).observe(this, Observer {
            shimmerDisplay()
            topRated.clear()
            val res = it.data!!
            topRated.addAll(res)
            Log.d("Nipun", moviesList.size.toString())
            trendingMoviesAdapter.notifyDataSetChanged()
        })
    }

    /**
     * setting the trending list recyclerview
     */

    private fun setTrendingMoviesRecycler() {
        binding.rvTrendingList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        trendingMoviesAdapter = TrendingMoviesAdapter(topRated, this)
        binding.rvTrendingList.adapter = trendingMoviesAdapter
    }

    /**
     * setting all the movie list recyclerview here
     */

    private fun setMoviesListRecycler(layoutManager: LinearLayoutManager) {
        binding.rvMoviesList.layoutManager = layoutManager
        moviesAdapter = MoviesAdapter(moviesList, this)
        binding.rvMoviesList.adapter = moviesAdapter

    }

    /**
     * function for the pagination
     */

    private fun pagination(
        layoutManager: LinearLayoutManager,
        viewModel: MoviesViewModel,
        mainActivity: MainActivity
    ) {
        var loading = true
        var pastVisibleItems: Int
        var visibleItemCount: Int
        var totalItemCount: Int
        binding.rvMoviesList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                            page++
                            loading = false
                            Log.v("...", "Last Item Wow ! $page")
                            viewModel.getMoviesViewModel(page).observe(mainActivity, {
                                val result = it.data!!
                                moviesList.addAll(result)
                                moviesAdapter.notifyDataSetChanged()

                            })
                            loading = true
                        }
                    }
                }
            }
        })
    }


    /**
     * function to display the shimmer effect
     */

    private fun shimmerDisplay() {
        binding.apply {
            shimmerFrameLayout.stopShimmerAnimation()
            shimmerFrameLayout.visibility = View.GONE
            rvMoviesList.visibility = View.VISIBLE
            rvTrendingList.visibility = View.VISIBLE
            tvNowShowing.visibility = View.VISIBLE
        }
        moviesList.clear()
    }

    /**
     * on click of each item its data will be passed to next activity through intent
     */

    override fun onImageClicked(movie: Movie, mIvImage: ImageView) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("movies", movie)

        startActivity(intent)
    }

    /**
     * on click of each horizontal item its data will be passed to next activity through intent
     */

    override fun onImageClickedToRated(movie: Result, mIvImage: ImageView) {
        val intent = Intent(this, MovieDetailActivity2::class.java)
        intent.putExtra("movies1", movie)


        startActivity(intent)

    }
}