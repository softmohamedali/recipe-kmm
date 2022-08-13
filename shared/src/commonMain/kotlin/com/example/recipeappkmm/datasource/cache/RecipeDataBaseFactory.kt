package com.example.recipeappkmm.datasource.cache


import com.squareup.sqldelight.db.SqlDriver

class RecipeDataBaseFactory(
    private  val driverFactory:DriverFactory
) {

    fun createDataBase():RecipeDatabase{
        return RecipeDatabase(driverFactory.createDriver())
    }
}


expect class DriverFactory{
    fun createDriver():SqlDriver
}