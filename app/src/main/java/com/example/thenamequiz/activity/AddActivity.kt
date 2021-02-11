package com.example.thenamequiz.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_add.*

import android.view.View

import android.widget.Toast
import com.example.thenamequiz.R

import com.example.thenamequiz.model.Person
import com.example.thenamequiz.model.PersonApplication


class AddActivity : AppCompatActivity() {
   // val database: PersonRoomDatabase // Global variable



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
    }

    fun onClickDatabase2(view: View) {
        val database = Intent(this, DatabaseActivity::class.java)

        startActivity(database)
    }

    val REQUEST_IMAGE_PICK = 2

    fun pickPhoto(view: View) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_IMAGE_PICK)
    }

    fun addPerson(view: View) {
        val bitmap: Bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val person = Person(inputText.text.toString(), bitmap)
        val data = (application as PersonApplication).database
        data.add(person)
        Toast.makeText(this, "${inputText.text} added to database!", Toast.LENGTH_SHORT).show()
        inputText.setText("")
        imageView.setImageDrawable(null)
        restart()
    }

   /* fun saveToDatabase(person: Person) {
    class SaveToDatabase : AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids)
        {
            database.getPersonDao().insertPerson(Person)
            return null
        }
    }
    std: SaveToDatabase = SaveToDatabase()
    std.execute()
}*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.imageView)
        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE_PICK){
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

    fun restart() {
        buttonPhoto.visibility = View.VISIBLE
        inputText.visibility = View.INVISIBLE
        addActivityButton.visibility = View.INVISIBLE
    }

}
