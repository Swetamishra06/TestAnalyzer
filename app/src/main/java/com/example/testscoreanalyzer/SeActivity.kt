package com.example.testscoreanalyzer

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SeActivity : AppCompatActivity() {
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
        "Who is the father of Software Engineering?",
        " ___ is a software development activity that is not a part of software processes.",
        "CASE stands for__",
        "____ is defined as the process of generating analysis and designing documents?",
        "Why do bugs and failures occur in software?",
        " Attributes of good software is __________",
        " The Cleanroom philosophy was proposed by _________",
        "_____ suits the Manifesto for Agile Software Development.",
        " What are agile manifesto principles?",
        "Who proposed Function Points?"
    )

    private val option1 = arrayOf(" Margaret Hamilton", " Validation", "Computer-Aided Software Engineering", " Re-engineering", "Because of Developers", " Development", " Linger",
        " Customer collaboration", " Customer satisfaction", " Albrecht"
    )
    private val option2 = arrayOf(" Watts S. Humphrey", " Specification", " Control Aided Science and Engineering", " Reverse engineering", " Because of companies", " Maintainability & functionality", " Mills", " Individuals and interactions",
        "Face-to-face communication within a development team", " Jacobson"
    )
    private val option3 = arrayOf(" Alan Turing", " Development", " Cost Aided System Experiments", " Software re-engineering", "Due both companies and Developers", " Functionality", " Dyer ", " Working software", " Changes in requirements are welcome",
        " Boehm"
    )
    private val option4 = arrayOf(" Boris Beizer", " Dependence", " None of the mentioned", " Science and engineering", " None of the mentioned", " Maintainability", " All of the Mentioned", " All of the mentioned",
        " All of the mentioned", " Booch"
    )

    private val correctAnswers = arrayOf(2,4 ,1 ,2 , 3, 2,4 ,4 , 4, 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_se)
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

