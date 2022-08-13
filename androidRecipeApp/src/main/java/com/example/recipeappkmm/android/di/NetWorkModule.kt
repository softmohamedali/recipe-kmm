package com.example.recipeappkmm.android.di

import com.example.recipeappkmm.datasource.network.KtorClientFactory
import com.example.recipeappkmm.datasource.network.RecipeServices
import com.example.recipeappkmm.datasource.network.RecipeServicesImpl
import com.example.recipeappkmm.datasource.network.RecipeServicesImpl.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {
    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient{
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideRecipeServices(httpClient: HttpClient):RecipeServices{
        return RecipeServicesImpl(BASE_URL,httpClient)
    }
}

















