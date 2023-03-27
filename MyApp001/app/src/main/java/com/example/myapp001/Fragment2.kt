package com.example.myapp001

import android.media.MediaPlayer
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapp001.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    lateinit var bind: Fragment2Binding

    private var playMusic = false
    private var pause = true
    private var trek = 0
    private val ListMusic = ArrayList<Int>()
    private val ListNameMusic = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        ListMusic.add(R.raw.leza)
        ListMusic.add(R.raw.fon_music2)
        ListMusic.add(R.raw.fon_music3)

        ListNameMusic.add("Trek 1")
        ListNameMusic.add("Trek 2")
        ListNameMusic.add("Trek 3")
        var mediaPlayer = MediaPlayer()
        mediaPlayer = MediaPlayer.create(context,ListMusic[0])
        bind = Fragment2Binding.inflate(inflater, container, false)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, ListNameMusic)
        bind.listv.adapter = adapter
        bind.listv.setOnItemClickListener { parent, view, position, id ->
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(context,ListMusic[position])
            mediaPlayer.start()
            playMusic = true
            Toast.makeText(requireContext(), "Играет трек ${ListNameMusic[position]}", Toast.LENGTH_LONG).show()
        }
        bind.button2.setOnClickListener {
            if (!playMusic) {
                mediaPlayer.start()
                playMusic = true
            } else {
                mediaPlayer.pause()
                playMusic = false
            }
        }
           return bind.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment2()

    }
}