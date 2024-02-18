package com.example.coug_connect

import OrgListAdapter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrganizationsActivity : ComponentActivity() {
    private val orgList: ArrayList<organizations_model> = ArrayList<organizations_model>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizations)
        val recycView = findViewById<RecyclerView>(R.id.orgRecycView)
        setUpOrganizations()
        val adapter = OrgListAdapter(this, orgList)
        recycView.adapter = adapter
        recycView.layoutManager = LinearLayoutManager(this)
    }

    private fun setUpOrganizations() {
        val myDummyOrgList = resources.getStringArray(R.array.my_dummy_org_list)
        val orgImage = R.drawable.newimage
        for (i in myDummyOrgList.indices) {
            orgList.add(organizations_model(myDummyOrgList[i], "type1", "type2", orgImage))
        }
    }
}
