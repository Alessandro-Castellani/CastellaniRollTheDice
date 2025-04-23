package com.example.simulazionelanciodado

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Imposta il layout della seconda schermata
        setContentView(R.layout.secondactivity)

        // Riceve il numero passato da MainActivity
        val message = intent.getStringExtra("numero")

        // Mostra il numero in un TextView
        val txtSecond = findViewById<TextView>(R.id.idSecondText)
        txtSecond.text = "Hai tirato un $message"
    }
}