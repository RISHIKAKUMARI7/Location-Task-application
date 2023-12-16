package com.example.nearest_offer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottom = findViewById<BottomNavigationView>(R.id.bottom)

        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.home -> {
                    val i = Intent(applicationContext, my::class.java)
                    startActivity(i)
                true }

                R.id.shop ->
                {
                    val i = Intent(applicationContext, Shoplocation::class.java)
                    startActivity(i)
                    true
                }

                R.id.task ->
                {
                    val i = Intent(applicationContext,Addtask::class.java)
                    startActivity(i)
                    true
                }

                R.id.showtask ->
                {
                    val i = Intent(applicationContext,location::class.java)
                    startActivity(i)
                    true
                }

                R.id.notify ->
                {
                    val i = Intent(applicationContext,popnotify::class.java)
                    startActivity(i)
                    true
                }



                else -> {false}
            }
        }
    }
}