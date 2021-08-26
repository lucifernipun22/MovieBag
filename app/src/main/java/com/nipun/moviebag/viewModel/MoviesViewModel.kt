package com.nipun.moviebag.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nipun.moviebag.model.movieList.Movie
import com.nipun.moviebag.model.topRated.Result
import com.nipun.moviebag.network.Resource

import com.nipun.moviebag.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository : MoviesRepository) : ViewModel() {

    /**
     * calling the get getMoviesList from repository and returning the livedata, the resource class
     * is wrapping the data and returning livedata.
     */
    fun getMoviesViewModel(page : Int): LiveData<Resource<List<Movie>>> {
        return liveData(Dispatchers.IO) {
            val result = repository.getMoviesList(page)
            emit(result)
        }
    }
    /**
     * calling the get getTopRated from repository and returning the livedata, the resource class
     * is wrapping the data and returning livedata.
     */
    fun getTopRatedViewModel(page : Int): LiveData<Resource<List<Result>>> {
        return liveData(Dispatchers.IO) {
            val result = repository.getTopRated(page)
            emit(result)
        }
    }
}