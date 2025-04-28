package com.example.simulazionelanciodado

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// ACTIVITY MAIN
class MainActivity : AppCompatActivity() {


    private val TAG = "MainActivity"

    // DICHIARAZIONE VARIABILI PER GLI ELEMENTI GRAFICI DEL LAYOUT
    private lateinit var edtNumber: EditText
    private lateinit var btnSubmit: Button
    private lateinit var imgDice: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)

        // ASSEGNAZIONE A VARIABILI DI ELEMENTI GRAFICI DELL'ACTIVITY
        edtNumber = findViewById(R.id.DiceEditText)
        btnSubmit = findViewById(R.id.SubmitButton)
        imgDice = findViewById(R.id.DiceImageView)

        // IMPOSTAZIONE DELL'IMMAGINE DEL DADO NEUTRA (dice.png)
        imgDice.setImageResource(R.drawable.dice)

        // LISTENER PER L'EVENTO DELLA PRESSIONE DEL BOTTONE
        btnSubmit.setOnClickListener {
            // ASSEGNAZIONE ALLA VARIABILE DEL TESTO INSERITO
            val userInput = edtNumber.text.toString()
            // CONVERSIONE DEL TESTO INSERITO IN NUMERO
            val number = userInput.toIntOrNull()

            if (number != null && number in 1..6) {
                // CREAZIONE DELL'INTENT PER PASSARE IL TESTO ALLA SECONDA ACTIVITY
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("userNumber", number)

                //AVVIO DELLA SECONDA ACTIVITY
                startActivity(intent)
            } else {
                // MESSAGGIO DI ERRORE QUALORA L'INPUT NON SIA VALIDO
                Toast.makeText(this, "Inserisci un numero valido tra 1 e 6", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
