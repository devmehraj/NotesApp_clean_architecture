package com.example.notes_app.domain.repository

import com.example.notes_app.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    fun addNote(note: Note)
    fun getNotes(): List<Note>
}