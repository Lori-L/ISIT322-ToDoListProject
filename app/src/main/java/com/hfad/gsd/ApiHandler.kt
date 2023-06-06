package com.hfad.gsd

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class ApiHandler : AppCompatActivity() {
    //all names changed to lowercase
    val locationNames = listOf("atm", "bookstore", "cinema", "convenience store", "department store", "gas station", "library", "park", "pharmacy", "post office")
    //ID numbers correspond to location names
    val locationIds = listOf(3578, 9995, 7832, 9535, 9545, 5540, 8231, 7947, 9565, 9530)
    //List that will contain the returned values
    var coordsList = mutableListOf<List<Double>>()

    //1. takes in a location name
    //2. identifies the location's ID in the API
    //3. collects the device's latitude/longitude coordinates from the GpsHandler
    //4. creates the API query string and sends query
    //5. receives API response
    //6. extracts all qualifying locations' latitude and longitude coordinates
    //7. returns list of coordinates

    fun qualifyingLocationsQuery(chosenLocation: String) : List<List<Double>>  {
        //1. takes in a location name
        //2. identifies the location's ID in the API
        val chosenLocationIndex = locationNames.indexOf(chosenLocation)
        val chosenLocationId = locationIds[chosenLocationIndex]

        //3. collects the device's latitude/longitude coordinates from the GpsHandler
        //may need to be replaced with a fixed set of coordinates until the GPS class is properly tested
        var gps = GpsHandler()
        val currentCoords = listOf(gps.latitude, gps.longitude)

        //4. creates the API query string and sends query
        val queryString = "https://spatial.virtualearth.net/REST/v1/data/Microsoft/PointsOfInterest?spatialFilter=nearby(${currentCoords[0].toString()},${currentCoords[1].toString()},1)&${'$'}filter=EntityTypeID%20eq%20%27$chosenLocationId%27&${'$'}select=EntityID,DisplayName,Latitude,Longitude,__Distance&${'$'}top=3&${'$'}format=json&key=AvGwd4j6II6ftFMSrxPBEjviEJSckGifQj_vxRQeqgp1x6SlaPuPMcMSHgAMB02w"

        val reqQueue: RequestQueue = Volley.newRequestQueue(this)

        //5. receives API response
        val request = JsonObjectRequest(Request.Method.GET,queryString, null, { res ->
            Log.d("Volley Sample", res.getJSONArray("data").toString())

            //6. extracts all qualifying locations' latitude and longitude coordinates
            val jsonArray = res.getJSONArray("data")
            for (i in 0 until jsonArray.length()){
                val jsonObj = jsonArray.getJSONObject(i)

                val coords = mutableListOf<Double>()
                coords[0] = jsonObj.getDouble("Latitude")
                coords[1] = jsonObj.getDouble("Longitude")

                coordsList.add(coords)
            }

        }, {err ->
            Log.d("Volley Sample Fail", err.message.toString())
        })

        reqQueue.add(request)


        //7. returns list of coordinates
        return coordsList
    }
}
