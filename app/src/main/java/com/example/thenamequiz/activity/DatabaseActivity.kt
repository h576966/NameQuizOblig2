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



        val person = PersonRoomDatabase(this)
        val adapter = PersonAdapter(person)


        recyclerView.adapter = adapter
    }





}