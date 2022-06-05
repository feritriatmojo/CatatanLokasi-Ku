package com.feritriatmojo.catatanlokasiku.model
//TODO 1 : Menggunakan interface NoteRepository berisi fun addNote,getNote dan deleteNote
interface NoteRepository {
    fun addNote(note: Note)
    fun getNote(fileName: String): Note
    fun deleteNote(fileName: String): Boolean
}