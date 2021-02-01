package com.example.thenamequiz.model

import android.app.Application
import android.graphics.BitmapFactory
import com.example.thenamequiz.R
import java.util.*


class PersonList : Application(){
    var personList = ArrayList<Person>()

    override fun onCreate() {
        super.onCreate()
        personList.add(Person("Hassan", BitmapFactory.decodeResource(resources, R.drawable.hassan)))
        personList.add(Person("Peter", BitmapFactory.decodeResource(resources, R.drawable.peter)))
        personList.add(Person("Sivert", BitmapFactory.decodeResource(resources, R.drawable.sivert)))
    }
}

