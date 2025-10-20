package com.example.navigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var CambioEscena: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CambioEscena = findViewById(R.id.button2)
        CambioEscena.setOnClickListener{onButtonClick()}
    }

    private fun onButtonClick() {
        val intent = Intent(this, SecondActivity::class.java);
        val message = "Hello from Main Activity"
        intent.putExtra("Greetings", message)
        startActivity(intent);
    }
}