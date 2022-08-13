package com.example.recipeappkmm.domain.utils

sealed class ResultState <out T>(
    val data: T? = null, var message: String? = null
){

    object Init:ResultState<Nothing>()
    object IsLoading:ResultState<Nothing>()
    class IsSucsses<T>(data: T?=null):ResultState<T>(data)
    class IsError( msg: String):ResultState<Nothing>(null,msg)
}
