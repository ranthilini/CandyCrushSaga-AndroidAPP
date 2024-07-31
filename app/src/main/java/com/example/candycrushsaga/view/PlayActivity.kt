package com.example.candycrushsaga.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.candycrushsaga.MainActivity
import com.example.candycrushsaga.R

class PlayActivity : AppCompatActivity() {
    private lateinit var playBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)


        val action = supportActionBar
        action?.hide()

        playBtn = findViewById(R.id.playBtn)

        playBtn.setOnClickListener{
            startActivity(Intent(this@PlayActivity,MainActivity::class.java))
        }




    }
}