package com.hfad.gsd

import android.util.Log
import org.junit.Test

import org.junit.Assert.*

class GpsHandlerUnitTests {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun GPS1() {
        println("start")
        var gps = GpsHandler()
        println(gps.latitude.toString() + " " + gps.longitude.toString())
        assertNull(gps.latitude)
    }
}
