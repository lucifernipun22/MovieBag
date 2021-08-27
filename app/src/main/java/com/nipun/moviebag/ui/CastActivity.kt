package com.nipun.moviebag.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.nipun.moviebag.R
import com.nipun.moviebag.adapter.cast.CastAdapter
import com.nipun.moviebag.databinding.ActivityCastBinding
import com.nipun.moviebag.model.casts.CastX
import com.nipun.moviebag.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CastActivity : AppCompatActivity() {
    val viewModel by viewModels<MoviesViewModel>()
    private lateinit var binding: ActivityCastBinding
    private var moviesList = mutableListOf<CastX>()
    private lateinit var moviesAdapter: CastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cast)
        binding = ActivityCastBinding.inflate(layoutInflater)
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

        val id = intent.getLongExtra("wholeMovie",0)
            viewModel.getCast(id, 1).observe(this, Observer {

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