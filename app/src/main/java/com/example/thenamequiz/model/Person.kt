package com.example.thenamequiz.model

import android.graphics.Bitmap
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val name: String,
    val image: Bitmap)

//@ColumnInfo(name="name") @NonNull

