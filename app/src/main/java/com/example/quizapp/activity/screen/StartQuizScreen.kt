package com.example.quizapp.activity.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.R
import com.example.quizapp.activity.nav.NavScreen
import com.example.quizapp.activity.ui.theme.GreyD
import com.example.quizapp.activity.ui.theme.GreyL
import com.example.quizapp.activity.ui.theme.QuizAppTheme


@Composable
fun StartQuizScreen(navController: NavHostController){
    val constraints = ConstraintSet {
        val image = createRefFor("image")
        val text1 = createRefFor("text1")
        val text2 = createRefFor("text2")
        val btnStart = createRefFor("btnStart")

        constrain(image){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(text1) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(image.bottom)
        }

        constrain(text2) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(text1.bottom)
            width = Dimension.value(280.dp)
        }

        constrain(btnStart) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }
    }
    ConstraintLayout(constraintSet = constraints, modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_start),
            contentDescription = "Image",
            modifier = Modifier
                .layoutId("image")
                .padding(top = 50.dp)
                .width(280.dp)
                .height(280.dp)
        )
        Text(
            text = "kotlin",
            modifier = Modifier
                .layoutId("text1")
                .padding(top = 46.dp),
            color = if(isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Kotlin is now google preferred language for Android App Development",
            modifier = Modifier
                .layoutId("text2")
                .padding(top = 16.dp),
            color = if(isSystemInDarkTheme()) GreyL else GreyD,
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )

        Button(onClick = {
            navController.navigate(route = NavScreen.QuizQuestionScreen.route)


        }, modifier = Modifier
            .layoutId("btnStart")
            .padding(bottom = 20.dp)
            .width(200.dp)
            .height(40.dp),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(contentColor = Color.Transparent)
        ) {

            Box(modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.verticalGradient(listOf(Color(0xFF367CFF),
                    Color(0xFF3A36FF))),
                    shape = RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Start", color = Color.White)
            }

        }
    }
}


@Composable
@Preview(name = "NEXUS_5", device = Devices.NEXUS_5)
@Preview(name = "NEXUS_5", device = Devices.NEXUS_5, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun StartQuizScreenPreview(){
    QuizAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background) {
            StartQuizScreen(navController = rememberNavController())
        }
    }
}

