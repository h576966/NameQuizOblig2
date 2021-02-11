package com.example.thenamequiz.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thenamequiz.dao.PersonDao

@Database(entities = arrayOf(Person::class), version = 1, exportSchema = false)

abstract class PersonRoomDatabase: RoomDatabase() {
    abstract val personDao: PersonDao

    companion object {

        @Volatile
        private var INSTANCE: PersonRoomDatabase? = null

        fun getInstance(context: Context): PersonRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE


                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            PersonRoomDatabase::class.java, "person_database")

                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}
