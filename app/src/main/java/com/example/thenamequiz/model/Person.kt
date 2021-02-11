package com.example.thenamequiz.model

import android.graphics.Bitmap
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class Person(
    @PrimaryKey //(autoGenerate = true)
    @NonNull
    //val id: Int,
    val name: String,
    @ColumnInfo(name="content")val image: Bitmap)


