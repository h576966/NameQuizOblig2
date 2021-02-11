package com.example.thenamequiz.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.example.thenamequiz.dao.PersonDao

class PersonRepository(application: Application) {
    val searchResults=MutableLiveData<List<Person>>()

    fun asyncFinished(results: List<Person>){
        searchResults.value=results
    }

    private class QueryAsyncTask constructor(val asyncTaskDao: PersonDao?):
    AsyncTask<String, Void, List<Person>>(){

    }



   // private var personDao:PersonDao?

   /* init {
        val db: PersonRoomDatabase?=
            PersonRoomDatabase.getDatabase(application)
        personDao =db?.personDao()
    }*/


}