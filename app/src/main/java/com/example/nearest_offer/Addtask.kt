package com.example.nearest_offer

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.database.FirebaseDatabase

class Addtask : AppCompatActivity() {

    var edname: EditText?=null
    var edprofile: EditText?=null
    var edcriteria: EditText?=null
    var eddes: EditText?=null
    var edhrname: EditText?=null
    var edcontact: EditText?=null
    var edaddress: EditText?=null

    var name:String?=null
    var strAddress:String?=null
    var description:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtask)


        edname = findViewById<EditText>(R.id.edname)
       eddes = findViewById<EditText>(R.id.eddes)
        edaddress = findViewById<EditText>(R.id.edprice)


    }

    fun UploadData(view: View?) {

         name = edname!!.text.toString()
        description = eddes!!.text.toString()
        strAddress = edaddress!!.text.toString()

        val coder = Geocoder(this)
        var address: List<Address?>


        address = coder.getFromLocationName(strAddress, 5);

        val location = address[0]!!
//        val latLng = LatLng(location.latitude, location.longitude)
        val lati = location.latitude.toString()
        val longi = location.longitude.toString()





        val data = FirebaseDatabase.getInstance().reference.child("task")

        val service = mytask(name,description,strAddress,lati,longi)


        data.push().setValue(service)

        Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()
    }

}