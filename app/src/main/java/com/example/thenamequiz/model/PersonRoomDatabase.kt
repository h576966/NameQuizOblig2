package com.example.thenamequiz.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thenamequiz.dao.PersonDao

@Database(entities = arrayOf(Person::class), version = 1, exportSchema = false)

abstract class PersonRoomDatabase: RoomDatabase() {
    abstract val personDao: PersonDao

    companion object{

        @Volatile
        private var INSTANCE: PersonRoomDatabase? = null

        fun getInstance(context: Context): PersonRoomDatabase{
            synchronized(this){
                var instance = INSTANCE


                if (instance ==null){
                    instance = Room.databaseBuilder(
                                    context.applicationContext,
                                    PersonRoomDatabase::class.java, "person_database")

                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE= instance
                }
                return instance
            }

        }
    }

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