package com.example.recipeappkmm.interactors.details

import com.example.recipeappkmm.datasource.cache.RecipeCacheServices
import com.example.recipeappkmm.datasource.network.RecipeServices
import com.example.recipeappkmm.domain.models.Recipe
import com.example.recipeappkmm.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeDetailsUseCase(
    private val recipeCacheServices: RecipeCacheServices
) {

    operator fun invoke(id:Int): Flow<ResultState<Recipe>> = flow {
        emit(ResultState.IsLoading)
        try {
            val response=recipeCacheServices.get(id = id)
            emit(ResultState.IsSucsses(response))
        }catch (e:Exception){
            emit(ResultState.IsError(e.message?:"UNKOWN ERROE"))
        }
    }
}