package com.example.thenamequiz.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Person(var name: String, var image: Bitmap){
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id", index = true)
    val id: Long = 0L

}

