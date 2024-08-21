package com.example.fnotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_table ORDER BY id DESC")
    fun getAllNotesDESC(): Flow<List<Note>>

    @Query("SELECT * FROM notes_table WHERE id=:id")
    suspend fun getNoteById(id: Int): Note

    @Upsert
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}