package com.example.thenamequiz.coroutines

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.RoomDatabase
import com.example.thenamequiz.model.PersonRoomDatabase

class PersonViewmodel (
    val database: PersonRoomDatabase,
            application: Application): AndroidViewModel(application){

            }

