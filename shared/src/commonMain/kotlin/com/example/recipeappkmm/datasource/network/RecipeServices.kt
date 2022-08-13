package com.example.recipeappkmm.datasource.network

import com.example.recipeappkmm.domain.models.Recipe

interface RecipeServices {
    suspend fun getRecipe(id:Int):Recipe
    suspend fun searchRecipes(query:String,page:Int):List<Recipe>
}