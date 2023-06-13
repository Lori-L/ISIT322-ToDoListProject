package com.hfad.gsd

import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import com.hfad.gsd.MainFragment

//NOTE: ALL TESTS THROW A NULLPOINTEREXCEPTION ONCE THE APIHANDLER OBJECT IS CREATED
// THIS IS DUE TO THE APIHANDLER CLASS EXTENDING APPCOMPATACTIVITY()
// I DO NOT KNOW HOW TO ALLOW THIS CLASS TO FULFILL ITS PURPOSE WITHOUT HAVING THAT EXTENSION
// I DO NOT KNOW HOW TO TEST THIS CLASS WHILE IT HAS THAT EXTENSION
// THE SAME ISSUE APPLIES TO THE GPSHANDLER TESTS
class ApiHandlerUnitTests {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testing_assertstring() {
        var t = testing()
        assertEquals("abcdefg", t.testString)
    }

    @Test
    fun generateQueryString_SHALL_ReturnValidQueryString() {
        var api = ApiHandler()
        var queryString = api.generateQueryString("atm")
        assertEquals("https://spatial.virtualearth.net/REST/v1/data/Microsoft/PointsOfInterest?spatialFilter=nearby(40.83274904439099,-74.31632995605469,5)&${'$'}filter=EntityTypeID%20eq%20%273578%27&${'$'}select=EntityID,DisplayName,Latitude,Longitude,__Distance&${'$'}top=3&${'$'}format=json&key=AvGwd4j6II6ftFMSrxPBEjviEJSckGifQj_vxRQeqgp1x6SlaPuPMcMSHgAMB02w",
         queryString)
    }

//    @Test
//    fun generateAPIRequest_SHALL_() {
//        var api = ApiHandler()
//        var queryString = api.generateQueryString("atm")
//        var APIRequest = api.generateAPIRequest(queryString)
//        assertEquals( "[]", APIRequest)
//    }

    @Test
    fun generateQueryString_SHALL_() {
        var main = MainActivity()
        var list = main.apiMain()
        assertEquals("[]", list)
    }
}
