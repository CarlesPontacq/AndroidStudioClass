package com.example.analytics

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {

    private lateinit var analytics: FirebaseAnalytics
    private lateinit var crashButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        analytics = FirebaseAnalytics.getInstance(this)

        val bundle = Bundle().apply {
            putString("portrait_orientation", (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT).toString())
        }

        crashButton = findViewById(R.id.crashButton)
        crashButton.setOnClickListener{onButtonClick()}



        analytics.logEvent("MyFirstEvent", null)
    }

    private fun onButtonClick(){
        throw RuntimeException("Mensaje")
    }
}