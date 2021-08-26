package com.nipun.moviebag.model.topRated

data class TopRatedMovies(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)