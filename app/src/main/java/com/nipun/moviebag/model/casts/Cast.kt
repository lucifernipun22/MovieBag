package com.nipun.moviebag.model.casts

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cast(
    @field:SerializedName("cast")
    val cast: List<CastX>,
    @field:SerializedName("crew")
    val crew: List<Crew>,
    @field:SerializedName("id")
    val id: Int
): Serializable