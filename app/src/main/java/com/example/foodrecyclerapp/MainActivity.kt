package com.example.foodrecyclerapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//end Insets

        // We find RecyclerView  using ID recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Layout Manager sets Recycler View Go vertical
        val layoutManager = LinearLayoutManager(this)

        // Put the layout Manager to recyclerView - View will be vertical
        //// Items will be vertically aligned
        recyclerView.layoutManager = layoutManager

        // Access the RecyclerAdapter(Has the Foods Arrays Data)
        // You will have the RecyclerAdapter held in adapter variables
        //If you wish to change the adpater data, please Edit the RecyclerAdapter Data Arrays
        val adapter = RecyclerAdapter(applicationContext)

        // Load the adapter with Data to Recycler View
        recyclerView.adapter = adapter
        //Your Recycler Now has the Data from Recycler Adapter.
        // RUN the App

        //Find Bottom sheet
        val bottom_sheet : FrameLayout = findViewById(R.id.bottom_sheet_container)
        BottomSheetBehavior.from(bottom_sheet).apply {
            peekHeight = 330
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        //Find Order Button
        val order = findViewById<Button>(R.id.btnorder)
        order.setOnClickListener {
            val i = Intent(applicationContext, OrderActivity::class.java)
            startActivity(i)
        }

    }//end onCreate
}//end Class