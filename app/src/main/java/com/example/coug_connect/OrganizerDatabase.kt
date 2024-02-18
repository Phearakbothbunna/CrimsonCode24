package com.example.coug_connect

import com.google.firebase.database.FirebaseDatabase
import java.util.UUID

object OrganizersDatabase {
    val database = FirebaseDatabase.getInstance()
    val organizersRef = database.getReference("organizers")

    data class Organizer(
        val name: String = "",
        val email: String = "",
        val interests: Map<String, Boolean> = emptyMap(),
        val subscribers: Map<String, Boolean> = emptyMap()
    )

    fun populateOrganizers() {
        val organizer1 = Organizer(
            "Lalite",
            "Lalite@example.com",
            mapOf("interest1" to false, "interest2" to false),
            mapOf("userId1" to true)
        )

        //val organizerId1 = organizersRef.push().key ?: UUID.randomUUID().toString()

        organizersRef.child("EsportsClub").setValue(organizer1)

        val organizer2 = Organizer(
            "Alice",
            "Alice@example.com",
            mapOf("interest1" to true, "interest2" to false),
            mapOf("userId1" to true)
        )

        //val organizerId1 = organizersRef.push().key ?: UUID.randomUUID().toString()

        organizersRef.child("RacingClub").setValue(organizer2)

        val organizer3 = Organizer(
            "Bunna",
            "Bunna@example.com",
            mapOf("interest1" to false, "interest2" to true),
            mapOf("userId1" to true)
        )

        //val organizerId1 = organizersRef.push().key ?: UUID.randomUUID().toString()

        organizersRef.child("CrimsonServiceDesk").setValue(organizer3)

        val organizer4 = Organizer(
            "Agoosh",
            "Agoosh@example.com",
            mapOf("interest1" to true, "interest2" to true),
            mapOf("userId1" to true)
        )

        //val organizerId1 = organizersRef.push().key ?: UUID.randomUUID().toString()

        organizersRef.child("JackAllClub").setValue(organizer4)

        val organizer5 = Organizer(
            "Quyen",
            "Quyen@example.com",
            mapOf("interest1" to true, "interest2" to true),
            mapOf("userId1" to true)
        )

        //val organizerId1 = organizersRef.push().key ?: UUID.randomUUID().toString()

        organizersRef.child("InternationalCenter").setValue(organizer5)
    }

}