package com.example.belajarroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//import com.example.notewithroom.database.note.Note
//import com.example.notewithroom.database.note.NoteDao
import com.learningas.notewithroom.database.note.Note
import com.learningas.notewithroom.database.note.NoteDao

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {

        private const val DB_NAME = "NOTE_DB"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room
                        .databaseBuilder(
                            context,
                            AppDatabase::class.java,
                            DB_NAME
                        )
                        .build()
                }
            }
            return instance
        }

    }

}