package com.ilhomsoliev.stuffcounter.app.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ilhomsoliev.addstufffeature.presentation.AddStuffScreen
import com.ilhomsoliev.core.Routes
import com.ilhomsoliev.homefeature.presentation.HomeScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
        NavHost(
            modifier = Modifier,
            navController = navController,
            startDestination = Routes.HOME_SCREEN
        ) {

            composable(route = Routes.HOME_SCREEN){
                HomeScreen(navController)
            }
            composable(route = Routes.ADD_STUFF_SCREEN){
                AddStuffScreen(navController)
            }
            composable(route = Routes.STUFF_DESCRIPTION_SCREEN){
                //Stuff(navController)
            }

        }
}