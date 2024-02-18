

package com.example.coug_connect

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.FirebaseDatabase
import java.util.*


object UsersDatabase {

    /*fun writeDataToDatabase() {
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
    }*/

    val database = FirebaseDatabase.getInstance()
    val usersRef = database.getReference("users")
    val organizersRef = database.getReference("organizers")
    val eventsRef = database.getReference("events")

    data class User(val name: String = "",
                        val email: String = "",
                        val password: String = "",
                        val phone: Int = 0,
                        val subscription: Map<String, Boolean> = emptyMap(),
                        val events: Map<String, Boolean> = emptyMap())

    fun populateUsers() {
        val user1 = User("John", "john@example.com", "adbcd1234", 1233, mapOf("interest1" to true, "interest2" to true), mapOf("eventId1" to true))

        val userId1 = usersRef.push().key ?: UUID.randomUUID().toString()

        usersRef.child(userId1).setValue(user1)
    }
}