package com.example.thenamequiz.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.thenamequiz.R
import com.example.thenamequiz.databinding.ActivityQuizBinding
import com.example.thenamequiz.model.Person
import com.example.thenamequiz.model.PersonList
import java.net.PasswordAuthentication
import java.util.*
import kotlin.collections.ArrayList

import android.content.Context
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    lateinit var quiz: Quiz
    lateinit var data: ArrayList<Person>
    lateinit var currentPerson: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        data = (application as PersonList).data
        quiz = Quiz(data)

        inputAnswer.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP){
                if (!quiz.done){
                    submitAnswer(inputAnswer)
                }
                return@OnKeyListener true
            }
            false
        })
        runRound()
    }



    private fun runRound(){
        val person = quiz.pickPerson()
        imageViewQuiz.setImageBitmap(person.image)
        currentPerson = person
    }

    fun restart(view: View){
        quiz = Quiz(data)
        restartBtn.visibility = View.INVISIBLE
        submitAns.visibility = View.VISIBLE
        textPerson.text = "0"
        yourScore.text = "0"
        runRound()

    }

    fun submitAnswer(view: View){
        val isCorrect = quiz.answer(inputAnswer.text.toString())
        textPerson.text = quiz.attempts.toString()
        yourScore.text = quiz.score.toString()
        displayFeedback(isCorrect)
        inputAnswer.setText("")

        if (!quiz.isDone()){
            runRound()
        }else{
            Toast.makeText(this, "Yee-haaw, you've done it!", Toast.LENGTH_SHORT).show()
            submitAns.visibility = View.INVISIBLE
            restartBtn.visibility = View.VISIBLE


        }
    }

    private fun displayFeedback(isCorrect: Boolean){
        if(isCorrect){
            textFeedback.visibility = View.VISIBLE
        }else {
            val msg = "Wrong answer! Correct answer was ${currentPerson.name}"
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }


}
