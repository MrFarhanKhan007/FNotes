package com.example.fnotes.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fnotes.data.NoteDao
import com.example.fnotes.data.NoteRepository
import com.example.fnotes.ui.screens.AddNoteScreen
import com.example.fnotes.ui.screens.HomeScreen
import com.example.fnotes.ui.screens.UpdateNoteScreen


@Composable
fun TasksNavigationComponent(noteDao: NoteDao) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NoteScreens.HOME_SCREEN.name
    ) {
        NoteRepository(noteDao = noteDao)

        composable(route = NoteScreens.HOME_SCREEN.name) {
            // this is where this will lead us to
            HomeScreen(navController = navController)
        }

        composable(route = NoteScreens.ADDNOTE_SCREEN.name) {
            AddNoteScreen(navController = navController)
        }

        composable(
            route = NoteScreens.UPDATENOTE_SCREEN.name + "/id={noteID}",
            arguments = listOf(navArgument(name = "noteID") {
                NavType.IntType
                defaultValue = -1
            })
        )
        { backStackEntry ->
            val note_ID = backStackEntry.arguments?.getInt("noteID")

            if (note_ID == null) {
                Log.d("TAG", "TasksNavigationComponent: $note_ID is null")
                navController.navigate(route = NoteScreens.HOME_SCREEN.name)
                return@composable
            }

            UpdateNoteScreen(navController = navController, noteId = note_ID)
        }
    }

}