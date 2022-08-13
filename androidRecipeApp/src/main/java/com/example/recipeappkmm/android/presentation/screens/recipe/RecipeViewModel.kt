package com.example.recipeappkmm.android.presentation.screens.recipe

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeappkmm.datasource.network.RecipeServices
import com.example.recipeappkmm.domain.models.Recipe
import com.example.recipeappkmm.domain.utils.ResultState
import com.example.recipeappkmm.interactors.search_recipe.SearchRecipeUseCase
import com.example.recipeappkmm.presentation.screens.recipe.ReciepsListEvent
import com.example.recipeappkmm.presentation.screens.recipe.RecipeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel@Inject constructor(
     private val savedStateHandle: SavedStateHandle,
     private val searchRecipeUseCase:SearchRecipeUseCase
):ViewModel() {

     val state:MutableState<RecipeState> = mutableStateOf(RecipeState())


     init {
         loadSearchRecipe()
     }

     fun onEvent(recpiesEvent:ReciepsListEvent){
          when{
               recpiesEvent is ReciepsListEvent.LoadRecipes ->{
                    loadSearchRecipe()
               }
               recpiesEvent is ReciepsListEvent.NextRecipes ->{
                    nextRecipeList()
               }
               recpiesEvent is ReciepsListEvent.DoSearchRecipe ->{
                    state.value=state.value.copy(page = 1, recipeList = listOf())
                    loadSearchRecipe()
               }
               recpiesEvent is ReciepsListEvent.OnUpdateQuery ->{
                    state.value=state.value.copy(query = recpiesEvent.query, recipeSelected = null)
               }
               recpiesEvent is ReciepsListEvent.OnSelectFoodCatigory ->{
                    state.value=state.value.copy(
                         page = 1,
                         recipeList = listOf(),
                         query = recpiesEvent.foodCatigory.value,
                         recipeSelected = recpiesEvent.foodCatigory,
                    )
                    loadSearchRecipe()
               }
               else ->{
                    handleErrors("invalid Event")
               }
          }
     }

     private fun handleErrors(s: String) {

     }

     private fun nextRecipeList() {
          state.value=state.value.copy(page = state.value.page+1)
          loadSearchRecipe()
     }



     private fun loadSearchRecipe(){
          viewModelScope.launch{
               searchRecipeUseCase(state.value.query,state.value.page).collect {
                    Log.d("moali",it.toString())
                    when(it){
                         is ResultState.IsLoading->{
                              state.value=state.value.copy(isLoading = true)
                         }
                         is ResultState.IsSucsses->{
                              appendRecipe(it.data!!)
                         }
                         is ResultState.IsError->{
                              state.value=state.value.copy(
                                   isLoading = false,

                              )
                         }
                    }
               }
          }
     }



     fun appendRecipe(recipes:List<Recipe>)
     {
          val current=ArrayList(state.value.recipeList)
          current.addAll(recipes)
          state.value=state.value.copy(
               isLoading = false,
               recipeList = current
          )
     }


}