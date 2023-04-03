package com.example.myapp001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myapp001.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    private val listFrag = listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance(),

    )
  /*  private val listText = listOf(
        "Фото",
        "Музыка",
        "Видео",
        )*/

    private val listIcon = listOf(
        R.drawable.ic_baseline_photo_24,
        R.drawable.ic_baseline_queue_music_24,
        R.drawable.ic_baseline_music_video_24,
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
       val adapter = VpAdapter(this, listFrag)
        bind.vp2.adapter = adapter
        TabLayoutMediator(bind.tabLayout, bind.vp2) {
            tab, pos ->
            /*tab.text = listText[pos]*/
            tab.icon = ContextCompat.getDrawable(this, listIcon[pos])

        }.attach()

    }
}