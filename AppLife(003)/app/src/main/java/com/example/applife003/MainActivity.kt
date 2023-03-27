package com.example.applife003

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val textV = findViewById<TextView>(R.id.textView2)
        val editT1 = findViewById<EditText>(R.id.editText)
        val editT2 = findViewById<EditText>(R.id.editText2)

        btn.setOnClickListener {

            val a1 = editT1.text.toString().toInt()
            val a2 = editT2.text.toString().toInt()

            val a3 = a1 + a2
            textV.text = a3.toString()
        }
        btn2.setOnClickListener {

            val a1 = editT1.text.toString().toInt()
            val a2 = editT2.text.toString().toInt()

            val a3 = a1 * a2
            textV.text = a3.toString()
        }
        btn3.setOnClickListener {

            val a1 = editT1.text.toString().toInt()
            val a2 = editT2.text.toString().toInt()
            val a3 = a1 - a2
            textV.text = a3.toString()
        }
    }
}

