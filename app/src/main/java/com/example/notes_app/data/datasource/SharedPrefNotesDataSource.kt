package com.example.notes_app.data.datasource

import android.content.SharedPreferences
import com.example.notes_app.domain.model.Note
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject
import androidx.core.content.edit

class SharedPrefNotesDataSource @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
) : NotesDataSource {

    private val NOTES_KEY = "user_notes"

    override fun addNote(note: Note) {
        val currentNotes = getNotes().toMutableList()
        currentNotes.add(note)
        saveNotesList(currentNotes)
    }

    override fun getNotes(): List<Note> {
        val json = sharedPreferences.getString(NOTES_KEY, null) ?: return emptyList()
        val type = object : TypeToken<List<Note>>() {}.type
        return gson.fromJson(json, type) ?: emptyList()
    }

    private fun saveNotesList(notes: List<Note>) {
        val json = gson.toJson(notes)
        sharedPreferences.edit { putString(NOTES_KEY, json) }
    }
}