package com.example.fnotes.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

        composable(route = NoteScreens.UPDATENOTE_SCREEN.name + "/id={noteID}") { backStackEntry ->
            val noteID = backStackEntry.arguments?.getString("noteID")

            if (noteID == null) {
                Log.d("TAG", "TasksNavigationComponent: noteID is null")
                navController.navigate(route = NoteScreens.HOME_SCREEN.name)
                return@composable
            }


            //TODO: UpdateNoteScreen(navController = navController, noteID = noteID)


            UpdateNoteScreen(navController = navController)
        }
    }

}