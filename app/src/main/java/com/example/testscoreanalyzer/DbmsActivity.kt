package com.example.testscoreanalyzer;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DbmsActivity :AppCompatActivity(){
    lateinit var question: TextView
    lateinit var op1: RadioButton
    lateinit var op2: RadioButton
    lateinit var op3: RadioButton
    lateinit var op4: RadioButton
    lateinit var pre: Button
    lateinit var nex: Button
    private var curques = 0
    private var score = 0

    private val ques = arrayOf(
        " Who created the first DBMS?",
        "Which of the following is not a type of database?",
        "Which of the following is not a function of the database?",
        " What is information about data called?",
        " _ is a hardware component that is most important for the operation of a database management system.",
        "The DBMS acts as an interface between _and _of an enterprise-class system.",
        "The ability to query data, as well as insert, delete, and alter tuples, is offered by _",
        " _ is a set of one or more attributes taken collectively to uniquely identify a record.",
        " Which command is used to remove a relation from an SQL?",
        " Which of the following set should be associated with weak entity set for weak entity to be meaningful?"
    )

    private val option1 = arrayOf(" Edgar Frank Codd", " Hierarchical", " Managing stored data", " Hyper data", " Microphone", " Data and the DBMS", "TCL ",
        "  Primary Key", " Drop table", " Neighbour set"
    )
    private val option2 = arrayOf(" Charles Bachman", " Network", " Manipulating data", " Tera data", "High speed,large capacity disk to store data", " Application and SQL", " DCL", " Foreign key",
        " Delete", " Strong entity set"
    )
    private val option3 = arrayOf(" Charles Babbage", " Distributed", " Security for stored data", " Meta data", " High-resolution video display", "Database application and the database", " DDL", " Super key", " Purge",
        " Owner set"
    )
    private val option4 = arrayOf(" Sharon B. Codd", " Decentralized ", " Analysing code", " Relations", " Printer", " The user and the software", " DML", " Candidate key",
        " Remove", " Identifying set"
    )

    private val correctAnswers = arrayOf(2, 4, 4, 3, 2, 3, 4, 3, 1, 4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_os)
        question = findViewById(R.id.textView7)
        nex = findViewById(R.id.button5)
        pre = findViewById(R.id.button4)
        op1 = findViewById(R.id.radioButton2)
        op2 = findViewById(R.id.radioButton6)
        op3 = findViewById(R.id.radioButton7)
        op4 = findViewById(R.id.radioButton9)

        nex.setOnClickListener {
            checkAnswer()
            curques++
            if (curques >= ques.size) {
                val intent = Intent(this, TestAnalyzerActivity::class.java)
                intent.putExtra("scorecard", score)
                startActivity(intent)
            } else {
                updatetext()
            }
        }

        pre.setOnClickListener {
            if (curques > 0) {
                curques--
                updatetext()
            }
            else{
                var intent = Intent(this,SecondActivity::class.java)
                startActivity(intent)
            }
        }

        updatetext()
    }

    private fun updatetext() {
        question.text = ques[curques]
        op1.text = option1[curques]
        op2.text = option2[curques]
        op3.text = option3[curques]
        op4.text = option4[curques]
        clearSelection()
    }

    private fun checkAnswer() {
        val selectedOption = when {
            op1.isChecked -> 1
            op2.isChecked -> 2
            op3.isChecked -> 3
            op4.isChecked -> 4
            else -> 0
        }
        if (selectedOption == correctAnswers[curques]) {
            score++
        }
    }

    private fun clearSelection() {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup3)
        radioGroup.clearCheck()
    }
}


