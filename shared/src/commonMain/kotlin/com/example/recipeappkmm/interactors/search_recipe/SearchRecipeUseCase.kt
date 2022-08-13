package com.example.recipeappkmm.interactors.search_recipe

import com.example.recipeappkmm.datasource.cache.RecipeCacheServices
import com.example.recipeappkmm.datasource.cache.RecipeCacheServicesImp
import com.example.recipeappkmm.datasource.network.RecipeServices
import com.example.recipeappkmm.domain.models.Recipe
import com.example.recipeappkmm.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipeUseCase(
    private val recipeServices: RecipeServices,
    private val recipeCacheServices:RecipeCacheServices
) {
    operator fun invoke(query:String,page:Int):Flow<ResultState<List<Recipe>>> = flow {
        emit(ResultState.IsLoading)
        try {
            val response=recipeServices.searchRecipes(query = query,page=page)

            recipeCacheServices.insert(response)
            val cachReesult=if (query.isBlank()){
                recipeCacheServices.getAll(page)
            }else{
                recipeCacheServices.search(query, page)
            }
            emit(ResultState.IsSucsses(cachReesult))
        }catch (e:Exception){
            emit(ResultState.IsError(e.message?:"UNKOWN ERROE"))
        }
    }
}