package com.example.quizapp.activity.screen

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.quizapp.R
import com.example.quizapp.activity.constant.QuestionList
import com.example.quizapp.activity.ui.theme.GreyD
import com.example.quizapp.activity.ui.theme.GreyL
import com.example.quizapp.activity.ui.theme.QuizAppTheme


val optionSelected = Array(10) { 0 }

@Composable
fun QuizQuestionScreen() {

    var questionCounter by remember { mutableStateOf(1) }
    var opt1 by remember { mutableStateOf(false) }
    var opt2 by remember { mutableStateOf(false) }
    var opt3 by remember { mutableStateOf(false) }
    var opt4 by remember { mutableStateOf(false) }


    val constraints = ConstraintSet {
        val kotlinIcon = createRefFor("kotlinIcon")
        val questionProgressText = createRefFor("questionProgressText")
        val progressBarIndicator = createRefFor("progressBarIndicator")

        val nextButton = createRefFor("nextButton")
        val scrollView = createRefFor("scrollView")
        val questionText = createRefFor("questionText")
        val img = createRefFor("image1")
        val option1Box = createRefFor("option1Box")
        val option2Box = createRefFor("option2Box")
        val option3Box = createRefFor("option3Box")
        val option4Box = createRefFor("option4Box")


        constrain(kotlinIcon) {
            start.linkTo(parent.start, margin = 10.dp)
            top.linkTo(parent.top, margin = 10.dp)
            width = Dimension.value(30.dp)
            height = Dimension.value(30.dp)
        }

        constrain(questionProgressText) {
            end.linkTo(anchor = parent.end, margin = 10.dp)
            top.linkTo(kotlinIcon.top)
            bottom.linkTo(kotlinIcon.bottom)

        }

        constrain(progressBarIndicator) {
            start.linkTo(parent.start, margin = 10.dp)
            end.linkTo(parent.end, margin = 10.dp)
            top.linkTo(kotlinIcon.bottom, margin = 20.dp)
            width = Dimension.fillToConstraints
            height = Dimension.value(10.dp)
        }



        constrain(nextButton) {
            bottom.linkTo(anchor = parent.bottom, margin = 10.dp)
            end.linkTo(anchor = parent.end, margin = 10.dp)
        }

        constrain(scrollView) {
            start.linkTo(anchor = parent.start)
            end.linkTo(anchor = parent.end)
            top.linkTo(anchor = progressBarIndicator.bottom, margin = 10.dp)
            bottom.linkTo(anchor = nextButton.top, margin = 10.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints

        }

        constrain(questionText) {
            top.linkTo(parent.top, margin = 10.dp)
            start.linkTo(parent.start, margin = 10.dp)
            end.linkTo(parent.end, margin = 10.dp)
            width = Dimension.fillToConstraints
        }

        constrain(img) {
            start.linkTo(anchor = questionText.start)
            end.linkTo(anchor = questionText.end)
            top.linkTo(anchor = questionText.bottom, margin = 10.dp)
            width = Dimension.fillToConstraints

        }

        constrain(option1Box) {
            start.linkTo(anchor = questionText.start)
            end.linkTo(anchor = questionText.end)
            top.linkTo(anchor = img.bottom, margin = 20.dp)
            width = Dimension.fillToConstraints
        }

        constrain(option2Box) {
            start.linkTo(anchor = questionText.start)
            end.linkTo(anchor = questionText.end)
            top.linkTo(anchor = option1Box.bottom, margin = 20.dp)
            width = Dimension.fillToConstraints
        }

        constrain(option3Box) {
            start.linkTo(anchor = questionText.start)
            end.linkTo(anchor = questionText.end)
            top.linkTo(anchor = option2Box.bottom, margin = 20.dp)
            width = Dimension.fillToConstraints
        }

        constrain(option4Box) {
            start.linkTo(anchor = questionText.start)
            end.linkTo(anchor = questionText.end)
            top.linkTo(anchor = option3Box.bottom, margin = 20.dp)
            width = Dimension.fillToConstraints
        }


    }

    if (questionCounter == 11) {
        QuizResultScreen(result = optionSelected)
    } else
        ConstraintLayout(constraintSet = constraints, modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.ic_kotlin),
                contentDescription = "kotlin icon",
                modifier = Modifier
                    .layoutId("kotlinIcon")
            )

            Text(
                text = "${questionCounter}/10",
                modifier = Modifier
                    .layoutId("questionProgressText"),
                color = if (isSystemInDarkTheme()) GreyL else GreyD

            )




            LinearProgressIndicator(modifier = Modifier
                .layoutId("progressBarIndicator"),
                progress = (if (questionCounter == 10) "1.0" else "0.${questionCounter}").toFloat(),
                color = Color(0xFF3276FD),
                trackColor = Color(0xFFC9DBFF)
            )

            Column(modifier = Modifier
                .verticalScroll(rememberScrollState())
                .layoutId("scrollView")
                .fillMaxSize()) {

                ConstraintLayout(constraintSet = constraints,
                    modifier = Modifier
                        .fillMaxSize()) {

                    Text(text = QuestionList.questionList[questionCounter - 1].question,
                        modifier = Modifier.layoutId("questionText"),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black)


                    Image(painter = painterResource(id = QuestionList.questionList[questionCounter - 1].image),
                        contentDescription = null,
                        modifier = Modifier
                            .layoutId("image1")
                            .fillMaxWidth()
                            .height(200.dp)
                            .shadow(elevation = 5.dp, shape = RoundedCornerShape(5), clip = true),
                        contentScale = ContentScale.FillBounds)

                    Row(modifier = Modifier
                        .layoutId("option1Box")
                        .fillMaxWidth()
                        .height(45.dp)
                        .background(
                            if (opt1)
                                if (isSystemInDarkTheme()) Color(0x4C367CFF) else Color(0x23367CFF)
                            else
                                if (isSystemInDarkTheme()) Color(0x33383838) else Color(0xB3F6F6F6))
                        .clickable {
                            optionSelected[questionCounter - 1] = 1
                            opt1 = true
                            opt2 = false
                            opt3 = false
                            opt4 = false


                        },
                        verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF3700B3),
                                unselectedColor = Color(0xFF3700B3)),
                            selected = opt1,
                            onClick = {
                                optionSelected[questionCounter - 1] = 1
                                opt1 = true
                                opt2 = false
                                opt3 = false
                                opt4 = false

                            })
                        Text(text = QuestionList.questionList[questionCounter - 1].options[0])
                    }

                    Row(modifier = Modifier
                        .layoutId("option2Box")
                        .fillMaxWidth()
                        .height(45.dp)
                        .background(
                            if (opt2)
                                if (isSystemInDarkTheme()) Color(0x4C367CFF) else Color(0x23367CFF)
                            else
                                if (isSystemInDarkTheme()) Color(0x33383838) else Color(0xB3F6F6F6)
                        )
                        .clickable {
                            optionSelected[questionCounter - 1] = 2
                            opt1 = false
                            opt2 = true
                            opt3 = false
                            opt4 = false
                        },
                        verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF3700B3),
                                unselectedColor = Color(0xFF3700B3)),
                            selected = opt2,
                            onClick = {
                                optionSelected[questionCounter - 1] = 2
                                opt1 = false
                                opt2 = true
                                opt3 = false
                                opt4 = false
                            })
                        Text(text = QuestionList.questionList[questionCounter - 1].options[1])
                    }

                    Row(modifier = Modifier
                        .layoutId("option3Box")
                        .fillMaxWidth()
                        .height(45.dp)
                        .background(
                            if (opt3)
                                if (isSystemInDarkTheme()) Color(0x4C367CFF) else Color(0x23367CFF)
                            else
                                if (isSystemInDarkTheme()) Color(0x33383838) else Color(0xB3F6F6F6)
                        )
                        .clickable {
                            optionSelected[questionCounter - 1] = 3
                            opt1 = false
                            opt2 = false
                            opt3 = true
                            opt4 = false
                        },
                        verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF3700B3),
                                unselectedColor = Color(0xFF3700B3)), selected = opt3, onClick = {
                                optionSelected[questionCounter - 1] = 3
                                opt1 = false
                                opt2 = false
                                opt3 = true
                                opt4 = false
                            })
                        Text(text = QuestionList.questionList[questionCounter - 1].options[2])
                    }

                    Row(modifier = Modifier
                        .layoutId("option4Box")
                        .fillMaxWidth()
                        .height(45.dp)
                        .background(if (opt4)
                            if (isSystemInDarkTheme()) Color(0x4C367CFF) else Color(0x23367CFF)
                        else
                            if (isSystemInDarkTheme()) Color(0x33383838) else Color(0xB3F6F6F6))
                        .clickable {
                            optionSelected[questionCounter - 1] = 4
                            opt1 = false
                            opt2 = false
                            opt3 = false
                            opt4 = true
                        },
                        verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF3700B3),
                                unselectedColor = Color(0xFF3700B3)), selected = opt4, onClick = {
                                optionSelected[questionCounter - 1] = 4
                                opt1 = false
                                opt2 = false
                                opt3 = false
                                opt4 = true
                            })
                        Text(text = QuestionList.questionList[questionCounter - 1].options[3])
                    }


                }
            }


            Button(onClick = {

                if (questionCounter < 11)
                    ++questionCounter



                opt1 = false
                opt2 = false
                opt3 = false
                opt4 = false


            }, modifier = Modifier
                .layoutId("nextButton")
                .width(160.dp)
                .height(40.dp)
                .padding(start = 5.dp, end = 10.dp),
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
                    Text(text = "Next", color = Color.White)
                }

            }
        }


}




@Preview(name = "NEXUS_5", device = Devices.NEXUS_5)
@Preview(name = "NEXUS_5", device = Devices.NEXUS_5, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    QuizAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background) {
            QuizQuestionScreen()


        }
    }
}



