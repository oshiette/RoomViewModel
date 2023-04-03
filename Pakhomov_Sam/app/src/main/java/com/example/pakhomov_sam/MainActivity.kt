package com.example.pakhomov_sam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.pakhomov_sam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            var buttonState = "b"
            if (result.resultCode == RESULT_OK) {
                buttonState = result.data?.getStringExtra(Constants.BUTTON_STATE)!!

                var text: String = " "
                if (buttonState == Constants.BUTTON_1) {
                    text = result.data?.getStringExtra(Constants.BUTTON_1)!!

                } else if (buttonState == Constants.BUTTON_2) {
                    text = result.data?.getStringExtra(Constants.BUTTON_2)!!

                }
            }
        }
    }

    fun onClickTask1(view: View) {
        val iNt = Intent(this, SecondActivity::class.java)
        iNt.putExtra(Constants.BUTTON_STATE, Constants.BUTTON_1)
        //startActivity(iNt)
        launcher?.launch(iNt)
    }

    fun onClickTask2(view: View) {
        val iNt = Intent(this, SecondActivity::class.java)
        iNt.putExtra(Constants.BUTTON_STATE, Constants.BUTTON_2)
        //startActivity(iNt)
        launcher?.launch(iNt)
    }
}