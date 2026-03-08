package com.example.notes_app.data.repository

import com.example.notes_app.data.datasource.NotesDataSource
import com.example.notes_app.domain.model.Note
import com.example.notes_app.domain.repository.NotesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotesRepositoryImpl @Inject constructor(private val dataSource: NotesDataSource) : NotesRepository {
    override fun addNote(note: Note) {
     return dataSource.addNote(note)
    }

    override fun getNotes(): List<Note> {
        return dataSource.getNotes()
    }

}