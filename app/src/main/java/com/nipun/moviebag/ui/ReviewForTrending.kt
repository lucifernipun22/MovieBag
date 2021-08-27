package com.nipun.moviebag.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nipun.moviebag.R
import com.nipun.moviebag.adapter.review.ReviewAdapter
import com.nipun.moviebag.databinding.ActivityReviewForTrendingBinding
import com.nipun.moviebag.model.reviews.Results
import com.nipun.moviebag.model.topRated.Result
import com.nipun.moviebag.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewForTrending : AppCompatActivity() {

    val viewModel by viewModels<MoviesViewModel>()
    private lateinit var binding: ActivityReviewForTrendingBinding
    private var review = mutableListOf<Results>()
    private lateinit var reviewAdapter: ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_for_trending)
        binding = ActivityReviewForTrendingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        setMoviesListRecycler(layoutManager)
        callApi(viewModel)
    }
    /**
     * calling the api  here.
     */
    private fun callApi(viewModel: MoviesViewModel) {
        val id2 = intent.getSerializableExtra("data2") as Result
        viewModel.getReview(id2.id, 1).observe(this, Observer {

            val res = it.data!!
            review.addAll(res)
            Log.d("Nipun", review.size.toString())
            reviewAdapter.notifyDataSetChanged()

        })

    }
    /**
     * setting the list recyclerview
     */
    private fun setMoviesListRecycler(layoutManager: LinearLayoutManager) {
        binding.recyclerViewReview.layoutManager = layoutManager
        reviewAdapter = ReviewAdapter(review)
        binding.recyclerViewReview.adapter = reviewAdapter

    }
}