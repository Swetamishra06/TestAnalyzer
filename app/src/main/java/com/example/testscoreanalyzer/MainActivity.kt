package com.example.testscoreanalyzer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
   lateinit var first :EditText
   lateinit var last : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
         first = findViewById<EditText>(R.id.editTextText)
        last =  findViewById<EditText>(R.id.editTextText2)

var btn2 = findViewById<Button>(R.id.button)



        btn2.setOnClickListener() {

            var intent = Intent(this, SecondActivity::class.java)


            intent.putExtra("first_name",first.text.toString())
            intent.putExtra("last_name",last.text.toString())
            startActivity(intent)
        }

        }
    }
