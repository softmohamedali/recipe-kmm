package com.example.recipeappkmm.datasource.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    @SerialName("description")
    val description: String,

    @SerialName("featured_image")
    val featured_image: String,

    @SerialName("ingredients")
    val ingredients: List<String>,

    @SerialName("long_date_added")
    val long_date_added: Long,

    @SerialName("long_date_updated")
    val long_date_updated: Long,

    @SerialName("pk")
    val pk: Int,

    @SerialName("publisher")
    val publisher: String,

    @SerialName("rating")
    val rating: Int,

    @SerialName("source_url")
    val source_url: String,

    @SerialName("title")
    val title: String
)