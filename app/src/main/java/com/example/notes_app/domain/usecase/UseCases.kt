package com.example.notes_app.domain.usecase

import com.example.notes_app.domain.model.Note
import com.example.notes_app.domain.repository.NotesRepository
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(private  val repository: NotesRepository)  {
    fun invoke(): List<Note> {
        return repository.getNotes()
    }
}

class AddNoteUseCase @Inject constructor(private  val repository: NotesRepository) {
    fun invoke(note: Note) {
        if(note.desc.isNotBlank()) {
            repository.addNote(note)
        }
    }
}

class DeleteNoteUseCase @Inject constructor(private  val repository: NotesRepository) {
    fun invoke(note: Note) {
        //repository.deleteNote(note)
    }
}

class UpdateNoteUseCase @Inject constructor(private  val repository: NotesRepository) {
    fun invoke(note: Note) {
        //repository.updateNote(note)
    }
}