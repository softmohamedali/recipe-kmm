package com.example.recipeappkmm.android.presentation.widget
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField(
    value: String,
    label: String,
    onValueChange:(String)-> Unit,
    myModifier: Modifier=Modifier.fillMaxWidth(),
    isError:Boolean=false,
    error:String?=null,
    keybordoption:KeyboardOptions= KeyboardOptions.Default
){
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            modifier = myModifier
//                .background(MaterialTheme.colors.text_faild_back)
            ,
            value = value,
            singleLine = true,
            onValueChange = {
                onValueChange(it)
            },
            label = { Text(text = label)},
            isError =isError,
            keyboardOptions = keybordoption
        )
        if (isError){
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = error?:"", color = MaterialTheme.colors.error)
        }
    }
}