package com.example.thenamequiz.dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.thenamequiz.model.Person


@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Query("Select * FROM person")
    fun getAll(): List<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg person: Person) //check persons

    @Delete
    fun delete(person: Person)

    @Query("SELECT * FROM PERSON WHERE name LIKE :name" )
    fun findByName(name: String):Person
}