package com.example.room_word_sample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao


    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): WordRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordRoomDatabase::class.java,
                    "word_database"
                    )
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        var wordDao = database.wordDao()
                        // Delete all content here.
                        wordDao.deleteAll()

                        // Add sample words
                        wordDao.insert(Word("Hello"))
                        wordDao.insert(Word("World!"))
                        wordDao.insert(Word("Hello"))
                        wordDao.insert(Word("New Game!"))
                    }
                }
            }
        }
    }
}