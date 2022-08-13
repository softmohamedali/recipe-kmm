package com.example.recipeappkmm.domain.models

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDateTime

data class Recipe(
    val description: String="",
    val featured_image: String="",
    val ingredients: List<String> = emptyList(),
    val long_date_added: LocalDateTime?=null,
    val long_date_updated: LocalDateTime?=null,
    val pk: Int=-1,
    val publisher: String="",
    val rating: Int=0,
    val source_url: String="",
    val title: String=""
)