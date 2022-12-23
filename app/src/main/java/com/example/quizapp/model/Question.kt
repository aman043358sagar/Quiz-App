package com.example.quizapp.model

import com.example.quizapp.R
import java.io.Serializable

data class Question(
    val question: String,
    val image: Int = R.drawable.placeholder,
    val options: ArrayList<String>,
    val correctOption: Int,
    var selectedOption: Int = -1
) : Serializable
