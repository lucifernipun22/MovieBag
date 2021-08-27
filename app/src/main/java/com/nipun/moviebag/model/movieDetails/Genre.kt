package com.nipun.moviebag.model.movieDetails

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Genre(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("name")
    val name: String
): Serializable