package com.nipun.moviebag.model.movieDetails

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCompany(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("logo_path")
    val logo_path: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("origin_country")
    val origin_country: String
): Serializable