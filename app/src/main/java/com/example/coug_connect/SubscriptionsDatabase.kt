package com.example.coug_connect

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object SubscriptionsDatabase {

    // List of all organizers
    data class Organizer(val Name: String = "",
                             val Tag: String = "",
                             val Subscribers: Map<String, Boolean> = emptyMap(),
                             val Events: Map<String, Boolean> = emptyMap())



    data class Events(val EventName: String = "",
                      val DateTime: Int = 0,
                      val Description: String = "",
                      val RSVP: Boolean = false) // YES / NO



    fun writeDataToDatabase() {
        val database = Firebase.database
        val myRef = database.getReference("Subscriptions") // Assume "Subscriptions" as the main node

        // Example of writing data to the database
        val organizerName = "Organizer" // Unique organizer ID
        val variab = Organizer(
            Name = "Wazzu Racing",
            Tag = "racing",
            Subscribers = mapOf("subscriber1" to true, "subscriber2" to false), // Example subscribers
            Events = mapOf("event1" to true, "event2" to true) // Example events
        )

        myRef.child(organizerName).setValue(variab)
    }


}