package com.orange.noteappbasic.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.orange.noteappbasic.model.Note
import com.orange.noteappbasic.util.DateConverter
import com.orange.noteappbasic.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
//@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun noteDao():NoteDatabaseDao
}