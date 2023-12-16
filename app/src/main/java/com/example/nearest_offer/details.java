package com.example.nearest_offer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class details extends AppCompatActivity {

    TextView name, vicinity, rating, offer1,offer2;
    String mname, mvicinty, latitude, longitude, username;
    Double mrating;
    public DatabaseReference databaseReference;
    String off2= "Buy 1 Get 1 Free";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = findViewById(R.id.txtname);
        vicinity = findViewById(R.id.txtvicinity);
        rating = findViewById(R.id.txtrating);
        offer1 = findViewById(R.id.txtoffer1);

        offer2=findViewById(R.id.txtoffer2);
        offer2.setText(off2);
        offer1.setText("Offer 20% discount ");




        Bundle bundle = getIntent().getExtras();
        mname = bundle.getString("name");
        mvicinty = bundle.getString("vicinity");
        mrating = bundle.getDouble("rating");

        SharedPreferences prf = getSharedPreferences("My", Context.MODE_PRIVATE);
        username = prf.getString("username", "");


        name.setText("Shop Name: "+mname);
        vicinity.setText("Address: "+mvicinty);
        rating.setText("Rating: "+mrating.toString());

        SharedPreferences prfs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        latitude = prfs.getString("lati", "");
        longitude = prfs.getString("longi","");

        senddata();

        getoffer();

    }

    private void getoffer() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
         databaseReference = db.getReference("results");
       databaseReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               String moffer = snapshot.child("offer").getValue(String.class);

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });

    }

    private void senddata() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        storedata storenearby = new storedata(latitude,longitude,mvicinty,username,mname,mrating);
        databaseReference = db.getReference("nearby");
        databaseReference.push().setValue(storenearby);
    }
}