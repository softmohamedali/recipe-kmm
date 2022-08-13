package com.example.recipeappkmm.android.presentation.widget
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun PickImageButton(
    onClik: () -> Unit,
    imgUri: Uri?,
    bitmap: Bitmap?
) {
    var myBitmap = bitmap
    val context = LocalContext.current
    Surface(
        modifier = Modifier.size(100.dp),
        color = MaterialTheme.colors.primary,
        shape = CircleShape,
        onClick = {
            onClik()
        }
    ) {
        imgUri?.let {
            if (Build.VERSION.SDK_INT < 28) {
                myBitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, it)
                myBitmap = ImageDecoder.decodeBitmap(source)
            }
        }
        if (myBitmap == null) {
            Image(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        } else {
            Image(
                bitmap = myBitmap!!.asImageBitmap(),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}