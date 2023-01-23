package com.example.quizapp.activity.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.activity.constant.QuestionList
import com.example.quizapp.activity.ui.theme.QuizAppTheme


@Composable
fun QuizResultScreen(result: Array<Int>) {
    var counter = 0
    for (i in result.indices) {
        if (result[i] == QuestionList.questionList[i].correctOption)
            ++counter
    }

    LazyColumn(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        item { ResultProgress(result = counter) }
        itemsIndexed(result){index: Int, opt: Int ->
            CorrectItem(index,opt)
        }
    }

}



@Preview(name = "NEXUS_5", device = Devices.NEXUS_5)
@Preview(name = "NEXUS_5", device = Devices.NEXUS_5, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun QuizResultPreview() {
    QuizAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background) {
            QuizResultScreen(arrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1))


        }
    }
}




@Composable
fun ResultProgress(result: Int) {
    Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier
            .size(size = 280.dp)
            .padding(all = 10.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        if (isSystemInDarkTheme()) Color(0xFF666666) else Color(0xFFE4E4E4),
                        if (isSystemInDarkTheme()) Color(0x00FFFFFF) else Color(0x00FFFFFF)
                    )
                )
            )
        )

        Box(modifier = Modifier
            .size(size = 220.dp)
            .padding(all = 10.dp)
            .clip(CircleShape)
            .background(if (isSystemInDarkTheme()) Color(0xFF303030) else Color.White)
        )

        Box(modifier = Modifier
            .size(size = 200.dp)
            .padding(all = 10.dp)
            .border(width = 1.dp,
                color = if (isSystemInDarkTheme()) Color(0xFFBB86FC) else Color(0xFF3700B3),
                shape = CircleShape)
        )

        CircularProgressIndicator(
            modifier = Modifier
                .size(160.dp),
            progress = (if (result == 10) "1.0" else "0.${result}").toFloat(),
            strokeWidth = 15.dp,
            trackColor = if (isSystemInDarkTheme()) Color(0xFF5C5C5C) else Color(0xFFF4F4F4),
            color = if (isSystemInDarkTheme()) Color(0xFF833AB4) else Color(0xFFC13584),
            strokeCap = StrokeCap.Round
        )


        Box(modifier = Modifier
            .size(size = 130.dp)
            .padding(all = 10.dp)
            .border(width = 1.dp,
                color = if (isSystemInDarkTheme()) Color(0xFFBB86FC) else Color(0xFF3700B3),
                shape = CircleShape)
        )

        Text(
            text = "${result * 10}%",
            color = if (isSystemInDarkTheme()) Color(0xFFFF0000) else Color(0xFF833AB4),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

    }


}



@Preview(showBackground = true)
@Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ResultProgressPreview() {
    ResultProgress(9)
}





@Composable
fun CorrectItem(ind: Int,opt: Int) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        Text(modifier = Modifier.padding(all = 10.dp),
            text = QuestionList.questionList[ind].question,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black)
        Image(painter = painterResource(id = QuestionList.questionList[ind].image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(all = 10.dp)
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(5), clip = true),
            contentScale = ContentScale.FillBounds)

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(all = 10.dp)
            .background(
                if(QuestionList.questionList[ind].correctOption == 1){
                    if(isSystemInDarkTheme()) Color(0x4D43A047) else Color(0x1A43A047)

                }else if (opt == 1){
                    if(isSystemInDarkTheme()) Color(0x33FB0000) else Color(0x1AFB0000)
                }else{
                    if(isSystemInDarkTheme()) Color(0x33383838) else Color(0xB3F6F6F6)
                }
            ),
            verticalAlignment = Alignment.CenterVertically) {
            if(QuestionList.questionList[ind].correctOption == 1){
                RadioButton(colors = RadioButtonDefaults.colors(Color(0xFF43A047)), selected = true, onClick = {  })

            }else if (opt == 1){
                RadioButton(colors = RadioButtonDefaults.colors(Color(0xFFFB0000)), selected = true, onClick = {  })
            }else{
                RadioButton( selected = false, onClick = {  })
            }

            Text(text = QuestionList.questionList[ind].options[0])


        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(all = 10.dp)
            .background(
                if(QuestionList.questionList[ind].correctOption == 2){
                    if(isSystemInDarkTheme()) Color(0x4D43A047) else Color(0x1A43A047)

                }else if (opt == 2){
                    if(isSystemInDarkTheme()) Color(0x33FB0000) else Color(0x1AFB0000)
                }else{
                    if(isSystemInDarkTheme()) Color(0x33383838) else Color(0xB3F6F6F6)
                }
            ),
            verticalAlignment = Alignment.CenterVertically) {
            if(QuestionList.questionList[ind].correctOption == 2){
                RadioButton(colors = RadioButtonDefaults.colors(Color(0xFF43A047)), selected = true, onClick = {  })

            }else if (opt == 2){
                RadioButton(colors = RadioButtonDefaults.colors(Color(0xFFFB0000)), selected = true, onClick = {  })
            }else{
                RadioButton( selected = false, onClick = {  })
            }

            Text(text = QuestionList.questionList[ind].options[1])
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(all = 10.dp)
            .background(
                if(QuestionList.questionList[ind].correctOption == 3){
                    if(isSystemInDarkTheme()) Color(0x4D43A047) else Color(0x1A43A047)

                }else if (opt == 3){
                    if(isSystemInDarkTheme()) Color(0x33FB0000) else Color(0x1AFB0000)
                }else{
                    if(isSystemInDarkTheme()) Color(0x33383838) else Color(0xB3F6F6F6)
                }
            ),
            verticalAlignment = Alignment.CenterVertically) {
            if(QuestionList.questionList[ind].correctOption == 3){
                RadioButton(colors = RadioButtonDefaults.colors(Color(0xFF43A047)), selected = true, onClick = {  })

            }else if (opt == 3){
                RadioButton(colors = RadioButtonDefaults.colors(Color(0xFFFB0000)), selected = true, onClick = {  })
            }else{
                RadioButton( selected = false, onClick = {  })
            }

            Text(text = QuestionList.questionList[ind].options[2])
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(all = 10.dp)
            .background(
                if(QuestionList.questionList[ind].correctOption == 4){
                    if(isSystemInDarkTheme()) Color(0x4D43A047) else Color(0x1A43A047)

                }else if (opt == 4){
                    if(isSystemInDarkTheme()) Color(0x33FB0000) else Color(0x1AFB0000)
                }else{
                    if(isSystemInDarkTheme()) Color(0x33383838) else Color(0xB3F6F6F6)
                }
            ),
            verticalAlignment = Alignment.CenterVertically) {
            if(QuestionList.questionList[ind].correctOption == 4){
                RadioButton(colors = RadioButtonDefaults.colors(Color(0xFF43A047)), selected = true, onClick = {  })

            }else if (opt == 4){
                RadioButton(colors = RadioButtonDefaults.colors(Color(0xFFFB0000)), selected = true, onClick = {  })
            }else{
                RadioButton( selected = false, onClick = {  })
            }

            Text(text = QuestionList.questionList[ind].options[3])
        }


    }
}


@Preview(showBackground = true)
@Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CorrectItemPreview() {
    CorrectItem(0,2)
}



