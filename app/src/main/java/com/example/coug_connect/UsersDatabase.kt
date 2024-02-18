

package com.example.coug_connect

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


object UsersDatabase {

    fun writeDataToDatabase() {
        val database = Firebase.database
        val myRef = database.getReference("users") // Assume "users" as the main node

        // Example of writing data to the database
        val userName = "Username" // Unique user ID
        val userData = UserData(
            name = "John Doe",
            email = "johndoe@example.com",
            password = "password123", // Example password
            phone = 1234567890, // Example phone number
            subscription = mapOf("organization1" to true, "organization2" to false) // Example subscriptions
        )
        myRef.child(userName).setValue(userData)
    }


    data class UserData(val name: String = "",
                        val email: String = "",
                        val password: String = "",
                        val phone: Int = 0,
                        val subscription: Map<String, Boolean> = emptyMap())
}