package com.example.recipeappkmm.android.di

import android.app.Application
import com.example.recipeappkmm.datasource.cache.*
import com.example.recipeappkmm.domain.utils.DatetimeUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CacheModule {
    @Singleton
    @Provides
    fun provideRecipeDataBase(context: Application): RecipeDatabase {
        return RecipeDataBaseFactory(driverFactory = DriverFactory(context)).createDataBase()
    }

    @Singleton
    @Provides
    fun provideRecipeCacheServices(recipeDb: RecipeDatabase): RecipeCacheServices {
        return RecipeCacheServicesImp(recipeDb, DatetimeUtil())
    }
}
