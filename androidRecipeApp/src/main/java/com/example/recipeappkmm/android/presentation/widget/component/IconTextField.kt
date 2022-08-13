package com.example.recipeappkmm.android.presentation.widget
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun IconTextField(
    value: String = "",
    label: String,
    onValueChange: (String) -> Unit,
    myModifier: Modifier = Modifier.fillMaxWidth(),
    icon: Int,
    onClick:()->Unit={},
    onIconClick:()->Unit={},
    readOnly:Boolean=false,
    isError:Boolean=false,
    error:String?=null,
) {
    Column(
        modifier = myModifier.clickable { onClick() }
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            readOnly = readOnly,
            modifier = Modifier.fillMaxWidth()
//                .background(MaterialTheme.colors.text_faild_back)
            ,
            singleLine = true,
            label = { Text(text = label) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                IconButton(
                    onClick = {onIconClick() },
                    content = {Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "Search"
                    )}
                )
            },
            isError = isError
        )
        if (isError){
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = error?:"", color = MaterialTheme.colors.error)
        }
    }
}



