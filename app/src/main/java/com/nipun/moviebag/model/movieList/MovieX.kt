package com.nipun.moviebag.model.movieList

data class MovieX(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)