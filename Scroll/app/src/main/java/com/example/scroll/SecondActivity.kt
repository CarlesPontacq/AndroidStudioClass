package com.example.scroll

import Models.Character
import Models.CharacterAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val characters = listOf (
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
            Character("Doggo", "Good bois", R.drawable.doggos),
        )

        val recyclerView: RecyclerView = findViewById(R.id.character_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CharacterAdapter(characters)
    }
}