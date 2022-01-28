package com.adimer.sis.cafeteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val db=Firebase.firestore
    val TAG="MYTAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var arrayAdapter:ArrayAdapter<*>
        val cafes= mutableListOf("CAFE CLASICO","CAFE CON LECHE","CAFE PURO","SUBMARINO")
        val list=findViewById<ListView>(R.id.list)



        db.collection("cafes")
//            .whereEqualTo("state", "CA")
            .addSnapshotListener { value, e ->
                if (e != null) {
                    Log.e(TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }

                val cities = ArrayList<String>()
                for (doc in value!!) {
                    doc.getString("nombre")?.let {
                        cities.add(it)
                    }
                }
//                Log.e(TAG, "Current cites in CA: $cities")
                arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,cities)
                list.adapter=arrayAdapter
            }
    }
}