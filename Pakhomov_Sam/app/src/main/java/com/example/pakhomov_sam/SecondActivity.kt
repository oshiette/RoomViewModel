package com.example.pakhomov_sam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.pakhomov_sam.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var bind: ActivitySecondBinding
    var buttonState = "b"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bind.root)

        buttonState = intent.getStringExtra(Constants.BUTTON_STATE)!!
        if (buttonState == Constants.BUTTON_1) {
            bind.tZXC.visibility = View.VISIBLE

        } else if (buttonState == Constants.BUTTON_2) {
            bind.tPepega.visibility = View.VISIBLE
        }
    }

    fun onClickDone(view: View) {
        if (buttonState == Constants.BUTTON_1) {
            val i = Intent()
            i.putExtra(Constants.BUTTON_STATE, Constants.BUTTON_1)
            i.putExtra(Constants.BUTTON_1, bind.tZXC.text.toString())
            i.putExtra(Constants.BUTTON_2, "Задача 2, не задействована")
            setResult(RESULT_OK, i)
            finish()
        } else if (buttonState == Constants.BUTTON_2) {
            val i = Intent()
            i.putExtra(Constants.BUTTON_STATE, Constants.BUTTON_2)
            i.putExtra(Constants.BUTTON_2, bind.tPepega.text.toString())
            i.putExtra(Constants.BUTTON_1, "Задача 1, не задействована")
            setResult(RESULT_OK, i)
            finish()
        }
    }


}