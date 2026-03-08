package com.example.notes_app.data.datasource

import com.example.notes_app.domain.model.Note

interface NotesDataSource {
    fun addNote(note: Note)
    fun getNotes(): List<Note>
}