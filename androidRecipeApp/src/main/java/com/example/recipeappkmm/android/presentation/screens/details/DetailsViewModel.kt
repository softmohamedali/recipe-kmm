package com.example.recipeappkmm.android.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeappkmm.datasource.network.RecipeServices
import com.example.recipeappkmm.domain.models.Recipe
import com.example.recipeappkmm.domain.utils.ResultState
import com.example.recipeappkmm.interactors.details.RecipeDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val recipeDetailsUseCase: RecipeDetailsUseCase
): ViewModel() {



    private var _recipe: MutableStateFlow<ResultState<Recipe>> = MutableStateFlow(ResultState.Init)
    val recipe: StateFlow<ResultState<Recipe>> = _recipe

    init {
        try {
            savedStateHandle.get<Int>("recipeId")?.let {recipeId->
                viewModelScope.launch (Dispatchers.IO){
                    getRecipe(recipeId)
                }
            }
        }catch (e:Exception){

        }
    }

    suspend fun getRecipe(id:Int){
        recipeDetailsUseCase(id).collect {
            _recipe.value=it
        }
    }
}
