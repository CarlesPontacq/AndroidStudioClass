package com.example.firstui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {

    private lateinit var player1Button: Button
    private lateinit var player2Button: Button
    private lateinit var text: TextView

    private var minScore: Int = 0
    private var score: Int = 10
    private var maxScore: Int = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        player1Button = findViewById(R.id.player1Button)
        player2Button = findViewById(R.id.player2Button)
        text = findViewById(R.id.gameText)
        text.text = score.toString()
        player1Button.setOnClickListener{onPlayer1ButtonClick()}
        player2Button.setOnClickListener{onPlayer2ButtonClick()}
    }

    private fun onPlayer1ButtonClick(){
        score++
        text.text = score.toString()
       CheckScore()
    }

    private fun onPlayer2ButtonClick(){
        score--
        text.text = score.toString()
        CheckScore()
    }

    private fun CheckScore(){
        if(score >= maxScore){
            player1Button.isEnabled = false
            player2Button.isEnabled = false
            text.text = "Ha ganado jugador 1"
        }
        else if(score <= minScore){
            player1Button.isEnabled = false
            player2Button.isEnabled = false
            text.text = "Ha ganado jugador 2"
        }
    }
}