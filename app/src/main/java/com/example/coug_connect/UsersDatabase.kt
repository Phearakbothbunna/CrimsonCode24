

package com.example.coug_connect

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


object UsersDatabase {
    val database = Firebase.database
    val usersRef = database.getReference("users") // Assume "users" as the main node
    fun writeDataToDatabase(name: String, email: String, password: String, phone: String){

        val uid = FirebaseAuth.getInstance().currentUser!!.uid


        val userData = UserData(name, email, phone)
        usersRef.child(uid).setValue(userData)


        usersRef.child(name).setValue(userData)
    }


    data class UserData(val name: String,
                        val email: String,
                        val password: String,
                        val phone: Int = 0,
                        val subscription: Map<String, Boolean> = emptyMap())
}