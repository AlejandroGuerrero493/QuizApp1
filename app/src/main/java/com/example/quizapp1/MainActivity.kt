package com.example.quizapp1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_text1, true),
        Question(R.string.question_text2, true),
        Question(R.string.question_text3, false)
    )

    private var currentIndex = 0

    companion object {
        private const val KEY_INDEX = "current_index"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        restoreState(savedInstanceState)
        setupClickListeners()
        updateQuestion()
    }

    private fun initializeViews() {
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)
        questionTextView = findViewById(R.id.questionTextView)
    }

    private fun restoreState(savedInstanceState: Bundle?) {
        currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
    }

    private fun setupClickListeners() {
        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
        nextButton.setOnClickListener { moveToNextQuestion() }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_INDEX, currentIndex)
    }

    private fun updateQuestion() {
        val question = questionBank[currentIndex]
        questionTextView.setText(question.textResId)
    }

    private fun moveToNextQuestion() {
        currentIndex = (currentIndex + 1) % questionBank.size
        updateQuestion()
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_answer
        } else {
            R.string.incorrect_answer
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}