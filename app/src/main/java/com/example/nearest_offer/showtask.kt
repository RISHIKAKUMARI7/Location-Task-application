package com.example.nearest_offer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class showtask : AppCompatActivity() {


    var ref: DatabaseReference? = null
    var list: ArrayList<mytask>? = null
    private var listener: MyAdapter.RecyclerViewClickListener? = null

    var recyclerView: RecyclerView? = null

    var searchView: SearchView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showtask)

        ref = FirebaseDatabase.getInstance().reference.child("task")
        recyclerView = findViewById(R.id.recyclerview)
        searchView = findViewById(R.id.searchview)
    }

    override fun onStart() {
        super.onStart()
        if (ref != null) {
            ref!!.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        list = ArrayList()
                        for (ds in snapshot.children) {
                            list!!.add(ds.getValue(mytask::class.java)!!)
                        }
//                        setOnClickListner()
                        val adapter = MyAdapter(list, listener)
                        recyclerView!!.adapter = adapter
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
                }
            })
        }


        if (searchView != null) {
            searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(s: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(s: String): Boolean {
                    search(s)
                    return true
                }
            })
        }
    }

    private fun search(s: String) {

        try{
            val mylist = ArrayList<mytask?>()
            for (`object` in list!!) {
                if (`object`!!.getName().toLowerCase().contains(s.toLowerCase())) {
                    mylist.add(`object`)
                }
            }
            val adapter = MyAdapter(mylist,listener)
            recyclerView!!.adapter = adapter
        }catch (e:Exception){
            e.printStackTrace()
        }

    }
}