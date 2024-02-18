

package com.example.coug_connect

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


object UsersDatabase {
    val database = Firebase.database
    val usersRef = database.getReference("users") // Assume "users" as the main node
    fun writeDataToDatabase(name: String, email: String, password: String, phone: String){

        val uid = FirebaseAuth.getInstance().currentUser!!.uid


        val userData = User(name, email, phone)
        usersRef.child(uid).setValue(userData)


        usersRef.child(name).setValue(userData)
    }


    data class User(val name: String = "",
                    val email: String = "",
                    val password: String = "",
                    val phone: Int = 0,
                    val subscription: Map<String, Boolean> = emptyMap(),
                    val events: Map<String, Boolean> = emptyMap())

    fun populateUsers() {
        val user1 = User("John", "john@example.com", "adbcd1234", 1233, mapOf("interest1" to true, "interest2" to true), mapOf("eventId1" to true))

        //val userId1 = usersRef.push().key ?: UUID.randomUUID().toString()

        usersRef.child("John").setValue(user1)

        val user2 = User("Aditya", "aditya@example.com", "adbcd1234", 1233, mapOf("interest1" to true, "interest2" to true), mapOf("eventId1" to true))

        //val userId1 = usersRef.push().key ?: UUID.randomUUID().toString()

        usersRef.child("Aditya").setValue(user2)

        val user3 = User("Both", "both@example.com", "adbcd1234", 1233, mapOf("interest1" to true, "interest2" to true), mapOf("eventId1" to true))

        //val userId1 = usersRef.push().key ?: UUID.randomUUID().toString()

        usersRef.child("Both").setValue(user1)

    }

}