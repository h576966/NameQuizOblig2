package com.example.thenamequiz.model

import android.app.Application
import android.content.res.Configuration
import android.graphics.BitmapFactory
import com.example.thenamequiz.R
import java.util.*
import java.util.ArrayList;


class PersonList : Application(){
    var data = ArrayList<Person>()


    override fun onCreate() {
        super.onCreate()
        data.add(Person("Hassan", BitmapFactory.decodeResource(resources, R.drawable.hassan)))
        data.add(Person("Peter", BitmapFactory.decodeResource(resources, R.drawable.peter)))
        data.add(Person("Sivert", BitmapFactory.decodeResource(resources, R.drawable.sivert)))
    }
    override fun onConfigurationChanged ( newConfig : Configuration) {
        super.onConfigurationChanged(newConfig)
    }

}

