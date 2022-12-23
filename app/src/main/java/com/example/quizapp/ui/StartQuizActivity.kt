package com.example.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.MainActivity
import com.example.quizapp.databinding.ActivityStartQuizBinding

class StartQuizActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE;
        binding.btnStart.setOnClickListener {
            startActivity(Intent(this@StartQuizActivity, MainActivity::class.java))
        }
    }
}