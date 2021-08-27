package com.nipun.moviebag.model.topRated

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TopRatedMovies(
    @field:SerializedName("page")
    val page: Int,
    @field:SerializedName("results")
    val results: List<Result>,
    @field:SerializedName("total_pages")
    val total_pages: Int,
    @field:SerializedName("total_results")
    val total_results: Int
): Serializable