package com.example.quizapp.activity.nav

sealed class NavScreen(val route: String){
    object StartQuizScreen : NavScreen(route = "start_quiz_screen")
    object QuizQuestionScreen : NavScreen(route = "quiz_question_screen")
}
