package com.nipun.moviebag.model.movieDetails

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Details(
    @field:SerializedName("adult")
    val adult: Boolean,
    @field:SerializedName("backdrop_path")
    val backdrop_path: String,
    @field:SerializedName("belongs_to_collection")
    val belongs_to_collection: Any,
    @field:SerializedName("budget")
    val budget: Int,
    @field:SerializedName("genres")
    val genres: List<Genre>,
    @field:SerializedName("homepage")
    val homepage: String,
    @field:SerializedName("id")
    val id: Long,
    @field:SerializedName("imdb_id")
    val imdb_id: String,
    @field:SerializedName("original_language")
    val original_language: String,
    @field:SerializedName("original_title")
    val original_title: String,
    @field:SerializedName("overview")
    val overview: String,
    @field:SerializedName("popularity")
    val popularity: Double,
    @field:SerializedName("poster_path")
    val poster_path: String,
    @field:SerializedName("production_companies")
    val production_companies: List<ProductionCompany>,
    @field:SerializedName("production_countries")
    val production_countries: List<ProductionCountry>,
    @field:SerializedName("release_date")
    val release_date: String,
    @field:SerializedName("revenue")
    val revenue: Int,
    @field:SerializedName("runtime")
    val runtime: Int,
    @field:SerializedName("spoken_languages")
    val spoken_languages: List<SpokenLanguage>,
    @field:SerializedName("status")
    val status: String,
    @field:SerializedName("tagline")
    val tagline: String,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("video")
    val video: Boolean,
    @field:SerializedName("vote_average")
    val vote_average: Double,
    @field:SerializedName("vote_count")
    val vote_count: Int
): Serializable