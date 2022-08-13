package com.example.recipeappkmm.domain.utils

import com.example.recipeappkmm.datasource.cache.Recipe_Entity
import com.example.recipeappkmm.domain.models.Recipe

fun Recipe_Entity.toRecipe():Recipe
{
    val datetimeUtil=DatetimeUtil()
    return Recipe(
        pk = id.toInt(),
        description = this.title,
        featured_image = this.featured_image,
        ingredients = ingredients.toListIngredients(),
        title = title,
        publisher = publisher,
        long_date_updated = datetimeUtil.toLocalDate(date_updated),
        long_date_added =datetimeUtil.toLocalDate(date_added),
        rating = rating.toInt(),
        source_url = source_url
    )
}

fun List<Recipe_Entity>.toListRecipe():List<Recipe>{
    val listRecipe=ArrayList<Recipe>()
    for (rec in this){
        listRecipe.add(rec.toRecipe())
    }
    return listRecipe
}

fun List<String>.toStringIngredients():String{
    val stringBuilder=StringBuilder()
    for (item in this){
        stringBuilder.append("$item,")
    }
    return stringBuilder.toString()
}

fun String.toListIngredients():List<String>{
    return this.split(",")
}