package com.example.foodrecyclerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SharedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//End insets

        //find Save button
        val save = findViewById<Button>(R.id.save)
        save.setOnClickListener {
            //Find username Edit Text
            val username = findViewById<EditText>(R.id.username)
            //Get the name user entered
            val inputname = username.text.toString()
            //Create a Shared Preferences Object
            val prefs = this.getSharedPreferences("storage", MODE_PRIVATE)
            //Create a Preference Editor
            val editor = prefs.edit()
            //Save the inputted name in preferences as key value
            editor.putString("inputname", inputname)
            editor.apply()
            //Intent back to main activity.
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish() // Kill Current Activity

        }//End Listener

    }//end onCreate
}//end Class