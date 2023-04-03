package com.example.sharedprefer003

import android.content.Context
import android.content.SharedPreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedprefer01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val sharedPrefFile = "TABLE"
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
        bind.save.setOnClickListener {
            val id:Int = bind.editId.text.toString().toInt()
            val name:String = bind.editName.text.toString()
            val editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("id_key",id)
            editor.putString("name_key",name)
            editor.apply()
            editor.commit()
        }
        bind.view.setOnClickListener {
            val sharedIdValue = sharedPreferences.getInt("id_key",0)
            val sharedNameValue = sharedPreferences.getString("name_key","defaultname")
            if(sharedIdValue.equals(0) && sharedNameValue.equals("defaultname")){
                bind.textViewShowName.setText("default name: ${sharedNameValue}").toString()
                bind.textViewShowId.setText("default id: ${sharedIdValue.toString()}")
            }else{
                bind.textViewShowName.text = sharedNameValue
                bind.textViewShowId.text = sharedIdValue.toString()
            }
        }
        bind.clear.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            bind.textViewShowName.text = ""
            bind.textViewShowId.text = ""
        }
    }
}
