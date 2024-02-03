package com.example.fnotes.di

import android.content.Context
import androidx.room.Room
import com.example.fnotes.data.NoteDao
import com.example.fnotes.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun providesNoteDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun providesNoteDatabase(
        @ApplicationContext
        context: Context
    ): NoteDatabase = Room.databaseBuilder(
        context = context,
        klass = NoteDatabase::class.java,
        name = "notes_db"
    )
        .fallbackToDestructiveMigration()
        .build()
}