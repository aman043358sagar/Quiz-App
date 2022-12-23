package com.example.quizapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityStartQuizBinding

class StartQuizActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.statusBar)
        binding.btnStart.setOnClickListener {
            startActivity(Intent(this@StartQuizActivity, MainActivity::class.java))
        }
    }
}