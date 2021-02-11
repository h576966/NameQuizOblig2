package com.example.thenamequiz.model

import androidx.annotation.WorkerThread
import com.example.thenamequiz.dao.PersonDao
import kotlinx.coroutines.flow.Flow


class PersonRepository(private val personDao: PersonDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allPersons: Flow<List<Person>> = personDao.getAll() //changed from LiveData check later

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertPerson(person: Person) {
        personDao.insertPerson(person)
    }
}





