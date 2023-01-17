package com.orange.noteappbasic.data

import com.orange.noteappbasic.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A good day", desc = "We went on a vacation"),
            Note(title = "A great night", desc = "We went to watch a movie"),
            Note(title = "Hello", desc = "We went on a vacation"),
            Note(title = "A good day", desc = "We went on a vacation"),
            Note(title = "A good day", desc = "We went on a vacation"),
            Note(title = "A good day", desc = "We went on a vacation"),
            Note(title = "A good day", desc = "We went on a vacation"),
            Note(title = "A good day", desc = "We went on a vacation"),

            )
    }
}