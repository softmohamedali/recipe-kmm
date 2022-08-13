package com.example.recipeappkmm.android

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.lifecycleScope
import com.example.recipeappkmm.android.presentation.navigation.SetupNavigation
import com.example.recipeappkmm.datasource.cache.DriverFactory
import com.example.recipeappkmm.datasource.cache.RecipeCacheServicesImp
import com.example.recipeappkmm.datasource.cache.RecipeDataBaseFactory
import com.example.recipeappkmm.datasource.network.KtorClientFactory
import com.example.recipeappkmm.datasource.network.RecipeServicesImpl
import com.example.recipeappkmm.datasource.network.RecipeServicesImpl.Companion.BASE_URL
import com.example.recipeappkmm.domain.models.Recipe
import com.example.recipeappkmm.domain.utils.DatetimeUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetupNavigation()
        }



    }
}
