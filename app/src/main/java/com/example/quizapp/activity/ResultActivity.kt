package com.example.quizapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.R
import com.example.quizapp.adapter.ResultAdapter
import com.example.quizapp.constant.QuestionList
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.statusBar)
        setContentView(binding.root)

        val adapter = ResultAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.tvPercentage.text = "${resultInPercent()}%"
        binding.pb.progress = resultInPercent()


        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }

    fun resultInPercent(): Int {
        var correctCounter = 0
        val questionList = QuestionList.questionList
        for (question in questionList){
            if (question.selectedOption!=-1 && question.selectedOption == question.correctOption)
                correctCounter++
        }
        val percentage = ((correctCounter).toFloat() /questionList.size.toFloat())*100
        return percentage.toInt()
    }
}