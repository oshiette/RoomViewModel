package com.example.signapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.core.view.isVisible
import com.example.signapp.constants.Constants
import com.example.signapp.databinding.ActivitySignInUpBinding

class SignInUpActivity : AppCompatActivity() {
    lateinit var bind: ActivitySignInUpBinding

    public var signState = "a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySignInUpBinding.inflate(layoutInflater)
        setContentView(bind.root)

        supportActionBar?.hide()

        signState = intent.getStringExtra(Constants.SIGN_STATE)!!
        Log.d("AppLog", "$signState")
        if (signState == Constants.SIGN_UP_STATE) {
            bind.bAvatar.visibility = View.VISIBLE
            bind.edMail.visibility = View.VISIBLE
            bind.edName.visibility = View.VISIBLE
        }
        bind.bDone.setOnClickListener(this::onClickDone)
        bind.bAvatar.setOnClickListener(this::onClickAvatar)

    }

    fun onClickDone(view: View) {
        if (signState == Constants.SIGN_UP_STATE) {

            val i = Intent()
            i.putExtra(Constants.LOGIN, bind.edLogin.text.toString())
            i.putExtra(Constants.PASSWORD, bind.edPassword.text.toString())
            i.putExtra(Constants.NAME, bind.edLogin.text.toString())
            i.putExtra(Constants.EMAIL, bind.edLogin.text.toString())
            i.putExtra(Constants.SIGN_STATE, Constants.SIGN_UP_STATE)
            if(bind.Avatar2.isVisible) i.putExtra(Constants.AVATAR_ID, R.drawable.kuro)
            setResult(RESULT_OK, i)
            finish()
        } else if (signState == Constants.SIGN_IN_STATE) {
            intent.putExtra(Constants.LOGIN, bind.edLogin.text.toString())
            intent.putExtra(Constants.PASSWORD, bind.edPassword.text.toString())
            intent.putExtra(Constants.SIGN_STATE, Constants.SIGN_IN_STATE)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
    fun onClickAvatar(view: View){
        bind.Avatar2.visibility = View.VISIBLE
    }
}