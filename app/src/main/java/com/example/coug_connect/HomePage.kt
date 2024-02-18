package com.example.coug_connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Organization
import androidx.activity.ComponentActivity
import androidx.drawerlayout.widget.DrawerLayout;
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.GravityCompat

class HomePage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout);
        val btn_menu = findViewById<ImageView>(R.id.btn_menu);
        val btn_profile = findViewById<ImageButton>(R.id.btn_profile);

        btn_menu.setOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START);
        }

        btn_profile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val OrgButton = findViewById<Button>(R.id.btn_org);

        OrgButton.setOnClickListener {
            val intent = Intent(this, OrganizationsActivity::class.java)
            startActivity(intent)
        }



    }
}