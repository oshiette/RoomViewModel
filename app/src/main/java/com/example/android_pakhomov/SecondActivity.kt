package com.example.android_pakhomov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    var questionNo = 0
    var questions = listOf("Каковы два официальных языка для разработки Android? \n\n " +
            "A) Kotlin и Java \n\n B) Java и Python \n\n C) Kotlin и Python",
        "Как вы определяете функцию в Kotlin? \n\n A) void \n\n B) var \n\n C) fun",
        "Для чего используется переменная? \n\n A) Хранить данные \n\n B) Для вставки случайного значения \n\n C) Что бы найти её значение",
        "Что означает SDK в Android SDK?? \n\n A) Software Development Kit \n\n B) Software Development Kotlin \n\n C) Something Don't Know")

    var rightAnswers = listOf(1, 3, 1, 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.hide()

        val question = findViewById<TextView>(R.id.textView2)
        question.setText(questions.get(questionNo))
        val buttonA = findViewById<Button>(R.id.button3)
        val buttonB = findViewById<Button>(R.id.button5)
        val buttonC = findViewById<Button>(R.id.button6)

        buttonA.setOnClickListener {
            showToast(1, question)
        }
        buttonB.setOnClickListener {
            showToast(2, question)
        }
        buttonC.setOnClickListener {
            showToast(3, question)
        }
    }
    fun showToast(ans: Int, question: TextView) {
        if (ans == rightAnswers[questionNo]) {
            Toast.makeText(applicationContext, "Правильно!", Toast.LENGTH_SHORT).show()
            updateQest(question)
        } else {
            Toast.makeText(applicationContext, "Ответ не верный", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateQest(question: TextView) {
        questionNo = questionNo + 1
        if (questionNo > 3) questionNo = 0
        question.setText(questions.get(questionNo))
    }
}