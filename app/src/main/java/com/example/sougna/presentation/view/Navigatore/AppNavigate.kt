package com.example.sougna.presentation.view.Navigatore

import com.example.sougna.presentation.view.pages.HomePage
import com.example.sougna.presentation.view.IntroScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "intro") {
        composable("intro") { IntroScreen(navController) }
        composable("home") { HomePage() }
    }
}