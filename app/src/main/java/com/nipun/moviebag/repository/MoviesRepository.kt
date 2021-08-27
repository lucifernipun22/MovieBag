package com.nipun.moviebag.repository


import com.nipun.moviebag.model.casts.CastX
import com.nipun.moviebag.model.movieDetails.ProductionCompany
import com.nipun.moviebag.model.movieList.Movie
import com.nipun.moviebag.model.reviews.Results
import com.nipun.moviebag.model.topRated.Result
import com.nipun.moviebag.network.APIService
import com.nipun.moviebag.network.Resource
import com.nipun.moviebag.network.ResponseHandler
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

    /**
     * calling the function from ApiService and returning the resource topRated handling the
     * success and exception if there are any.
     */
    suspend fun getTopRated(page : Int): Resource<List<Result>> {
        val result = aPiService.getTopRated("15291200108ef5862d8d3ee59d0a2577",page)
        try {
            return responseHandler.handleSuccess(result.results)
        } catch (e: Exception) {
            return responseHandler.handleException(e)
        }
    }
    /**
     * calling the function from ApiService and returning the resource cast handling the
     * success and exception if there are any.
     */
    suspend fun getCast(id: Long,page : Int): Resource<List<CastX>> {
        val result = aPiService.getCast(id,"15291200108ef5862d8d3ee59d0a2577",page)
        try {
            return responseHandler.handleSuccess(result.cast)
        } catch (e: Exception) {
            return responseHandler.handleException(e)
        }
    }
    /**
     * calling the function from ApiService and returning the resource cast handling the
     * success and exception if there are any.
     */
    suspend fun getProduction(id: Long,page : Int): Resource<List<ProductionCompany>> {
        val result = aPiService.getMovieDetails(id,"15291200108ef5862d8d3ee59d0a2577",page)
        try {
            return responseHandler.handleSuccess(result.production_companies)
        } catch (e: Exception) {
            return responseHandler.handleException(e)
        }
    }
    /**
     * calling the function from ApiService and returning the resource cast handling the
     * success and exception if there are any.
     */
    suspend fun getReview(id: Long,page : Int): Resource<List<Results>> {
        val result = aPiService.getReview(id,"15291200108ef5862d8d3ee59d0a2577",page)
        try {
            return responseHandler.handleSuccess(result.results)
        } catch (e: Exception) {
            return responseHandler.handleException(e)
        }
    }
}