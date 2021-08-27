package com.nipun.moviebag.model.reviews

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Results(
    @field:SerializedName("author")
    val author: String,
    @field:SerializedName("author_details")
    val author_details: AuthorDetails,
    @field:SerializedName("content")
    val content: String,
    @field:SerializedName("created_at")
    val created_at: String,
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("updated_at")
    val updated_at: String,
    @field:SerializedName("url")
    val url: String
): Serializable