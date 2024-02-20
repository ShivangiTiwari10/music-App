package com.example.musicapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){

    val navController = rememberNavController()
    NavHost(navController, startDestination = "greeting") {
        composable("greeting") { Greeting(navController) }
        composable("ScreenA") { ScreenA() }
        composable("ScreenB"){ ScreenB(navController) }
    }

}
