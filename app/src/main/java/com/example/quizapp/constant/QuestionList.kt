package com.example.quizapp.constant

import com.example.quizapp.R
import com.example.quizapp.model.Question

class QuestionList {
    companion object {
        val questionList = arrayListOf(
            Question(
                question = "1. What is the output of the program?",
                options = arrayListOf(
                    "0",
                    "1",
                    "true",
                    "false"
                ),
                correctOption = 4,
                image = R.drawable.img1
            ), Question(
                question = "2. What is the datatype of variable b?",
                options = arrayListOf(
                    "List<Int>",
                    "Array<Int>",
                    "ArrayList<Int>",
                    "IntArray"
                ),
                correctOption = 1,
                image = R.drawable.img2
            ), Question(
                question = "3. What is the output of the program?",
                options = arrayListOf(
                    "3",
                    "4",
                    "5",
                    "6"
                ),
                correctOption = 2,
                image = R.drawable.img3
            ), Question(
                question = "4. What is the output of the program?",
                options = arrayListOf(
                    "He",
                    "llo",
                    "H e l l o",
                    "Hello"
                ),
                correctOption = 4,
                image = R.drawable.img4
            ), Question(
                question = "5. What is the datatype of b?",
                options = arrayListOf(
                    "List<String>",
                    "Array<String>",
                    "ArrayList<String>",
                    "MutableList<String>"
                ),
                correctOption = 1,
                image = R.drawable.img5
            ), Question(
                question = "6. What is the output of the program?",
                options = arrayListOf(
                    "0",
                    "1",
                    "false",
                    "true"
                ),
                correctOption = 4,
                image = R.drawable.img6
            ), Question(
                question = "7. What is the output of the program?",
                options = arrayListOf(
                    "12345678",
                    "01234567",
                    "12",
                    "1 3 5 7"
                ),
                correctOption = 4,
                image = R.drawable.img7
            ), Question(
                question = "8. What is the output of the program?",
                options = arrayListOf(
                    "0",
                    "1",
                    "true",
                    "false"
                ),
                correctOption = 4,
                image = R.drawable.img8
            ), Question(
                question = "9. What is the output of the program?",
                options = arrayListOf(
                    "runtime error",
                    "compile time error",
                    "7",
                    "null"
                ),
                correctOption = 3,
                image = R.drawable.img9
            ), Question(
                question = "10. What is the output of the program?",
                options = arrayListOf(
                    "0",
                    "1",
                    "true",
                    "false"
                ),
                correctOption = 3,
                image = R.drawable.img10
            )
        )
    }
}