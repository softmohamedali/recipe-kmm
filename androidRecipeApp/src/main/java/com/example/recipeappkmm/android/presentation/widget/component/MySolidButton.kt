package com.example.recipeappkmm.android.presentation.widget
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun MySolidButton(
    text:String="",
    modifier: Modifier= Modifier.alpha(1f),
    corner:Int=15,
    onclick:()->Unit,
){
    Button(
        modifier = modifier
            .clip(RoundedCornerShape(size = corner.dp))
//            .background(MaterialTheme.colors.main_color)
        ,
        onClick = onclick,

    ) {
        Text(text = text)
    }
}
