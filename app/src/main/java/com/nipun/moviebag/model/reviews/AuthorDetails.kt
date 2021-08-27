package com.nipun.moviebag.model.reviews

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AuthorDetails(
    @field:SerializedName("avatar_path")
    val avatar_path: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("rating")
    val rating: Long,
    @field:SerializedName("username")
    val username: String
): Serializable