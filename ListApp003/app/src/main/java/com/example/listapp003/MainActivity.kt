package com.example.listapp003

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listapp003.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
         var listItem =  ArrayList<String>()
        listItem.add("Входящие")
        listItem.add("Отправленные")
        listItem.add("Избранное")
        listItem.add("Работа")
        listItem.add("Личное")
        listItem.add("Развлечения")
        listItem.add("Спам")
        listItem.add("Корзина")
        listItem.add("Входящие")
        listItem.add("Отправленные")
        listItem.add("Избранное")
        listItem.add("Работа")
        listItem.add("Личное")
        listItem.add("Развлечения")
        listItem.add("Спам")
        listItem.add("Корзина")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem)
        bind.listV.adapter = adapter
        bind.listV.setOnItemClickListener{parent, view, position, id ->
            Toast.makeText(this, "Выбрано $id ${listItem[position]} $parent $view", Toast.LENGTH_SHORT).show()
        }
    }
}