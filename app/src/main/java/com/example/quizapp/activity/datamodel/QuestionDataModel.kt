package com.example.quizapp.activity.datamodel

import com.example.quizapp.R


data class QuestionDataModel(
    val question: String,
    val image: Int = R.drawable.placeholder,
    val options: ArrayList<String>,
    val correctOption: Int
)
