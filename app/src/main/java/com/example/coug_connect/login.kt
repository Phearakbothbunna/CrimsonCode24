package com.example.coug_connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.view.GravityCompat

class login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.loginButton);

        loginButton.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        val btn_createacc = findViewById<TextView>(R.id.createAccount)
        btn_createacc.setOnClickListener {
            val intent = Intent(this, registration::class.java)
            startActivity(intent)
        }
    }
}