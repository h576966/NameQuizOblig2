package com.example.thenamequiz.dao
 import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.thenamequiz.model.Person
 import kotlinx.coroutines.flow.Flow


@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPerson(person: Person)

    @Query("Select * FROM person_table")
    suspend fun getAll(): Flow<List<Person>> //LiveData -> Flow

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(vararg person: Person) //check persons

    @Delete
    suspend fun delete(person: Person)

    @Query("SELECT * FROM person_table WHERE name LIKE :name")
    suspend fun findByName(name: String):Person

    @Query("SELECT * FROM person_table WHERE name = :name")
    suspend fun findName(name: String): List<Person>

    @Query("DELETE FROM person_table WHERE name = :name")
    suspend fun deletePerson(name: String)

    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Person>>
}