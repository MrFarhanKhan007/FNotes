package com.example.fnotes.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun insertNote(note: Note) = noteDao.insertNote(note = note)

    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note = note)

    suspend fun updateNote(note: Note) = noteDao.updateNote(note = note)

    suspend fun getNoteById(id: String): Note = noteDao.getNoteById(id = id)

    fun getAllNotes(): Flow<List<Note>> =
        noteDao.getAllNotes().flowOn(context = Dispatchers.IO).conflate()

}