package com.example.recipeappkmm.android.presentation.widget
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun PasswordTextField(
    value: String,
    label: String,
    onValueChange:(String)-> Unit,
    myModifier: Modifier = Modifier.fillMaxWidth(),
    isError:Boolean=false,
    error:String?=null
){
    var passwordVisible by remember{
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            modifier = myModifier
//                .background(MaterialTheme.colors.text_faild_back)
,
            value = value,
            singleLine =true ,
            onValueChange = {
                onValueChange(it)
            },
            label = { Text(text = label) },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
//                val image = if (passwordVisible)
//                    R.drawable.ic_visible
//                else R.drawable.ic_invisible

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
//                    Icon(painter  = painterResource(id = image), description)
                }
            },
            isError = isError
        )
        if (isError){
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = error?:"", color = MaterialTheme.colors.error)
        }
    }
}



