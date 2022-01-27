package com.adimer.sis.cafeteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
//    val db=Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayAdapter:ArrayAdapter<*>
        val cafes= mutableListOf("CAFE CLASICO","CAFE CON LECHE","CAFE PURO","SUBMARINO")
        val list=findViewById<ListView>(R.id.list)
        arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,cafes)
        list.adapter=arrayAdapter
    }
}