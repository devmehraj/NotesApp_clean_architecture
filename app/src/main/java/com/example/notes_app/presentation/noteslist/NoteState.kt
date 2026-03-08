package com.example.notes_app.presentation.noteslist

import com.example.notes_app.domain.model.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)