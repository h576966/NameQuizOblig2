package com.example.thenamequiz.coroutines

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.room.RoomDatabase
import com.example.thenamequiz.dao.PersonDao
import java.lang.IllegalArgumentException


//Must be placed in the Person package
class PersonViewModelFactory ()

/*
    private val dataSource: PersonDao,
    private val application: Application) ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewmodel::class.java)) {
            return PersonViewmodel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}https://developer.android.com/codelabs/kotlin-android-training-coroutines-and-room#3*/