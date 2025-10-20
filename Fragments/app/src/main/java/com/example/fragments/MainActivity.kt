package com.example.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    private lateinit var myToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(myToolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(item.itemId == R.id.picture){
            true
        }
        else if(item.itemId == R.id.exit){
            finish()
            true
        }
        else{
            super.onOptionsItemSelected(item)
        }
    }
}