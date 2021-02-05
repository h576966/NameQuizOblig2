package com.example.thenamequiz.activity

import android.os.Bundle
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thenamequiz.R
import com.example.thenamequiz.model.Person
import com.example.thenamequiz.model.PersonList
import com.example.thenamequiz.model.Quiz
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz.*
import java.util.*


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
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                if (!quiz.done) {
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
        //textPerson.text = "0"
        yourScore.text = "0"
        runRound()

    }

    fun submitAnswer(view: View){
        val isCorrect = quiz.answer(inputAnswer.text.toString())
        //textPerson.text = quiz.attempts.toString()
        yourScore.text = quiz.score.toString() + "/" + quiz.attempts.toString()
        displayFeedback(isCorrect)
        inputAnswer.setText("")

        if (!quiz.isDone()){
            runRound()
        }else{
            var extraText =""
            if (quiz.score/quiz.attempts>=0.67){
                extraText="Good Job!!!"
            }else{ extraText="Not great, you need some practice."}

            var scoreText = "Quiz completed, your score was " + quiz.score.toString()+ " out of "+ quiz.attempts.toString() + " attempts " + extraText
            val toast = Toast.makeText(this, scoreText, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
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
