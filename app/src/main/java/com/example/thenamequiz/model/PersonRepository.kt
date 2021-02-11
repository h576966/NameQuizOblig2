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






/*(application: Application) {
val searchResults = MutableLiveData<List<Person>>()

// Referer til PersonDatabase slik at vi kan bruke DAO kommandoer som insert, delete osv.
private var personDao: PersonDao?

init {
    val db: PersonRoomDatabase? =
            PersonRoomDatabase.getDatabase(application)
    personDao = db?.personDao()
}

//Lager en variabel som vi bruker til å hente listen med personer, kobles til recyclerview
val allPersons: LiveData<List<Person>>?

init {
    val db: PersonRoomDatabase? =
            PersonRoomDatabase.getDatabase(application)
    personDao = db?.personDao()

    allPersons = personDao?.getAll()
}






fun insertPerson(newperson: Person) {
    val task = InsertAsyncTask(personDao)
    task.execute(newperson)
}

fun deletePerson(name: String) {
    val task = DeleteAsyncTask(personDao)
    task.execute(name)
}

fun findPerson(name: String) {
    val task = QueryAsyncTask(personDao)
    task.delegate = this
    task.execute(name)
}



fun asyncFinished(results: List<Person>) {
    searchResults.value = results
}


private class QueryAsyncTask constructor(val asyncTaskDao: PersonDao?) :
        AsyncTask<String, Void, List<Person>>() {
    var delegate: PersonRepository? = null

    override fun doInBackground(vararg params: String): List<Person>? {
        return asyncTaskDao?.findName(params[0])
    }

    override fun onPostExecute(result: List<Person>) {
        delegate?.asyncFinished(result)
    }
}

private class InsertAsyncTask constructor(private val asyncTaskDao: PersonDao?)
    : AsyncTask<Person, Void, Void>() {
    override fun doInBackground(vararg params: Person): Void? {
        asyncTaskDao?.insertPerson(params[0])
        return null
    }
}

private class DeleteAsyncTask constructor(private val asyncTaskDao: PersonDao?)
    : AsyncTask<String, Void, Void>() {

    override fun doInBackground(vararg params: String): Void? {
        asyncTaskDao?.deletePerson(params[0])
        return null
    }
}
}


// private var personDao:PersonDao?

/* init {
    val db: PersonRoomDatabase?=
        PersonRoomDatabase.getDatabase(application)
    personDao =db?.personDao()
}*/

 *///