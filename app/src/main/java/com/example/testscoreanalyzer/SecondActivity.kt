package com.example.testscoreanalyzer;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
lateinit var firstname:EditText
lateinit var lastname:EditText
lateinit var os : RadioButton
lateinit var coa:RadioButton
lateinit var dbms : RadioButton
lateinit var se : RadioButton
lateinit var rg : RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
       os = findViewById<RadioButton>(R.id.radioButton)
        coa = findViewById<RadioButton>(R.id.radioButton3)
        dbms = findViewById<RadioButton>(R.id.radioButton4)
        se = findViewById<RadioButton>(R.id.radioButton5)

        var showname = findViewById<TextView>(R.id.textView9)
       val firstname = intent.getStringExtra("first_name")
        val lastname = intent.getStringExtra("last_name")

        var fullname = " Hey ! ${firstname } ${lastname} 🙂"
        showname.text = fullname
        var pre = findViewById<Button>(R.id.button6)
        pre.setOnClickListener(){
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        }
        var nex = findViewById<Button>(R.id.button7)
        nex.setOnClickListener(){
            if(os.isChecked)
            {

                var intent = Intent (this, OsActivity:: class.java)
                startActivity(intent)
            }
            else
                if(coa.isChecked)
                {
                    "clicked"

                var intent = Intent(this,CoaActivity ::class.java)
                    startActivity(intent)

            }
            else
                if(dbms.isChecked)
                {
                    "clicked"
                  var intent = Intent(this,DbmsActivity:: class.java)
                    startActivity(intent)
                }
            else
            if (se.isChecked)
            {
                "clicked"
                var intent = Intent(this,SeActivity :: class.java)
startActivity(intent)
                }
            else
            {" not clicked"
                val toast = Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        }


    }
