package com.example.thenamequiz.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.example.thenamequiz.dao.PersonDao
import androidx.lifecycle.LiveData


class PersonRepository(application: Application) {
    val searchResults = MutableLiveData<List<Person>>()

    // Referer til PersonDatabase slik at vi kan bruke DAO kommandoer som insert, delete osv.
    private var personDao: PersonDao?

    init {
        val db: PersonRoomDatabase? =
                PersonRoomDatabase.getDatabase(application)
        personDao = db?.personDao()
    }

    //Lager en variabel som vi bruker til å hente listen med personer, kobles til recyclerview
    val allProducts: LiveData<List<Person>>?

    init {
        val db: PersonRoomDatabase? =
                PersonRoomDatabase.getDatabase(application)
        personDao = db?.personDao()

        allProducts = personDao?.getAll()
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


