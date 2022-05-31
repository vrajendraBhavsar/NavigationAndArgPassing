package com.example.navigationandargpassing.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationandargpassing.Screens
import com.example.navigationandargpassing.screens.DetailScreen
import com.example.navigationandargpassing.screens.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        //screen 1
        composable(route = Screens.MainScreen.route) {
            MainScreen(navController = navController)
        }
        //screen 2
        composable(
            route = Screens.DetailScreen.route + "/{$userNameKey}", //passing Route + key in {}
            arguments = listOf(navArgument(name = userNameKey) {
                type = NavType.StringType   //Properties of an Argument
                defaultValue = "default_value"
                nullable = true
            })
        ) { navBackStackEntry ->
            DetailScreen(navBackStackEntry.arguments?.getString(userNameKey))   //Passing value from the Argument
        }
    }
}

const val userNameKey = "USER_NAME_KEY"