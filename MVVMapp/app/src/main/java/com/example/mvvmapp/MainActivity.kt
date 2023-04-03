package com.example.mvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter = 0

    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        bind.bt1.setOnClickListener {
            viewModel.addNumber()
            bind.tv1.text = viewModel.number.toString()
        }
    }
}