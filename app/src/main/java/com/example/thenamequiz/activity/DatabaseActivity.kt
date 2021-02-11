package com.example.thenamequiz.activity

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.thenamequiz.R
import com.example.thenamequiz.adapter.PersonAdapter
import com.example.thenamequiz.model.Person
import com.example.thenamequiz.model.PersonRoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class DatabaseActivity : AppCompatActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val db = Room.databaseBuilder(
            applicationContext,
            PersonRoomDatabase::class.java, "todo-list.db"
        ).build()

        GlobalScope.launch {
            db.personDao().insertAll(Person("Hassan", BitmapFactory.decodeResource(resources, R.drawable.hassan))
            data = db.personDao().getAll()

            data?.forEach {
                println(it)
            }
        }

        val person = PersonRoomDatabase(this)
        val adapter = PersonAdapter(person)


        recyclerView.adapter = adapter
    }





}