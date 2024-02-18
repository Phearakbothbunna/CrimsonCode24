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
            "EsportsClub",
            mapOf("interest1" to true, "interest2" to true),
            mapOf("userId1" to true)
        )

        //val eventId1 = eventsRef.push().key ?: UUID.randomUUID().toString()

        eventsRef.child("EsportsClub1").setValue(event1)

        val event2 = Event(
            "Mario Kart Tournament",
            "Race Little Creatures for Money!",
            "2024-02-23",
            "Room 102",
            "EsportsClub",
            mapOf("interest1" to true, "interest2" to true),
            mapOf("userId1" to true)
        )

        //val eventId1 = eventsRef.push().key ?: UUID.randomUUID().toString()

        eventsRef.child("EsportsClub2").setValue(event2)

        val event3 = Event(
            "Learn how to hit and run",
            "Practice with live peoople!",
            "2024-07-05",
            "Room 103",
            "RacingClubClub",
            mapOf("interest1" to true, "interest2" to true),
            mapOf("userId1" to true)
        )

        //val eventId1 = eventsRef.push().key ?: UUID.randomUUID().toString()

        eventsRef.child("RacingClub1").setValue(event3)

        val event4 = Event(
            "Why breaking your laptop can help you de-stress",
            "Bring your own laptops!",
            "2024-02-24",
            "Room 104",
            "CrimsonServiceDesk",
            mapOf("interest1" to true, "interest2" to true),
            mapOf("userId1" to true)
        )

        //val eventId1 = eventsRef.push().key ?: UUID.randomUUID().toString()

        eventsRef.child("CrimsonServiceDesk1").setValue(event4)

        val event5 = Event(
            "Workshop on Mobile App Development",
            "Learn how to build mobile apps with Firebase!",
            "2024-02-25",
            "Room 105",
            "JackAllClub",
            mapOf("interest1" to true, "interest2" to true),
            mapOf("userId1" to true)
        )

        //val eventId1 = eventsRef.push().key ?: UUID.randomUUID().toString()

        eventsRef.child("JackAllClub1").setValue(event5)

        val event6 = Event(
            "Workshop on we should all learn Khmer",
            "Barely anyone speaks it so it is getting sad at this point!",
            "2024-02-26",
            "Room 106",
            "InternationalCenter",
            mapOf("interest1" to true, "interest2" to true),
            mapOf("userId1" to true)
        )

        //val eventId1 = eventsRef.push().key ?: UUID.randomUUID().toString()

        eventsRef.child("InternationalCenter").setValue(event6)
    }

}