package com.example.fnotes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes_table")
data class Note(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

//    @ColumnInfo(name = "Note_Title")
//    val noteTitle: String,

    @ColumnInfo(name = "Note_Description")
    val noteDescription: String,

    )
