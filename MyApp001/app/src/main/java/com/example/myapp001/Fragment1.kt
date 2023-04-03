package com.example.myapp001

import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class Fragment1 : Fragment() {
    private var playMusic = false
    private var trek = 0
    private val ListMusic = ArrayList<Int>()
    private var pref: SharedPreferences? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        ListMusic.add(R.raw.leza)
        ListMusic.add(R.raw.fon_music2)
        ListMusic.add(R.raw.fon_music3)

        val view = inflater.inflate(R.layout.fragment_1, container, false)
        val bMus = view.findViewById<Button>(R.id.button)
        val tvTrek = view.findViewById<TextView>(R.id.tvTrek)
        tvTrek.text = "Играет трек № ${trek.toString()}"
        var mediaPlayer = MediaPlayer.create(context, ListMusic[trek])
        bMus.setOnClickListener {
            if (!playMusic) {
                mediaPlayer.start()
                playMusic = true
                trek += 1
                if(trek > ListMusic.size - 1) trek = 0
            }
            else {
                mediaPlayer.stop()
                playMusic = false
                mediaPlayer = MediaPlayer.create(context,ListMusic[trek])
            }
        }
        return view
    }


    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()

    }
}