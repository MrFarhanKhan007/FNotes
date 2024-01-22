package com.example.fnotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fnotes.screens.AddTaskScreen
import com.example.fnotes.screens.HomeScreen
import com.example.fnotes.screens.UpdateTaskScreen

@Composable
fun TasksNavigationComponent() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = TaskScreens.HOME_SCREEN.name
    ) {

        composable(route = TaskScreens.HOME_SCREEN.name) {
            // this si where this will lead us to
            HomeScreen(navController = navController)
        }

        composable(route = TaskScreens.ADDTASK_SCREEN.name) {
            AddTaskScreen(navController = navController)
        }

        composable(route = TaskScreens.UPDATETASK_SCREEN.name) {
            UpdateTaskScreen(navController = navController)
        }
    }

}