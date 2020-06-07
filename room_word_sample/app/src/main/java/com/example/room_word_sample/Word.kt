package com.example.room_word_sample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word (
    @PrimaryKey
    @ColumnInfo(name = "word")
    val word: String
)