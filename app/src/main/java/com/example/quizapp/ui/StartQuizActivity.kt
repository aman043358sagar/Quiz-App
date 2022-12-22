package com.example.quizapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityStartQuizBinding

class StartQuizActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}