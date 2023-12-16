package com.example.nearest_offer

import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.io.IOException
import java.util.*
import kotlin.collections.HashMap

class popnotify : AppCompatActivity() {
    val MY_PREFS_NAME = "MyPrefsFile"

    val key:Int?=null
    var theno:Int?=null
    var lat: String? = null
    var log: String? = null
    var address: String? =null
    var fusedLocationProviderClient: FusedLocationProviderClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popnotify)

        getlocation()

    }

    private fun getlocation() {


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                101
            )
            return
        }

        fusedLocationProviderClient!!.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                val geocoder = Geocoder(this@popnotify, Locale.getDefault())
                try {
                    val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)


                    lat = addresses[0].latitude.toString()
                    log = addresses[0].longitude.toString()
                    address = addresses.get(0).getAddressLine(0)
                    //Toast.makeText(applicationContext,address.toString(), Toast.LENGTH_LONG).show()
                    val mynumber = 757
                    println("The key for value  $mynumber")

                    val map = HashMap<String, Int>() //Creating HashMap
                    map["Passport"] = 50114
                    map["shopping"] = 51972
                    map["sss"] = 757
                    val keys = arrayOfNulls<String>(map.size)
                    val values: Array<Int?> = arrayOfNulls(map.size)
                    var index = 0
                    for ((key, value) in map) {
                        keys[index] = key
                        values[index] = value
                        index++
                    }
//                    val mynumber = 300
                    var dis = values[0]?.minus(mynumber)?.let { Math.abs(it) }
                    var indx = 0
                    for (c in 1 until values.size) {
                        val cdistance = values[c]?.minus(mynumber)?.let { Math.abs(it) }
                        if (cdistance != null) {
                            if (cdistance < dis!!) {
                                indx = c
                                dis = cdistance
                            }
                        }
                    }
                    val theno = values[indx]
                    println("near no is$theno")
                    for ((key, value) in map) {
                        if (value == theno) {
                            println("The key for value $theno is $key")
                            break
                            senddata(key.toString())
                        }
                    }


                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }


    }

    private fun senddata(key: String) {

        val prefs = getSharedPreferences("My", MODE_PRIVATE)
        val number = prefs.getString("number", "No name defined") //"No name defined" is the default value.

        val smsManager = SmsManager.getDefault() as SmsManager
        smsManager.sendTextMessage(number,null,key.toString(),null,null)

    }
}