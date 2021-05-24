package com.learningas.notewithroom.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.learningas.notewithroom.database.note.Note
import com.learningas.notewithroom.database.note.NoteRepository

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private var noteRepository = NoteRepository(application)
    private var notes: LiveData<List<Note>>? = noteRepository.getNotes()

    fun insertNote(note: Note) {
        noteRepository.insert(note)
    }

    fun getNotes(): LiveData<List<Note>>? {
        return notes
    }

    fun deleteNote(note: Note) {
        noteRepository.delete(note)
    }

    fun updateNote(note: Note) {
        noteRepository.update(note)
    }

}