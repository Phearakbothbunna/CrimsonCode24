package com.example.coug_connect

import com.google.firebase.database.FirebaseDatabase
import java.util.*

object EventsDatabase {

    val database = FirebaseDatabase.getInstance()
    val eventsRef = database.getReference("events")

    data class Event(
        val title: String = "",
        val description: String = "",
        val date: String = "",
        val location: String = "",
        val organizerId: String = "",
        val interests: Map<String, Boolean> = emptyMap(),
        val attendees: Map<String, Boolean> = emptyMap()
    )

    fun populateEvents() {
        val event1 = Event(
            "Workshop on Mobile App Development",
            "Learn how to build mobile apps with Firebase!",
            "2024-02-20",
            "Room 101",
            "organizerId1",
            mapOf("interest1" to true, "interest2" to true),
            mapOf("userId1" to true)
        )

        val eventId1 = eventsRef.push().key ?: UUID.randomUUID().toString()

        eventsRef.child(eventId1).setValue(event1)
    }

}