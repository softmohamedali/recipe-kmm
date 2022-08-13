package com.example.recipeappkmm.android.presentation.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.recipeappkmm.presentation.screens.recipe.FoodCatigory
import com.example.recipeappkmm.presentation.screens.recipe.FoodCatigoryUtils
import com.example.recipeappkmm.presentation.screens.recipe.ReciepsListEvent

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RecipeSearchAppBar(
    query:String,
    catigories:List<FoodCatigory>,
    onQueryChange:(String)->Unit,
    onSearchClick:()->Unit,
    selectedCatigory: FoodCatigory?=null,
    onSelectFoodCatigory:(FoodCatigory)->Unit
){
    val keybordController=LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
    ) {
        Column{
            Row (
                modifier = Modifier.fillMaxWidth()
            ){

                TextField(
                    value = query,
                    onValueChange =onQueryChange,
                    label = { Text(text = "Search..")},
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            onSearchClick()
                            keybordController?.hide()
                        }
                    ),
                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface
                    ),
                    leadingIcon = { Icon(Icons.Default.Search,"search") }
                )
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ){
                items(catigories){
                    FoodCategoryChip(
                        category =it.value,
                        onSelectedCategoryChanged ={cat->
                            FoodCatigoryUtils().getFoodCategory(cat)?.let {food->
                                onSelectFoodCatigory(food)
                            }
                        },
                        isSelected = selectedCatigory==it
                    )
                }
            }
        }
    }
}