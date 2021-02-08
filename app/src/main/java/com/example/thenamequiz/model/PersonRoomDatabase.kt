package com.example.thenamequiz.model

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thenamequiz.dao.PersonDao

@Database(entities = arrayOf(Person::class), version = 1)

abstract class PersonRoomDatabase: RoomDatabase() {
   // public abstract PersonDao personDao();

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

    abstract fun personDao(): PersonDao

}