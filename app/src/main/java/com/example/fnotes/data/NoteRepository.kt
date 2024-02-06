package com.example.fnotes.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note = note)

    suspend fun getNoteById(id: Int): Note = noteDao.getNoteById(id = id)

    suspend fun upsertNote(note: Note) = noteDao.upsertNote(note = note)

    fun getAllNotes(): Flow<List<Note>> =
        noteDao.getAllNotes().flowOn(context = Dispatchers.IO).conflate()

}