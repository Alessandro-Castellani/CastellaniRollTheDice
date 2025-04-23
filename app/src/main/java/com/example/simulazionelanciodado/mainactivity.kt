package com.example.simulazionelanciodado

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // TAG per il log
    private val TAG = "MainActivity"

    // Variabili per i componenti grafici
    private lateinit var txtNumber: TextView
    private lateinit var imgDice: ImageView
    private lateinit var btnRoll: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Abilita l’uso dell’interfaccia edge-to-edge (facoltativo)
        enableEdgeToEdge()

        // Imposta il layout dell'activity
        setContentView(R.layout.mainactivity)
        Log.d(TAG, "Layout caricato correttamente")

        // Collega gli elementi grafici ai rispettivi ID del layout XML
        txtNumber = findViewById(R.id.DiceTextView)
        imgDice = findViewById(R.id.DiceImageView)
        btnRoll = findViewById(R.id.DiceButtonView)

        // Imposta il comportamento del pulsante
        btnRoll.setOnClickListener {
            Toast.makeText(applicationContext, "Gioca con noi!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    // Funzione per simulare il lancio del dado
    private fun rollDice() {
        Log.d(TAG, "Lancio del dado in corso...")

        // Genera un numero casuale tra 1 e 6
        val randomNumber = (1..6).random()
        Log.d(TAG, "Numero ottenuto: $randomNumber")

        // Mostra il numero nel TextView
        txtNumber.text = randomNumber.toString()

        // Cambia l'immagine del dado in base al numero ottenuto
        val diceImage = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Imposta l'immagine del dado
        imgDice.setImageResource(diceImage)

        // Crea un Intent per aprire la SecondActivity
        val intent = Intent(this, SecondActivity::class.java)
        // Passa il numero ottenuto all'altra activity
        intent.putExtra("numero", randomNumber.toString())
        startActivity(intent)
    }

    // Funzione alternativa per mostrare un messaggio (non usata)
    fun showMessage(view: View) {
        Log.d(TAG, "Messaggio Toast visualizzato")
        Toast.makeText(applicationContext, "Try again!", Toast.LENGTH_LONG).show()
    }
}
