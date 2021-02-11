package com.example.thenamequiz.model

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PersonApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())


    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { PersonRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { PersonRepository(database.personDao()) }

}
