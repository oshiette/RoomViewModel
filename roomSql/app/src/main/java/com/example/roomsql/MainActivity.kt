package com.example.roomsql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.roomsql.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val db = MainDb.getDb(this)

        db.getDao().getAllItems().asLiveData().observe(this){list ->
            bind.tvData.text = ""
            list.forEach {
                val text = "Id ${it.id} Name ${it.name} Price${it.price}\n"
                bind.tvData.append(text)

            }
        }

        bind.btSave.setOnClickListener {
            val item = Item(null,
            bind.edName.text.toString(),
            bind.edPrice.text.toString()
            )
            Thread{ db.getDao().inserItem(item) }.start()
            Toast.makeText(this, "Запись в базу добавлена", Toast.LENGTH_SHORT).show()
            bind.edName.setText("")
            bind.edPrice.setText("")
        }
    }
}