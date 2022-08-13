package com.example.recipeappkmm.datasource.cache

import com.example.recipeAppKmm.datasource.cache.RecipeDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(RecipeDatabase.Schema,"recipes.db")
    }
}