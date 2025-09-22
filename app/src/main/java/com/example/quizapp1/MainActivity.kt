package com.example.quizapp1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los botones
        val trueButton: Button = findViewById(R.id.trueButton)
        val falseButton: Button = findViewById(R.id.falseButton)

        // Evento onClick para el botón True
        trueButton.setOnClickListener {
            // Mostrar Toast cuando se presiona True
            Toast.makeText(
                this,
                getString(R.string.correct_answer),
                Toast.LENGTH_SHORT
            ).show()
        }

        // Evento onClick para el botón False
        falseButton.setOnClickListener {
            // Mostrar Toast cuando se presiona False
            Toast.makeText(
                this,
                getString(R.string.incorrect_answer),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}