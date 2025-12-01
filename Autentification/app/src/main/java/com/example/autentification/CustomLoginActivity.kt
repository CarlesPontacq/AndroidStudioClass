package com.example.autentification

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class CustomLoginActivity : AppCompatActivity() {
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var auth: FirebaseAuth

    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_login)

        emailField = findViewById(R.id.input_user)
        passwordField = findViewById(R.id.input_password)

        auth = FirebaseAuth.getInstance()

        findViewById<Button>(R.id.registerButton).setOnClickListener{Register()}
        findViewById<Button>(R.id.loginButton).setOnClickListener{Login()}
    }

    private fun Register(){
        val email = emailField.text.toString()
        val password = passwordField.text.toString()

        auth.createUserWithEmailAndPassword(email, password).
        addOnCompleteListener(this){ task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Error en el registro: ${task.exception?.message}", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun Login(){
        val email = emailField.text.toString()
        val password = passwordField.text.toString()

        auth.signInWithEmailAndPassword(email, password).
        addOnCompleteListener(this){ task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Error en el login: ${task.exception?.message}", Toast.LENGTH_SHORT).show()

            }
        }
    }
}