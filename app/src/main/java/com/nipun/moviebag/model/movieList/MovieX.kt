package com.nipun.moviebag.model.movieList

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieX(
    @field:SerializedName("page")
    val page: Int,
    @field:SerializedName("results")
    val results: List<Movie>,
    @field:SerializedName("total_pages")
    val total_pages: Int,
    @field:SerializedName("total_results")
    val total_results: Int
): Serializable