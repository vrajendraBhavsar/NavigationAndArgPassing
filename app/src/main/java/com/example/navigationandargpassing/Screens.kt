package com.example.navigationandargpassing

sealed class Screens(val route: String) {
    object MainScreen: Screens(route = "main_screen")
    object DetailScreen: Screens(route = "detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
