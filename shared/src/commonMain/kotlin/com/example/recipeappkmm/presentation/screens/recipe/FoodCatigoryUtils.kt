package com.example.recipeappkmm.presentation.screens.recipe

class FoodCatigoryUtils {

    fun getAllFoodCategories(): List<FoodCatigory> {
        return listOf(
            FoodCatigory.ERROR,
            FoodCatigory.CHICKEN,
            FoodCatigory.BEEF,
            FoodCatigory.SOUP,
            FoodCatigory.DESSERT,
            FoodCatigory.VEGETARIAN,
            FoodCatigory.MILK,
            FoodCatigory.VEGAN,
            FoodCatigory.PIZZA,
            FoodCatigory.DONUT
        )
    }

    fun getFoodCategory(value: String): FoodCatigory? {
        val map = FoodCatigory.values().associateBy(FoodCatigory::value)
        return map[value]
    }
}