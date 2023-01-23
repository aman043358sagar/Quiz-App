package com.example.quizapp.activity.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quizapp.activity.screen.QuizQuestionScreen
import com.example.quizapp.activity.screen.StartQuizScreen

@Composable
fun SetUpNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = NavScreen.StartQuizScreen.route
    ){
        composable(
            route = NavScreen.StartQuizScreen.route
        ){
            StartQuizScreen(navController)
        }

        composable(
            route = NavScreen.QuizQuestionScreen.route
        ){
            QuizQuestionScreen()
        }

    }
}