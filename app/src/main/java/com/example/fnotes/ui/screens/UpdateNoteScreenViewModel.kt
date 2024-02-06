package com.example.fnotes.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fnotes.data.Note
import com.example.fnotes.data.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateNoteScreenViewModel
@Inject constructor(private val repository: NoteRepository) : ViewModel() {
    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }

    suspend fun getNoteById(id: Int): Note {
        return repository.getNoteById(id)
    }

    fun upsertNote(note: Note) =
        viewModelScope.launch {
            repository.upsertNote(note)
        }
}