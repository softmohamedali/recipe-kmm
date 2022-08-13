package com.example.recipeappkmm.datasource.network

import com.example.recipeappkmm.datasource.network.models.RecipeDto
import com.example.recipeappkmm.domain.models.Recipe
import io.ktor.client.*
import kotlinx.datetime.LocalDateTime

expect class KtorClientFactory() {
    fun build():HttpClient
}


fun RecipeDto.toRecipe():Recipe{
    return Recipe(
        description = description,
        featured_image=featured_image,
        ingredients=ingredients,
        pk=pk,
        publisher=publisher,
        rating=rating,
        source_url=source_url,
        title=title
    )
}

fun List<RecipeDto>.toRecipeList():List<Recipe>{
    return this.map { it.toRecipe() }
}