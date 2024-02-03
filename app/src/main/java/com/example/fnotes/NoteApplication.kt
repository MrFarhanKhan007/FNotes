package com.example.fnotes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class NoteApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

}