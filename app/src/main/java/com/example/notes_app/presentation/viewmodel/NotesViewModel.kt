package com.example.notes_app.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes_app.domain.model.Note
import com.example.notes_app.domain.usecase.AddNoteUseCase
import com.example.notes_app.domain.usecase.GetNoteUseCase
import com.example.notes_app.presentation.noteslist.NotesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val getNotesUseCase: GetNoteUseCase,
                     private val addNoteUseCase: AddNoteUseCase
) : ViewModel() {
    private  val _state= MutableStateFlow(NotesState())
    val state=_state.asStateFlow()

    init {
        loadNotes()
    }
    private  fun loadNotes() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val notes = getNotesUseCase.invoke();
            _state.update { it.copy(notes = notes, isLoading = false) }
        }
    }

      fun addNote(note: Note) {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true) }
                addNoteUseCase.invoke(note)
                loadNotes()
            }catch (err: Exception) {
                _state.update { it.copy(error = err.message, isLoading = false) }
            }

        }


    }



}