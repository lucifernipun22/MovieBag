package com.nipun.moviebag.model.movieDetails

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpokenLanguage(
    @field:SerializedName("english_name")
    val english_name: String,
    @field:SerializedName("iso_639_1")
    val iso_639_1: String,
    @field:SerializedName("name")
    val name: String
): Serializable