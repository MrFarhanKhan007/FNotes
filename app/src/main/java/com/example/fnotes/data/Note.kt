package com.example.fnotes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "notes_table")
data class Note(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

//    @ColumnInfo(name = "Note_Title")
//    val noteTitle: String,

    @ColumnInfo(name = "Note_Description")
    val noteDescription: String,

    )
