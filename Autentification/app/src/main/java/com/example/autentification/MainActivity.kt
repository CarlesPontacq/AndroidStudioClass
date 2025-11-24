package com.example.autentification

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException



class MainActivity : AppCompatActivity() {
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //findViewById<SignInButton>(R.id.btn_login_google).setOnClickListener{ signIn() }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("743427009820-9s0bc4joig8h05pt9f0qlev5g7tveu1c.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val account = GoogleSignIn.getLastSignedInAccount(this)

        account?.let {
            Log.d("Login Google", "Ya se ha robado la información de: " + account.displayName + " anteriormente")
        } ?: run {
            Log.d("Login Google", "No hay sesion iniciado")
            findViewById<SignInButton>(R.id.btn_login_google).setOnClickListener{ signIn() }
        }

        /*googleSignInClient.signOut().addOnCompleteListener(this){

        }*/

    }
    private fun signIn(){
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, 9001)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 9001){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            if(task.isSuccessful){
                val account = task.getResult(ApiException::class.java)
                Log.d("Login Google", "Tengo la informacion de: " + account.displayName)
            }
            else{
                Log.d("Login Google", "Error " + task.exception)
            }
        }
    }
}