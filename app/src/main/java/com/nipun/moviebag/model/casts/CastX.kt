package com.nipun.moviebag.model.casts

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CastX(
    @field:SerializedName("adult")
    val adult: Boolean,
    @field:SerializedName("cast_id")
    val cast_id: Int,
    @field:SerializedName("character")
    val character: String,
    @field:SerializedName("credit_id")
    val credit_id: String,
    @field:SerializedName("gender")
    val gender: Int,
    @field:SerializedName("id")
    val id: Long,
    @field:SerializedName("known_for_department")
    val known_for_department: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("order")
    val order: Int,
    @field:SerializedName("original_name")
    val original_name: String,
    @field:SerializedName("popularity")
    val popularity: Double,
    @field:SerializedName("profile_path")
    val profile_path: String
): Serializable