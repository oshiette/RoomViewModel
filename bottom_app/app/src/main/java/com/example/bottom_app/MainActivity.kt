package com.example.bottom_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.bottom_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)


        bind.navBott.setOnItemSelectedListener {
            when(it.itemId)  {
                R.id.item ->{
                    Toast.makeText(this,"Open", Toast.LENGTH_SHORT).show()}
                R.id.item2 ->{
                    Toast.makeText(this,"Save", Toast.LENGTH_SHORT).show()}
                R.id.item3 ->{
                    Toast.makeText(this,"Search", Toast.LENGTH_SHORT).show()}
                R.id.item4 ->{
                    Toast.makeText(this,"Delete", Toast.LENGTH_SHORT).show()}
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.topItem1{}
        }
        return true
    }
}