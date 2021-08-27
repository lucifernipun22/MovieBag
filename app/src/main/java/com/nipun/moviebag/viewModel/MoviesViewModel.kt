package com.nipun.moviebag.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nipun.moviebag.model.casts.CastX
import com.nipun.moviebag.model.movieDetails.ProductionCompany
import com.nipun.moviebag.model.movieList.Movie
import com.nipun.moviebag.model.reviews.Results
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
    /**
     * calling the get getCast from repository and returning the livedata, the resource class
     * is wrapping the data and returning livedata.
     */
    fun getCast(id: Long,page : Int): LiveData<Resource<List<CastX>>> {
        return liveData(Dispatchers.IO) {
            val result = repository.getCast(id,page)
            emit(result)
        }
    }
    /**
     * calling the get getDetail from repository and returning the livedata, the resource class
     * is wrapping the data and returning livedata.
     */
    fun getDetail(id: Long,page : Int): LiveData<Resource<List<ProductionCompany>>> {
        return liveData(Dispatchers.IO) {
            val result = repository.getProduction(id,page)
            emit(result)
        }
    }
    /**
     * calling the get getReview from repository and returning the livedata, the resource class
     * is wrapping the data and returning livedata.
     */
    fun getReview(id: Long,page : Int): LiveData<Resource<List<Results>>> {
        return liveData(Dispatchers.IO) {
            val result = repository.getReview(id,page)
            emit(result)
        }
    }
}