package com.example.thenamequiz.model

class Quiz (data: ArrayList<Person>){

    var score: Int
    var attempts: Int
    var done: Boolean
    var index: Int
    var person: ArrayList<Person>

    init {
        score = 0
        attempts = 0
        done = false
        index = 0
        person = data
        data.shuffle()
    }

    fun answer(ans: String): Boolean{
        attempts++
        var correct = false
        if (ans.equals(person[index].name, true)){
            score++
            correct = true
        }
        index++
        done = isDone()
        return correct
    }

    fun isDone(): Boolean{
        return attempts == person.size
    }

    fun pickPerson(): Person{
        val person = person[index]
        return person
    }
}