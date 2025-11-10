package com.example.analytics

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {

    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        analytics = FirebaseAnalytics.getInstance(this)

        val bundle = Bundle().apply {
            putString("portrait_orientation", (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT).toString())
        }



        analytics.logEvent("MyFirstEvent", null)

        val crashArray = intArrayOf(1, 2)
        crashArray[2]
    }
}