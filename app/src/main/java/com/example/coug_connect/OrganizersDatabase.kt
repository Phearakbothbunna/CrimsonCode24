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
        val organizerName = "RacingClub"
        val organizer1 = Organizer(
            "Alice",
            "alice@example.com",
            mapOf("interest1" to true, "interest2" to false),
            mapOf("userId1" to true)
        )

        val organizerId1 = organizersRef.push().key ?: UUID.randomUUID().toString()

        organizersRef.child(organizerId1).setValue(organizer1)
    }

}