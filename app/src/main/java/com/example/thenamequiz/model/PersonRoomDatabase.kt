package com.example.thenamequiz.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thenamequiz.dao.PersonDao
import kotlinx.coroutines.CoroutineScope

@Database(entities = [(Person::class)], version = 1, exportSchema = false)
abstract class PersonRoomDatabase: RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {  //Creates Singleton
        @Volatile
        private var INSTANCE: PersonRoomDatabase? = null

        internal fun getDatabase(context: Context, applicationScope: CoroutineScope): PersonRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(PersonRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                                Room.databaseBuilder<PersonRoomDatabase>(
                                        context.applicationContext,
                                        PersonRoomDatabase::class.java,
                                        "person_database").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
