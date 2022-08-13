package com.example.recipeappkmm.android.presentation.navigation


sealed class Screens(var route:String){

    object Recipe:Screens("recipe"){

    }
    object Details:Screens("details/{recipeId}"){
        fun toDetails(id:Int):String{
            return "details/$id"
        }
    }


}
