package com.example.menuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.menuapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        supportActionBar?.title = "Main"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.mSave ->{Toast.makeText(this, "Save file", Toast.LENGTH_SHORT).show()}
            R.id.mOpen ->{Toast.makeText(this, "Open file", Toast.LENGTH_SHORT).show()}
            R.id.mDelete ->{Toast.makeText(this, "Delete file", Toast.LENGTH_SHORT).show()}
            R.id.mFind ->{Toast.makeText(this, "Search file", Toast.LENGTH_SHORT).show()}
        }
            return true
    }
}