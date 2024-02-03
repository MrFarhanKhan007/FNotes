package com.example.fnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.fnotes.data.NoteDao
import com.example.fnotes.di.AppModule.providesNoteDao
import com.example.fnotes.di.AppModule.providesNoteDatabase
import com.example.fnotes.navigation.TasksNavigationComponent
import com.example.fnotes.ui.theme.FNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteDao: NoteDao = providesNoteDao(
                        noteDatabase = providesNoteDatabase(
                            context = applicationContext
                        )
                    )
                    TasksNavigationComponent(noteDao = noteDao)
                }
            }
        }
    }
}

