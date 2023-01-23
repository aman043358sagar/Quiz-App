package com.example.quizapp.activity.constant


import com.example.quizapp.R
import com.example.quizapp.activity.datamodel.QuestionDataModel

class QuestionList {
    companion object {
        val questionList = arrayListOf(
            QuestionDataModel(
                question = "1. What is the output of the program?",
                image = R.drawable.img1,
                options = arrayListOf(
                    "0",
                    "1",
                    "true",
                    "false"
                ),
                correctOption = 4
            ), QuestionDataModel(
                question = "2. What is the datatype of variable b?",
                image = R.drawable.img2,
                options = arrayListOf(
                    "List<Int>",
                    "Array<Int>",
                    "ArrayList<Int>",
                    "IntArray"
                ),
                correctOption = 1
            ), QuestionDataModel(
                question = "3. What is the output of the program?",
                image = R.drawable.img3,
                options = arrayListOf(
                    "3",
                    "4",
                    "5",
                    "6"
                ),
                correctOption = 2
            ), QuestionDataModel(
                question = "4. What is the output of the program?",
                image = R.drawable.img4,
                options = arrayListOf(
                    "He",
                    "llo",
                    "H e l l o",
                    "Hello"
                ),
                correctOption = 4
            ), QuestionDataModel(
                question = "5. What is the datatype of b?",
                image = R.drawable.img5,
                options = arrayListOf(
                    "List<String>",
                    "Array<String>",
                    "ArrayList<String>",
                    "MutableList<String>"
                ),
                correctOption = 1
            ), QuestionDataModel(
                question = "6. What is the output of the program?",
                image = R.drawable.img6,
                options = arrayListOf(
                    "0",
                    "1",
                    "false",
                    "true"
                ),
                correctOption = 4
            ), QuestionDataModel(
                question = "7. What is the output of the program?",
                image = R.drawable.img7,
                options = arrayListOf(
                    "12345678",
                    "01234567",
                    "12",
                    "1 3 5 7"
                ),
                correctOption = 4
            ), QuestionDataModel(
                question = "8. What is the output of the program?",
                image = R.drawable.img8,
                options = arrayListOf(
                    "0",
                    "1",
                    "true",
                    "false"
                ),
                correctOption = 4
            ), QuestionDataModel(
                question = "9. What is the output of the program?",
                image = R.drawable.img9,
                options = arrayListOf(
                    "runtime error",
                    "compile time error",
                    "7",
                    "null"
                ),
                correctOption = 3
            ), QuestionDataModel(
                question = "10. What is the output of the program?",
                image = R.drawable.img10,
                options = arrayListOf(
                    "0",
                    "1",
                    "true",
                    "false"
                ),
                correctOption = 3
            )
        )

    }
}