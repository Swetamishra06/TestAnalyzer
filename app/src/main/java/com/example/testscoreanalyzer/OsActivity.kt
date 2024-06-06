package com.example.testscoreanalyzer

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class OsActivity : AppCompatActivity() {
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
        "In Operating Systems, which of the following is/are CPU scheduling algorithms?",
        "To access the services of the operating system, the interface is provided by the__",
        "CPU scheduling is the basis of __",
        "Which one of the following errors will be handled by the operating system?",
        "Where is the operating system placed in the memory?",
        "If a process fails, most operating systems write the error information to a _",
        "Which one of the following is not a real-time operating system?",
        "What does OS X have?",
        "In operating system, each process has its own __",
        "Transient operating system code is a code that __"
    )

    private val option1 = arrayOf("Priority", "Library", "Multiprogramming OS", "Lack of paper in Printer", "Either low or high memory", "New file", "RT Linux",
        "Monolithic kernel with modules", "Open files", "Stays in the memory always"
    )
    private val option2 = arrayOf("Round Robin", "System calls", "Larger memory sized systems", "Connection failure in the network", "In the low memory", "Another running process", "Palm OS", "Microkernel",
        "Pending alarms, signals, signal handlers", "Never enters the memory space"
    )
    private val option3 = arrayOf("Shortest Job First", "Assembly instructions", "Multiprocessor systems", "Power failure", "In the high memory", "Log file", "QNX", "Monolithic kernel", "Address space and global variables",
        "Comes and goes as needed"
    )
    private val option4 = arrayOf("All of the mentioned", "API", "None of the mentioned", "All of the mentioned", "None of the mentioned", "None of the mentioned", "VxWorks", "Hybrid kernel",
        "All of the mentioned", "Is not easily accessible"
    )

    private val correctAnswers = arrayOf(4, 2, 1, 4, 1, 3, 2, 4, 4, 3)

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
