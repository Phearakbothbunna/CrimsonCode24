package com.example.coug_connect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.core.UserData
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class registration : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val btn_have_acc = findViewById<TextView>(R.id.btn_have_acc)

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.Password)
        val nameEditText = findViewById<EditText>(R.id.lastName)
        val phoneEditText = findViewById<EditText>(R.id.phoneNumber)

        val registerButton = findViewById<Button>(R.id.registerButton)

        btn_have_acc.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val name = nameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val phone = phoneEditText.text.toString()


            // Proceed with user registration
            registerUser(email, name, password, phone)
//            val intent = Intent(this, login::class.java)
//            startActivity(intent)
        }
    }

//    private fun registerUser(name: String, email: String, password: String, phone: String) {
//        // Create user with email and password
//            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    // User registration successful
//                    // Write user data to the database
//                    UsersDatabase.writeDataToDatabase(name, email, password, phone)
//                    val intent = Intent(this, login::class.java)
//                    startActivity(intent)
//
////                    val userData = UsersDatabase.UserData(
////                        name = name,
////                        email = email,
////                        password = password, // Store passwords securely, e.g., with hashing
////                        phone = phone.toInt(), // Ensure proper phone number format
////                        subscription = mapOf(
////                            "organization1" to true,
////                            "organization2" to false
////                        ) // Update subscriptions as needed
////                    )
////                    myRef.child(userId!!).setValue(userData) // Write user data with push() key
////                        .addOnSuccessListener {
////                            // User data written successfully
////                            val intent = Intent(this, login::class.java)
////                            startActivity(intent)
////                        }
////                        .addOnFailureListener { exception ->
////                            // Handle data writing error
////                            // ...
////                        }
////                } else {
////                    // Handle registration failure
////                    // ...
////                }
//
//                }
//            }
//    }


    private fun registerUser(name: String, email: String, password: String, phone: String) {
        // Start a coroutine
        CoroutineScope(Dispatchers.Main).launch {
            try {
                // Create user with email and password asynchronously
                val authResult = withContext(Dispatchers.IO) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).await()
                }

                // User registration successful
                // Write user data to the database
                UsersDatabase.writeDataToDatabase(name, email, password, phone)
                val intent = Intent(this@registerUser, login::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                // Handle unsuccessful registration
                Toast.makeText(this@registerUser, "Registration failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
