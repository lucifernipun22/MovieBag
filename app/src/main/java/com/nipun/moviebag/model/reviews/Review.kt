package com.nipun.moviebag.model.reviews

data class Review(
    val id: Int,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)