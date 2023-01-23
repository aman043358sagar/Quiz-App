package com.example.quizapp.activity

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import android.os.Bundle
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.activity.nav.SetUpNavGraph
import com.example.quizapp.activity.ui.theme.QuizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lateinit var navController: NavHostController

        setContent {
            QuizAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {

                    navController = rememberNavController()
                    SetUpNavGraph(navController = navController)

                }
            }
        }

    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuizAppTheme {

    }
}