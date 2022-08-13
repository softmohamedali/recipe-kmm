package com.example.recipeappkmm.datasource.cache

import com.example.recipeappkmm.domain.models.Recipe
import com.squareup.sqldelight.Query

interface RecipeCacheServices {

    fun insert(recipe:Recipe)

    fun insert(recipes:List<Recipe>)

    fun search(query:String,page:Int):List<Recipe>

    fun getAll(page:Int):List<Recipe>

    fun get(id:Int):Recipe?

}