package com.example.recipeappkmm.presentation.screens.recipe

import com.example.recipeappkmm.domain.models.Recipe


data class RecipeState(
    val isLoading:Boolean=false,
    val query:String="",
    val page:Int=1,
    val recipeSelected:FoodCatigory?=null,
    val recipeList: List<Recipe> = listOf()
)
