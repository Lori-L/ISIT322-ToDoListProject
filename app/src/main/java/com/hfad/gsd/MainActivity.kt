package com.hfad.gsd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    
    fun apiMain () :List<List<Double>>{
        var api = ApiHandler()
        var qString = api.generateQueryString("atm")
        val reqQueue: RequestQueue = Volley.newRequestQueue(this)
        var request = api.generateAPIRequest(qString)
        reqQueue.add(request)
        return api.returnCoordsList()
    }
}
