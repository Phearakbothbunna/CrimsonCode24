package com.example.coug_connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.view.GravityCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class login : ComponentActivity() {
    private lateinit var db: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        db = FirebaseDatabase.getInstance()

        val loginButton = findViewById<Button>(R.id.loginButton);
        val btn_createacc = findViewById<TextView>(R.id.createAccount)

//      For the username & password input field
        val enterUsername =  findViewById<EditText>(R.id.enterUsername)
        val password = findViewById<EditText>(R.id.password)


        btn_createacc.setOnClickListener{
            val intent = Intent(this, registration::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val email = enterUsername.text.toString()
            val password = password.text.toString()

            db.getReference("users").child(email.replace(".", ","))
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val dbPassword = dataSnapshot.child("password").getValue(String::class.java)
                        if (dbPassword == password) {
                            // Successfully signed in
                            val intent = Intent(this@login, HomePage::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                baseContext, "Authentication failed. Please try again",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        Toast.makeText(
                            baseContext, "Error getting the data",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }
    }
}