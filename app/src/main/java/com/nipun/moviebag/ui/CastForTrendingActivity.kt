package com.nipun.moviebag.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.nipun.moviebag.R
import com.nipun.moviebag.adapter.cast.CastAdapter
import com.nipun.moviebag.databinding.ActivityCastForTrendingBinding
import com.nipun.moviebag.model.casts.CastX
import com.nipun.moviebag.model.topRated.Result
import com.nipun.moviebag.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CastForTrendingActivity : AppCompatActivity() {
    val viewModel by viewModels<MoviesViewModel>()
    private lateinit var binding: ActivityCastForTrendingBinding
    private var moviesList = mutableListOf<CastX>()

    private lateinit var moviesAdapter: CastAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cast_for_trending)
        binding = ActivityCastForTrendingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val layoutManager = GridLayoutManager(this, 2)
        setMoviesListRecycler(layoutManager)
        callApi(viewModel)
    }
    /**
     * calling the api  here.
     */
        private fun callApi(viewModel: MoviesViewModel) {

            val id = intent.getSerializableExtra("data") as Result

            viewModel.getCast(id.id, 1).observe(this, Observer {

                val res = it.data!!
                moviesList.addAll(res)
                Log.d("Nipun", moviesList.size.toString())
                moviesAdapter.notifyDataSetChanged()

            })


        }
    /**
     * setting the list recyclerview
     */
        private fun setMoviesListRecycler(layoutManager: GridLayoutManager) {
            binding.recyclerViewCast.layoutManager = layoutManager
            moviesAdapter = CastAdapter(moviesList)
            binding.recyclerViewCast.adapter = moviesAdapter

        }
    }
