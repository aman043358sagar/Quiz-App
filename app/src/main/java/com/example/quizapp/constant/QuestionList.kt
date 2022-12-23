package com.example.quizapp.constant

import com.example.quizapp.model.Question

class QuestionList {
    companion object {
        val questionList = arrayListOf(
            Question(
                question = "What is a correct syntax to output \"Hello World\" in Kotlin?",
                options = arrayListOf(
                    "System.out.printline(\"Hello World\")",
                    "cout << \"Hello World\";",
                    "Console.WriteLine(\"Hello World\");",
                    "println(\"Hello World\")"
                ),
                correctOption = 4
            ), Question(
                question = "How do you insert COMMENTS in Kotlin code?",
                options = arrayListOf(
                    " # This is a comment",
                    " /* This is a comment",
                    " -- This is a comment",
                    " // This is a comment"
                ),
                correctOption = 4
            ), Question(
                question = "Which keyword is used to declare a function?",
                options = arrayListOf(
                    "decl",
                    "fun",
                    "define"
                ),
                correctOption = 2
            ), Question(
                question = "In Kotlin, code statements must end with a semicolon (;)",
                options = arrayListOf(
                    "False",
                    "True",
                ),
                correctOption = 1
            )
        )
    }
}