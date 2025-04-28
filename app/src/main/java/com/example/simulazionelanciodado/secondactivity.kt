package com.example.simulazionelanciodado

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    // DICHIARAZIONE VARIABILI PER GLI ELEMENTI GRAFICI DEL LAYOUT
    private lateinit var txtResult: TextView
    private lateinit var imgDice: ImageView
    private lateinit var btnRoll: Button

    // DICHIARAZIONE VARIABILE CHE CONTERRA' NUMERO SCELTO PASSATO DALL'ALTRA ACTIVITY
    private var userNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondactivity)

        // ASSEGNAZIONE A VARIABILI DI ELEMENTI GRAFICI DELL'ACTIVITY
        txtResult = findViewById(R.id.ResultTextView)
        imgDice = findViewById(R.id.DiceImageView)
        btnRoll = findViewById(R.id.RollButton)

        // ASSEGNAZIONE DEL NUMERO SCELTO NELLA PRIMA ACTIVITY ALL'APPOSITA VARIABILE
        userNumber = intent.getIntExtra("userNumber", 0)

        // IMPOSTAZIONE DELL'IMMAGINE DEL DADO NEUTRA (dice.png)
        imgDice.setImageResource(R.drawable.dice)

        // LISTENER PER L'EVENTO DELLA PRESSIONE DEL BOTTONE
        btnRoll.setOnClickListener {

            // RICHIAMO DELLA FUNZIONE rollDice()
            rollDice()
        }
    }

    private fun rollDice() {
        val diceRoll = Random.nextInt(1, 7)

        // SCELTA DELL'IMMAGINE CORRETTA IN BASE AL NUMERO USCITO
        val diceImage = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // AGGIORNAMENTO DELL'IMMAGINE DEL DADO
        imgDice.setImageResource(diceImage)

        val resultMessage = if (diceRoll == userNumber) {
            "Hai vinto! Hai tirato un $diceRoll"
        } else {
            "Hai perso! Hai tirato un $diceRoll"
        }

        // PASSAGGIO DEL MESSAGGIO E DEL NUMERO USCITO ALLA TERZA ACTIVITY
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra("result", resultMessage)
        intent.putExtra("diceRoll", diceRoll)

        // AVVIO DELLA TERZA ACTIVITY
        startActivity(intent)
    }
}
