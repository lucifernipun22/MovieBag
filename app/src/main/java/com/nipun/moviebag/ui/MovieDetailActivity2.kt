package com.nipun.moviebag.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.nipun.moviebag.R
import com.nipun.moviebag.adapter.production.ProductionAdapter
import com.nipun.moviebag.adapter.similarMovies.SimilarMovieAdapter
import com.nipun.moviebag.clickListener.ImageClickListener
import com.nipun.moviebag.databinding.ActivityMovieDetail2Binding
import com.nipun.moviebag.model.movieDetails.ProductionCompany
import com.nipun.moviebag.model.movieList.Movie
import com.nipun.moviebag.model.topRated.Result
import com.nipun.moviebag.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailActivity2 : AppCompatActivity() , ImageClickListener{

    val viewModel by viewModels<MoviesViewModel>()
    private lateinit var binding: ActivityMovieDetail2Binding
    private lateinit var movieList1: Result
    private var productionList = mutableListOf<ProductionCompany>()
    private lateinit var productionAdapter: ProductionAdapter
    private var topRated = mutableListOf<Result>()
    private lateinit var similarAdapter: SimilarMovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail2)
        binding = ActivityMovieDetail2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getData()

        binding.castButton.setOnClickListener {
            clickListener()
        }
        binding.reviewButton.setOnClickListener {
            clickListener2()
        }
        setTrendingMoviesRecycler()
        setMoviesListRecycler()
        callApiProduction(viewModel)
        callApi(viewModel)
    }
    /**
     * getting all the data through intent from previous activity and setting the data to respective views
     */
    private fun getData() {
        if (intent != null && intent.extras != null) {
            movieList1 = intent.getSerializableExtra("movies1") as Result

            Glide.with(this).load(BASE_IMAGE_URL + movieList1.poster_path).into(binding.ivImage)
            binding.apply {
                tvTitle.text = movieList1.original_title
                tvStarRating.text = movieList1.vote_average.toString()
                LanguageValue.text = movieList1.original_language
                ReleaseDateValue.text = movieList1.release_date
                starRatingBar.rating = movieList1.vote_average.toString().toFloat() / 2
                valueSynopsis.text = movieList1.overview

            }
        }
    }
    private fun clickListener() {

        val intent = Intent(this@MovieDetailActivity2, CastForTrendingActivity::class.java)
        intent.putExtra("data",movieList1)
        startActivity(intent)

    }
    private fun clickListener2() {

        val intent = Intent(this@MovieDetailActivity2, ReviewForTrending::class.java)
        intent.putExtra("data2",movieList1)
        startActivity(intent)

    }

    /**
     * setting the similar list recyclerview
     */

    private fun setTrendingMoviesRecycler() {
        binding.recyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        similarAdapter = SimilarMovieAdapter(topRated, this)
        binding.recyclerView2.adapter = similarAdapter
    }
    /**
     * calling the api  here.
     */
    private fun callApi(viewModel: MoviesViewModel) {

        viewModel.getTopRatedViewModel(1).observe(this, Observer {
            val res = it.data!!
            topRated.addAll(res)
            Log.d("Nipun", productionList.size.toString())
            similarAdapter.notifyDataSetChanged()
        })
    }

    /**
     * calling the api  here for production house.
     */
    private fun callApiProduction(viewModel: MoviesViewModel) {
        val id = intent.getSerializableExtra("movies1") as Result
        viewModel.getDetail(id.id, 1).observe(this, Observer {

            val res = it.data!!
            productionList.addAll(res)
            Log.d("Nipun", productionList.size.toString())
            productionAdapter.notifyDataSetChanged()

        })
    }


    /**
     * setting the production list recyclerview
     */
    private fun setMoviesListRecycler() {
        binding.recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        productionAdapter = ProductionAdapter(productionList)
        binding.recyclerView1.adapter = productionAdapter

    }

    companion object {
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w300"
    }

    override fun onImageClicked(movieResponse: Movie, mIvImage: ImageView) {

    }

    override fun onImageClickedToRated(movie: Result, mIvImage: ImageView) {
        val intent = Intent(this, MovieDetailActivity2::class.java)
        intent.putExtra("movies1", movie)


        startActivity(intent)
        finish()
    }

}