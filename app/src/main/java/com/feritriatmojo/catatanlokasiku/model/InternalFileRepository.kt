package com.feritriatmojo.catatanlokasiku.model

//TODO 1 : Mengimport beberapa data yang diperlukan
import android.content.Context
import java.io.File

//TODO 2 : Menggunakan class bernama InternalFileRepository
class InternalFileRepository(var context: Context) :
    NoteRepository {
    private fun noteFile(fileName: String): File = File(noteDirectory(), fileName)
    private fun noteDirectory(): String = context.filesDir.absolutePath

    //TODO 3 : disini untuk menambahkan catatan
    override fun addNote(note: Note) {
        context.openFileOutput(note.fileName, Context.MODE_PRIVATE).use { output ->
            output.write(note.noteText.toByteArray())
        }
    }

    //TODO 4 : disini untuk mendapatkan catatan
    override fun getNote(fileName: String): Note {
        val note = Note(fileName, "")
        context.openFileInput(fileName).use { stream ->
            val text = stream.bufferedReader().use {
                it.readText()
            }
            note.noteText = text
        }
        return note
    }

    //TODO 5 : disini untuk menghapus catatan
    override fun deleteNote(fileName: String): Boolean {
        return noteFile(fileName).delete()
    }
}