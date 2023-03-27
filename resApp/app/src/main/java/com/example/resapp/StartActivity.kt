package com.example.resapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        supportActionBar?.hide()

        val buttonExit = findViewById<Button>(R.id.button6)
        val buttonStart = findViewById<Button>(R.id.button5)
        buttonExit.setOnClickListener(this::exitApp)
        buttonStart.setOnClickListener(this::startNew)

    }
    fun startNew(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun exitApp(view: View) {
        finish()
    }
}