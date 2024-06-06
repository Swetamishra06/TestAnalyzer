package com.example.testscoreanalyzer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TestAnalyzerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_testanalyzer)
        var bck = findViewById<Button>(R.id.button2)
        var retest = findViewById<Button>(R.id.button3)
        val score = intent.getIntExtra("scorecard",0)

        // Find the TextView and set the score
        val scoreTextView: TextView = findViewById(R.id.scoreTextView)
        scoreTextView.text = "$score"
         bck.setOnClickListener(){
             var intent = Intent(this,MainActivity :: class.java)
             startActivity(intent)
         }
        retest.setOnClickListener(){
            var intent = Intent(this,SecondActivity:: class.java)
            startActivity(intent)
        }


    }
}

