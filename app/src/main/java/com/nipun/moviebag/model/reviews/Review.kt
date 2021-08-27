package com.nipun.moviebag.model.reviews

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Review(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("page")
    val page: Int,
    @field:SerializedName("results")
    val results: List<Results>,
    @field:SerializedName("total_pages")
    val total_pages: Int,
    @field:SerializedName("total_results")
    val total_results: Int
): Serializable