package com.example.thenamequiz.dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.thenamequiz.model.Person


@Dao
interface PersonDao {
    @Query("Select * FROM person")
    fun getAll(): ArrayList<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg persons: Person) //check persons

    @Delete
    fun delete(person: Person)
}