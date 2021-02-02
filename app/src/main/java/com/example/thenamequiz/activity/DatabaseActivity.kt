package com.example.thenamequiz.activity

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thenamequiz.R
import com.example.thenamequiz.adapter.PersonAdapter
import com.example.thenamequiz.model.Person
import com.example.thenamequiz.model.PersonList
import java.util.ArrayList;


class DatabaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val person = PersonList().data
        val adapter = PersonAdapter(person)

        person.add(Person("Volker", BitmapFactory.decodeResource(resources, R.drawable.volker)))
        recyclerView.adapter = adapter
    }





}