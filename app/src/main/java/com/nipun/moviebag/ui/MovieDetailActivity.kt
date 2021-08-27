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
import com.nipun.moviebag.databinding.ActivityMovieDetailBinding
import com.nipun.moviebag.model.movieDetails.Details
import com.nipun.moviebag.model.movieDetails.ProductionCompany
import com.nipun.moviebag.model.movieList.Movie
import com.nipun.moviebag.model.topRated.Result
import com.nipun.moviebag.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() , ImageClickListener{

    val viewModel by viewModels<MoviesViewModel>()
    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var movieList: Movie
    private var productionList = mutableListOf<ProductionCompany>()
    private lateinit var productionAdapter: ProductionAdapter
    private var topRated = mutableListOf<Result>()
    private var details: Details? = null
    private lateinit var similarAdapter: SimilarMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        getData()

        binding.castButton.setOnClickListener {
            clickListener()
        }
        binding.reviewButton.setOnClickListener {
            clickListener2()
        }
        setSimilarMovieRecyclerView()
        setMoviesListRecycler()
        callApiProduction(viewModel)
        callApi(viewModel)


    }

    private fun clickListener() {

        val intent = Intent(this@MovieDetailActivity, CastActivity::class.java)
       intent.putExtra("wholeMovie",movieList.id)
        startActivity(intent)

    }
    private fun clickListener2() {

        val intent = Intent(this@MovieDetailActivity, ReviewActivity::class.java)
        intent.putExtra("wholeMovie2",movieList.id)
        startActivity(intent)

    }
    /**
     * getting all the data through intent from previous activity and setting the data to respective views
     */
    private fun getData() {
        if (intent != null && intent.extras != null) {
            movieList = intent.getSerializableExtra("movies") as Movie

            Glide.with(this).load(BASE_IMAGE_URL + movieList.poster_path).into(binding.ivImage)

            /**
             * setting all the data coming from the api to its respective views
             */
            binding.apply {
                tvTitle.text = movieList.original_title
                tvStarRating.text = movieList.vote_average.toString()
                LanguageValue.text = movieList.original_language
                ReleaseDateValue.text = movieList.release_date
                starRatingBar.rating = movieList.vote_average.toString().toFloat() / 2
                valueSynopsis.text = movieList.overview

            }

        }
    }
    /**
     * calling the api  here for production house.
     */
    private fun callApiProduction(viewModel: MoviesViewModel) {
        val id = intent.getSerializableExtra("movies") as Movie
            viewModel.getDetail(id.id, 1).observe(this, Observer {
                binding.apply {
                    ReleaseStatus.text = details?.status
                }
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

    /**
     * setting the similar movies list recyclerview
     */

    private fun setSimilarMovieRecyclerView() {
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
           topRated.clear()
            val res = it.data!!
            topRated.addAll(res)
            Log.d("Nipun", productionList.size.toString())
            similarAdapter.notifyDataSetChanged()
        })
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