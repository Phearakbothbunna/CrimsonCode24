package com.example.coug_connect

class organizations_model {
    var orgName: String = ""
    var orgCategory1: String = ""
    var orgCategory2: String = ""
    var orgPFP: Int = 0

    constructor(orgName: String, orgCategory1: String, orgCategory2: String, orgPFP: Int) {
        this.orgName = orgName
        this.orgCategory1 = orgCategory1
        this.orgCategory2 = orgCategory2
        this.orgPFP = orgPFP
    }
}