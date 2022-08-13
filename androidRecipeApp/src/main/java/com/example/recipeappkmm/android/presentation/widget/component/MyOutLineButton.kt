package com.example.recipeappkmm.android.presentation.widget
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyOutLineButton(
    text:String="",
    width:Float=150f,
    onclick:()->Unit,
){
    OutlinedButton(
        modifier = Modifier.width(width.dp),
        onClick = onclick,
        border = BorderStroke(width = 1.dp,color = MaterialTheme.colors.primary)
    ) {
        Text(text = text)
    }
}













