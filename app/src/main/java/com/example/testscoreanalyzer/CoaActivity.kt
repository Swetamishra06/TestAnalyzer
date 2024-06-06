package com.example.testscoreanalyzer;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CoaActivity :AppCompatActivity(){
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
        "Which of the following is a type of computer architecture?",
        " Which of the following is a type of architecture used in the computers nowadays?",
        "Which of the following is the subcategories of computer architecture?",
        " Which of the architecture is power efficient?",
        " What does CSA stands for?",
        "To reduce the memory access time we generally make use of _____",
        " The IA-32 system follows which of the following design?",
        " Which of the following architecture is suitable for a wide range of data types?",
        ". In CISC architecture most of the complex instructions are stored in _____",
        "The small extremely fast, RAM’s all called as ________"
    )

    private val option1 = arrayOf(" Microarchitecture", " Microarchitecture", " Microarchitecture", " RISC", "Computer Service Architecture", " SDRAM’s", " CISC",
        " IA-32", " CMOS", " Heaps"
    )
    private val option2 = arrayOf(" Harvard Architecture", " Harvard Architecture", " Instruction set architecture", " ISA", " Computer Speed Addition ", " Heaps", " SIMD"," ARM", " Register",
         " Accumulators"
    )
    private val option3 = arrayOf(" Von-Neumann Architecture", " Von-Neumann Architecture", " Systems design", " IANA", " Carry Save Addition", " Cache’s", " RISC", " ASUS firebird", " Transistors",
        " Stacks"
    )
    private val option4 = arrayOf(" All of the mentioned", "  System Design", " All of the mentioned", " CISC", "None of the mentioned", " Higher capacity RAM’s", " None of the mentioned", " 68000",
        " Diodes", " Cache"
    )
    private val correctAnswers = arrayOf(4,3,4,1,2,3,1,1,3,2)


    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_coa)
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

