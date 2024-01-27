package com.example.fnotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fnotes.ui.screens.AddNoteScreen
import com.example.fnotes.ui.screens.HomeScreen
import com.example.fnotes.ui.screens.UpdateNoteScreen

@Composable
fun TasksNavigationComponent() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NoteScreens.HOME_SCREEN.name
    ) {

        composable(route = NoteScreens.HOME_SCREEN.name) {
            // this si where this will lead us to
            HomeScreen(navController = navController)
        }

        composable(route = NoteScreens.ADDNOTE_SCREEN.name) {
            AddNoteScreen(navController = navController)
        }

        composable(route = NoteScreens.UPDATENOTE_SCREEN.name) {
            UpdateNoteScreen(navController = navController)
        }
    }

}