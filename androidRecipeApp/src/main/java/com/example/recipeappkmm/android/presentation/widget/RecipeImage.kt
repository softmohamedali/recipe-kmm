package com.example.recipeappkmm.android.presentation.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState

val RECIPE_IMAGE_HIGHT=400.dp

@Composable
fun RecipeImage(
    url:String,
    description:String=""
){
    val painter= rememberCoilPainter(request = url)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(RECIPE_IMAGE_HIGHT)
    ) {
        Image(
            painter = painter,
            contentDescription =description,
            modifier =Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        when(painter.loadState){
            is ImageLoadState.Success->{

            }
            is ImageLoadState.Error->{
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {

                }
            }
            is ImageLoadState.Loading->{
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {

                }
            }
        }
    }
}