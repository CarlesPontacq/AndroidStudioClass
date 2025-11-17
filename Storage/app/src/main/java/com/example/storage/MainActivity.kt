package com.example.storage

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query

class MainActivity : AppCompatActivity() {
    /*private lateinit var sumText: TextView
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private  lateinit var playerPreferences: SharedPreferences*/

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*sumText = findViewById(R.id.sumText)
        addButton = findViewById(R.id.AddButton)
        subtractButton = findViewById(R.id.subtractButton)
        playerPreferences = getSharedPreferences("prefs_sum", Context.MODE_PRIVATE)

        val storedResult = playerPreferences.getInt("Resultado", 0)
        val sum = storedResult + 1

        playerPreferences.edit().putInt("Resultado", sum).apply()
        sumText.text = sum.toString()
        */

        val databaseurl = "https://appcompanionpokemontcg-default-rtdb.europe-west1.firebasedatabase.app/"
        database = FirebaseDatabase.getInstance(databaseurl).getReference("messages")
        
        /*val dataId = database.push().key

        val messageData = mapOf(
            "user" to "Jose",
            "message" to "Hello World"
        )

        if(dataId != null){
            database.child(dataId).setValue(messageData).addOnSuccessListener { result ->
                Log.d("Firebase test", "Insert correcto")
            }.addOnFailureListener { exception ->
                Log.d("Firebase test", "Error: ${exception.message}")
            }
        }
         */
        val query: Query = database.orderByChild("user").equalTo("Jose")
        query.get().addOnSuccessListener { snapShot ->
            if(snapShot.exists()){
                for(dataSnapshot in snapShot.children){
                    val message = dataSnapshot.child("message").getValue(String::class.java)
                    Log.d("Firebase test", "Message: $message")
                }
            }
            else{
                Log.d("Firebase test", "No messages found")
            }
        }.addOnFailureListener { exception->
            Log.d("Firebase test", "Error: ${exception.message}")
        }
    }
}