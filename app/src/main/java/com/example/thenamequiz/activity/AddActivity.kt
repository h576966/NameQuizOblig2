package com.example.thenamequiz.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thenamequiz.databinding.ActivityAddBinding

import android.widget.ImageView


import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View

import android.widget.Toast
import com.example.thenamequiz.R

import java.io.IOException
import java.util.ArrayList

import com.example.thenamequiz.model.Person
import com.example.thenamequiz.model.PersonList


class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add)
    }



    fun onClickDatabase2(view: View){
        val database = Intent(this, DbActivity::class.java)

        startActivity(database)
    }

    val REQUEST_IMAGE_CAPTURE = 1
    val REQUEST_IMAGE_PICK = 2

    fun pickPhoto(view: View){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_IMAGE_PICK)
    }

    fun addPerson(view: View){
        val bitmap: Bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val person = Person(inputText.text.toString(), bitmap)
        val data = (application as PersonList).data
        data.add(person)
        Toast.makeText(this, "${inputText.text} added to database!", Toast.LENGTH_SHORT).show()
        inputText.setText("")
        imageView.setImageDrawable(null)
        restart(view)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.imageView)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_IMAGE_PICK){
            imageView.setImageURI(data?.data)
            imageAdded(isAdded = true)
        }
    }

    private fun imageAdded(isAdded: Boolean){
        if(isAdded){
            addActivityButton.visibility = View.VISIBLE
            inputText.visibility = View.VISIBLE
            buttonPhoto.visibility = View.INVISIBLE
        }
    }

    fun restart(view: View){
        buttonPhoto.visibility = View.VISIBLE
        inputText.visibility = View.INVISIBLE
        addActivityButton.visibility = View.INVISIBLE
    }

}
