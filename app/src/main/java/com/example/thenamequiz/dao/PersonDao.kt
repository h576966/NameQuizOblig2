package com.example.thenamequiz.dao
 import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.thenamequiz.model.Person
 import kotlinx.coroutines.flow.Flow


@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Query("Select * FROM person_table")
    fun getAll(): Flow<List<Person>> //LiveData -> Flow

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg person: Person) //check persons

    @Delete
    fun delete(person: Person)

    @Query("SELECT * FROM person_table WHERE name LIKE :name")
    fun findByName(name: String):Person

    @Query("SELECT * FROM person_table WHERE name = :name")
    fun findName(name: String): List<Person>

    @Query("DELETE FROM person_table WHERE name = :name")
    fun deletePerson(name: String)
}