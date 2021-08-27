package com.nipun.moviebag.model.movieDetails

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCountry(
    @field:SerializedName("iso_3166_1")
    val iso_3166_1: String,
    @field:SerializedName("name")
    val name: String
): Serializable