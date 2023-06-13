package com.hfad.gsd

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class GpsHandler : AppCompatActivity(), LocationListener{
    private var locationManager: LocationManager? = null
    public var latitude: Double? = null
    public var longitude: Double? = null

    fun start() {
        Log.d("GPSHandler", "OnCreate Called")
        locationManager = getSystemService(AppCompatActivity.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_REQUEST_CODE
            )
        } else {
            startLocationUpdates()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationUpdates()
            } else {
                // Permission denied, handle accordingly
            }
        }
    }

    private fun startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 10f, this)
        }
    }

    override fun onLocationChanged(location: Location) {
        latitude = location.latitude
        longitude = location.longitude
        Log.d("GPSHandler", "LocationChanged (Lat: $latitude, Long: $longitude)")
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 1
    }
}
