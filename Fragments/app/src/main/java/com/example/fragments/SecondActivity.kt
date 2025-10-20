package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {

    private lateinit var  bottomNavigationBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        bottomNavigationBar = findViewById(R.id.navbar)

        bottomNavigationBar.setOnItemSelectedListener {item -> HandleNavigationItemSelected(item.itemId)}

        loadFragment(HomeFragment())
    }
    private fun HandleNavigationItemSelected(itemId: Int): Boolean{
        return  when (itemId){
            R.id.home -> {
                loadFragment(HomeFragment())
                true
            }
            R.id.profile -> {
                loadFragment(profileFragment())
                true
            }
            R.id.settings -> {
                true
            }
            else -> false
        }
    }


    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }
}