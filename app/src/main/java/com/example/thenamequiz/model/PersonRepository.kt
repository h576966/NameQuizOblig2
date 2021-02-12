package com.example.thenamequiz.model

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.thenamequiz.dao.PersonDao
import kotlinx.coroutines.flow.Flow


class PersonRepository(private val personDao: PersonDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val readAll: LiveData<List<Person>> = personDao.readAll() //changed from LiveData check later


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addPerson(person: Person) {
        personDao.addPerson(person)
    }
}





