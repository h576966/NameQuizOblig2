package com.example.thenamequiz.dao
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.thenamequiz.model.Person


@Dao
interface PersonDao {
    @Query("SELECT * FROM person ORDER BY name")
    fun getAll(): LiveData<List<Person>>

    @Query("SELECT * FROM persons WHERE id = :personId")
    fun getPerson(personId: String): LiveData<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: Person)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(persons: List<Person>)

    @Query("DELETE FROM persons WHERE id = :personId")
    suspend fun delete(personId: String)
}

}