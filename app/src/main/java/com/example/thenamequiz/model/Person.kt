package com.example.thenamequiz.model

import android.graphics.Bitmap
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey //(autoGenerate = true)
    @NonNull
    val id: Int,
    @ColumnInfo(name="name")val name: String,
    @ColumnInfo(name="image")val image: Bitmap)


