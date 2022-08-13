package com.example.recipeappkmm.presentation.screens.recipe

sealed class ReciepsListEvent{

    object LoadRecipes:ReciepsListEvent()
    object NextRecipes:ReciepsListEvent()
    object DoSearchRecipe:ReciepsListEvent()
    data class OnUpdateQuery(val query:String):ReciepsListEvent()
    data class OnSelectFoodCatigory(val foodCatigory: FoodCatigory):ReciepsListEvent()

}
