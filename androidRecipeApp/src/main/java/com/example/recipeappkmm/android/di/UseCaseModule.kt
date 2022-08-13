package com.example.recipeappkmm.android.di

import com.example.recipeappkmm.datasource.cache.RecipeCacheServices
import com.example.recipeappkmm.datasource.network.RecipeServices
import com.example.recipeappkmm.interactors.details.RecipeDetailsUseCase
import com.example.recipeappkmm.interactors.search_recipe.SearchRecipeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideSearchRecipeUseCase(
        recipeServices: RecipeServices,
        recipeCacheServices: RecipeCacheServices,
    ):SearchRecipeUseCase= SearchRecipeUseCase(recipeServices,recipeCacheServices)

    @Provides
    @Singleton
    fun provideGetRecipeUseCase(
        recipeCacheServices: RecipeCacheServices,
    ):RecipeDetailsUseCase= RecipeDetailsUseCase(recipeCacheServices)
}