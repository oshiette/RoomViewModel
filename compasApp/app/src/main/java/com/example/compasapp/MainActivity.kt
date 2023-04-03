package com.example.compasapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.example.compasapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var bind:ActivityMainBinding
    var manager: SensorManager? = null
    var cur_deegre: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onPause() {
        super.onPause()
        manager?.unregisterListener(this)
    }

    override fun onResume() {
        super.onResume()
        manager?.registerListener(this,
        manager?.getDefaultSensor(Sensor.TYPE_ORIENTATION),
        SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val deegre: Int = event?.values?.get(0)?.toInt()!!
        bind.tvDegree.text = deegre.toString()
        val rotateAnim = RotateAnimation(
            cur_deegre.toFloat(),(-deegre).toFloat(),
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnim.duration = 210
        rotateAnim.fillAfter = true
        cur_deegre = -deegre
        bind.imDynamic.startAnimation((rotateAnim))
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}