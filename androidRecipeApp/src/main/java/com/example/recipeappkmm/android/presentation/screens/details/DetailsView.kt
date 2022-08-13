package com.example.recipeappkmm.android.presentation.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeappkmm.android.presentation.widget.RecipeCard
import com.example.recipeappkmm.android.presentation.widget.RecipeImage
import com.example.recipeappkmm.android.presentation.widget.component.Center
import com.example.recipeappkmm.domain.models.Recipe
import com.example.recipeappkmm.domain.utils.DatetimeUtil

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun DetailsView(
    recipe:Recipe?
) {
    if(recipe==null){
        Center {
            Text(
                text = "No Recipe Found == null",
                modifier = Modifier
                    .fillMaxWidth(0.90f)
                    .wrapContentWidth(align = Alignment.Start),
                style = MaterialTheme.typography.h4
            )
        }
    }else{
        LazyColumn{
            item {
                RecipeImage(url = "${ recipe?.featured_image }")
                Spacer(modifier = Modifier.height(10.dp))
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ){
                    Text(
                        text = recipe.description,
                        modifier = Modifier
                            .fillMaxWidth(0.90f)
                            .wrapContentWidth(align = Alignment.Start),
                        style = MaterialTheme.typography.h4
                    )
                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(align = Alignment.Start)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h3
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    text ="Update at ${DatetimeUtil().humanizeDatetime(recipe.long_date_updated)} " +
                            "by ${recipe.publisher}",
                    style = MaterialTheme.typography.caption
                )
                for (ingre in (0..recipe.ingredients.size-1)){
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        text ="${ingre} ${recipe.ingredients[ingre]}",
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }

}