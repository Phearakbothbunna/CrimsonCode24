package com.example.coug_connect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coug_connect.ui.theme.CougConnectTheme

import com.google.firebase.FirebaseApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        FirebaseApp.initializeApp(this)
        UsersDatabase.populateUsers()
        OrganizersDatabase.populateOrganizers()
        EventsDatabase.populateEvents()
//        setContent {
//            CougConnectTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                    // Write a message to the database
////                    val database = Firebase.database
////                    val myRef = database.getReference("message")
//                    val username = ""
//                    val email = ""
//                    val password = ""
//                    val phone = ""
//                    UsersDatabase.writeDataToDatabase(username, email, password, phone)
//                    SubscriptionsDatabase.writeOrganizerDataToDatabase()
//                    SubscriptionsDatabase.writeEventsDataToDatabase()
//
//                }
//            }
//        }

    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            CougConnectTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                }
//            }
//        }
//    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//            text = "Hello $name!",
//            modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CougConnectTheme {
//        Greeting("Android")
//    }

//}



