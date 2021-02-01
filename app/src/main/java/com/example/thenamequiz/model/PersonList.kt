package com.example.thenamequiz.model

import android.app.Application
import android.graphics.BitmapFactory
import com.example.thenamequiz.R
import java.util.*


class PersonList : Application(){

    var data = ArrayList<Person>()

    override fun onCreate() {
        super.onCreate()
        data.add(Person("Hassan", BitmapFactory.decodeResource(resources, R.drawable.hassan)))
        data.add(Person("Peter", BitmapFactory.decodeResource(resources, R.drawable.peter)))
        data.add(Person("Sivert", BitmapFactory.decodeResource(resources, R.drawable.sivert)))
    }


}

