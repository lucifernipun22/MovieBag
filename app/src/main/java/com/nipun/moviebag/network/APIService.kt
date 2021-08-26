package com.nipun.moviebag.network

import com.nipun.moviebag.model.casts.Cast
import com.nipun.moviebag.model.movieDetails.Details
import com.nipun.moviebag.model.movieList.Movie
import com.nipun.moviebag.model.movieList.MovieX
import com.nipun.moviebag.model.reviews.Review
import com.nipun.moviebag.model.topRated.TopRatedMovies
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("movie/popular")
     suspend fun getMoviesList(@Query("api_key") apiKey: String, @Query("page") pageIndex: Int): MovieX

    @GET("movie/{id}")
    suspend fun getMovieDetails(@Query("api_key") apiKey: String, @Query("page") pageIndex: Int): Call<Details>

    @GET("movie/top_rated")
    suspend fun getTopRated(@Query("api_key") apiKey: String, @Query("page") pageIndex: Int): TopRatedMovies

    @GET("movie/{movieId}/casts")
    suspend fun getCast(@Path("movieId") movieId: Long, @Query("api_key") apiKey: String, @Query("page") pageIndex: Int): Call<Cast>

    @GET("movie/{movieId}/reviews")
    suspend fun getReview(@Path("movieId") movieId: Long, @Query("api_key") apiKey: String, @Query("page") pageIndex: Int): Call<Review>


}