package com.nipun.moviebag.model.casts

data class Cast(
    val cast: List<CastX>,
    val crew: List<Crew>,
    val id: Int
)