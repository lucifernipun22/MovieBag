package com.nipun.moviebag.repository


import androidx.lifecycle.LiveData
import com.nipun.moviebag.model.movieList.Movie
import com.nipun.moviebag.model.topRated.Result
import com.nipun.moviebag.network.APIService
import com.nipun.moviebag.network.Resource
import com.nipun.moviebag.network.ResponseHandler
import retrofit2.Call
import java.lang.Exception
import javax.inject.Inject


class MoviesRepository  @Inject constructor(val aPiService: APIService){

    private val responseHandler = ResponseHandler()

    /**
     * calling the function from ApiService and returning the resource list handling the
     * success and exception if there are any.
     */
    suspend fun getMoviesList(page : Int): Resource<List<Movie>> {
        val result = aPiService.getMoviesList("15291200108ef5862d8d3ee59d0a2577",page)
        try {
            return responseHandler.handleSuccess(result.results)
        } catch (e: Exception) {
            return responseHandler.handleException(e)
        }
    }
    suspend fun getTopRated(page : Int): Resource<List<Result>> {
        val result = aPiService.getTopRated("15291200108ef5862d8d3ee59d0a2577",page)
        try {
            return responseHandler.handleSuccess(result.results)
        } catch (e: Exception) {
            return responseHandler.handleException(e)
        }
    }
}