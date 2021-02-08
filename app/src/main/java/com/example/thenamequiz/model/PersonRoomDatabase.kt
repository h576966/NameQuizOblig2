package com.example.thenamequiz.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thenamequiz.dao.PersonDao

@Database(entities = arrayOf(Person::class), version = 1)

abstract class PersonRoomDatabase: RoomDatabase() {
    abstract fun personDao(): PersonDao

   /* companion object {
        @Volatile
        private var instance: PersonRoomDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) Room.databaseBuilder(context,
        PersonRoomDatabase::
        class.java, "person-list.db")
        .build()

    }*/
}

/*private static PersonRoomDatabase INSTANCE;

 static PersonRoomDatabse getDatabase(final Context context){
     if(INSTANCE == null){
         synchronized(PersonRoomDatabase.class){
             if(INSTANCE == null){
                 INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                 PersonRoomDatabase.class, "person_database").build();
             }
         }
     }
     return INSTANCE;

     }*/