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
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query

class MainActivity : AppCompatActivity() {
    /*private lateinit var sumText: TextView
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private  lateinit var playerPreferences: SharedPreferences*/

    private lateinit var lastMessage: TextView

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

        lastMessage = findViewById(R.id.lastMessage)

        val databaseurl = "https://appcompanionpokemontcg-default-rtdb.europe-west1.firebasedatabase.app/"
        database = FirebaseDatabase.getInstance(databaseurl).getReference("messages")

        database.addChildEventListener(createChildEventListener())
        
        /*
        val dataId = database.push().key

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
                    Log.d("Firebase test", "query Message: $message")
                }
            }
            else{
                Log.d("Firebase test", "No messages found")
            }
        }.addOnFailureListener { exception->
            Log.d("Firebase test", "Error: ${exception.message}")
        }
    }

    private fun createChildEventListener(): ChildEventListener{
        return object: ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                database.ref.get().addOnSuccessListener { fullSnapshot ->
                    for(child in fullSnapshot.children){
                        val u = child.child("user").getValue(String::class.java)
                        val m = child.child("message").getValue(String::class.java)
                        Log.d("Firebase test", "onChildAdded User: $u, Message: $m")
                    }
                }.addOnFailureListener { e ->
                    Log.d("Firebase test", "Error fetching full conellection: ${e.message}")
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                val newUser = snapshot.child("user").getValue(String::class.java)
                val newMessage = snapshot.child("message").getValue(String::class.java)

                val oldSnapshot = previousChildName?.let { database.child(it).get().result }
                val oldUser = oldSnapshot?.child("user")?.getValue(String::class.java)
                val oldMessage = oldSnapshot?.child("message")?.getValue(String::class.java)

                Log.d("Firebase test", "Changed - Old User: $oldUser, Old Message: $oldMessage")
                Log.d("Firebase test", "Changed - New User: $newUser, Old Message: $newMessage")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                val user = snapshot.child("user").getValue(String::class.java)
                val message = snapshot.child("message").getValue(String::class.java)

                Log.d("Firebase test", "Removed - User: $user, Message: $message")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                val movedKey = snapshot.key

                Log.d("Firebase test", "Moved - From: $previousChildName, To: $movedKey")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Firebase test", "Cancelled - Error: ${error.message}")
            }

        }

    }

    private fun SetLastMessage(){

    }
}