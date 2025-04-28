package com.example.simulazionelanciodado

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    // DICHIARAZIONE VARIABILI PER GLI ELEMENTI GRAFICI DEL LAYOUT
    private lateinit var txtFinalResult: TextView
    private lateinit var imgDiceFinal: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thirdactivity)

        // ASSEGNAZIONE A VARIABILI DI ELEMENTI GRAFICI DELL'ACTIVITY
        txtFinalResult = findViewById(R.id.FinalResultTextView)
        imgDiceFinal = findViewById(R.id.DiceImageViewFinal)

        // ASSEGNAZIONE DEL NUMERO SCELTO E DEL RISULTATO ALLE APPOSITE VARIABILI
        val resultMessage = intent.getStringExtra("result")
        val diceRoll = intent.getIntExtra("diceRoll", 0)

        // MOSTRARE IL TESTO CON RISULTATO
        txtFinalResult.text = resultMessage

        // MOSTRARE L'IMMAGINE DEL DADO CORRISPONDENTE
        val diceImage = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice // di default se qualcosa va storto
        }

        imgDiceFinal.setImageResource(diceImage)
    }
}
