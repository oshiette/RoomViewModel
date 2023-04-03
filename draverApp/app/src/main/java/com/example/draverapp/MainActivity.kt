package com.example.draverapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.draverapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.fButt.setOnClickListener {
            bind.idDrawer.openDrawer(GravityCompat.START)
        }

        bind.navMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 ->{Toast.makeText(this, "Выбрана опция Настройки -> ${it.title}", Toast.LENGTH_SHORT).show()}
                R.id.item2 ->{Toast.makeText(this, "Выбрана опция Настройки ->${it.title}", Toast.LENGTH_SHORT).show()}
                R.id.item3 ->{Toast.makeText(this, "Выбрана опция Настройки -> ${it.title}", Toast.LENGTH_SHORT).show()}
                R.id.item11 ->{Toast.makeText(this, "Выбрана опция Документация -> ${it.title}", Toast.LENGTH_SHORT).show()}
                R.id.item22 ->{Toast.makeText(this, "Выбрана опция Документация -> ${it.title}", Toast.LENGTH_SHORT).show()}
                R.id.item33 ->{Toast.makeText(this, "Выбрана опция Документация -> ${it.title}", Toast.LENGTH_SHORT).show()}

            }
            bind.idDrawer.closeDrawer(GravityCompat.START)
            true
        }
    }
}