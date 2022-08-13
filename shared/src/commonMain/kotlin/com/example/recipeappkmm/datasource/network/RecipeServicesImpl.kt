package com.example.recipeappkmm.datasource.network

import com.example.recipeappkmm.datasource.network.models.RecipeDto
import com.example.recipeappkmm.datasource.network.models.RecipeSearshDto
import com.example.recipeappkmm.domain.models.Recipe
import io.ktor.client.*
import io.ktor.client.request.*

class RecipeServicesImpl(
    private val baseUrl:String?=null,
    private val httpClient: HttpClient
):RecipeServices {
    override suspend fun getRecipe(id: Int): Recipe {
        return httpClient.get<RecipeDto> {
            url(BASE_URL+"get?id=${id}")
            header("Authorization", TOKEN)
        }.toRecipe()
    }

    override suspend fun searchRecipes(query: String, page: Int):List<Recipe> {
        return httpClient.get<RecipeSearshDto> {
            url(BASE_URL+"search?page=${page}&query=${query}")
            header("Authorization", TOKEN)
        }.results.toRecipeList()
    }

    companion object{
        const val TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
        const val BASE_URL = "https://food2fork.ca/api/recipe/"
        const val PAGE_SIZE = 15
    }
}