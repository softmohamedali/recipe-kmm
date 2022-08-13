package com.example.recipeappkmm.datasource.cache


import com.example.recipeappkmm.datasource.network.RecipeServicesImpl.Companion.PAGE_SIZE
import com.example.recipeappkmm.domain.models.Recipe
import com.example.recipeappkmm.domain.utils.DatetimeUtil
import com.example.recipeappkmm.domain.utils.toListRecipe
import com.example.recipeappkmm.domain.utils.toRecipe
import com.example.recipeappkmm.domain.utils.toStringIngredients
import kotlinx.datetime.LocalDateTime

class RecipeCacheServicesImp(
    private val recipeDb:RecipeDatabase,
    private val dataUtil: DatetimeUtil
):RecipeCacheServices {

    private val recipeDBQuery=recipeDb.recipeDBQueries

    override fun insert(recipe: Recipe) {
        recipeDBQuery.insertRecipe(
            id = recipe.pk.toLong(),
            title = recipe.title,
            rating = recipe.rating.toLong(),
            date_added = dataUtil.toEpochMilliseconds(recipe.long_date_added?: LocalDateTime(1,1,1,1,1)),
            date_updated = dataUtil.toEpochMilliseconds(recipe.long_date_updated?:LocalDateTime(1,1,1,1,1)),
            featured_image = recipe.featured_image,
            publisher = recipe.publisher,
            source_url = recipe.source_url,
            ingredients = recipe.ingredients.toStringIngredients()
        )
    }

    override fun insert(recipes: List<Recipe>) {
        for (recipe in recipes){
            insert(recipe)
        }
    }

    override fun search(query: String, page: Int): List<Recipe> {
        return recipeDBQuery.searchRecipes(
            query = query,
            pageSize=PAGE_SIZE.toLong(),
            offset = ((page-1)*PAGE_SIZE).toLong()
        ).executeAsList().toListRecipe()
    }

    override fun getAll(page: Int): List<Recipe> {
        return recipeDBQuery.getAllRecipes(
            pageSize=PAGE_SIZE.toLong(),
            offset = ((page-1)*PAGE_SIZE).toLong()
        ).executeAsList().toListRecipe()
    }

    override fun get(id: Int): Recipe? {
        return try{
            recipeDBQuery.getRecipeById(
                id = id.toLong()
            ).executeAsOne().toRecipe()
        }catch (e:NullPointerException){
            null
        }

    }

}















