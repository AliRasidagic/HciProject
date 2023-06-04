package com.example.exerciseapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exerciseapp.R
import com.example.exerciseapp.ui.theme.ExerciseAppTheme

@Composable
fun HomePage(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val font = FontFamily(Font(R.font.open_sans))
    val titleFont = FontFamily(Font(R.font.roboto))

    val mainImage = painterResource(R.drawable.main_image)
    val icon1 = painterResource(R.drawable.kilogram)
    val icon2 = painterResource(R.drawable.user)
    val icon3 = painterResource(R.drawable.challenge)

    val icon4 = painterResource(R.drawable.easy)
    val icon5 = painterResource(R.drawable.medium)
    val icon6 = painterResource(R.drawable.hard)


    Box(
        modifier = Modifier
            .background(color = Color(0xFF8CF0F0))
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(top = 50.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Image(
                        painter = mainImage,
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 350.dp, height = 200.dp)
                            .alpha(0.5f)
                    )
                    Text(
                        text = "Welcome To All4Sport!",
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 60.dp),
                        fontFamily = titleFont
                    )
                    Text(
                        text = "We Provide All Tools For Your Body. Free.",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 100.dp)
                            .size(width = 200.dp, height = 40.dp),
                        fontFamily = font,
                    )
                    Button(
                        onClick = onButtonClick,
                        colors = ButtonDefaults.buttonColors(Color(0xFF08065E)),
                        modifier = Modifier
                            .padding(top = 150.dp)
                            .widthIn(150.dp)
                            .heightIn(30.dp)
                    ) {
                        Text(
                            text = "Learn More",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = font
                        )
                    }
                }
                Row(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(top = 32.dp)
                        .background(color = Color.White),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        modifier = modifier
                            .size(width = 120.dp, height = 100.dp)
                            .padding(top = 8.dp)
                            .padding(end = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = icon1,
                            contentDescription = null,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Effective and proven exercises!",
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Column(
                        modifier = modifier
                            .size(width = 110.dp, height = 100.dp)
                            .padding(top = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = icon2,
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                        )
                        Text(
                            text = "Exercises made specifically for you!",
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Column(
                        modifier = modifier
                            .size(width = 120.dp, height = 100.dp)
                            .padding(start = 32.dp)
                            .padding(top = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = icon3,
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                        )
                        Text(
                            text = "Multiple levels of difficulty!",
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Text(
                    text = "Everything Is Possible!",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = titleFont,
                    modifier = Modifier
                        .padding(top = 32.dp)
                )
                Row(
                    modifier = modifier
                        .size(width = 380.dp, height = 120.dp)
                        .padding(top = 50.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = icon4,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 55.dp)
                            .size(80.dp)
                    )
                    Image(
                        painter = icon5,
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                    )
                    Image(
                        painter = icon6,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 55.dp)
                            .size(80.dp)
                    )
                }
                Text(
                    text = stringResource(R.string.big_text),
                    modifier = Modifier
                        .padding(16.dp)
                        .padding(top = 16.dp),
                    textAlign = TextAlign.Justify,
                    fontSize = 15.sp,
                    fontFamily = font
                )
                Button(
                    onClick = onButtonClick,
                    colors = ButtonDefaults.buttonColors(Color(0xFF08065E)),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .widthIn(200.dp)
                        .heightIn(40.dp)
                ) {
                    Text(
                        text = "Start Your Journey!",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = font
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    ExerciseAppTheme {
        HomePage({})
    }
}
