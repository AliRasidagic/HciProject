package com.example.exerciseapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exerciseapp.R
import com.example.exerciseapp.ui.theme.ExerciseAppTheme

@Composable
fun StartingPage(
    onRegistrationClicked: () -> Unit,
    onLoginClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val font = FontFamily(Font(R.font.open_sans))
    val titleFont = FontFamily(Font(R.font.roboto))

    val logo = painterResource(R.drawable.black_logo)

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF8CF0F0))
    ){
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome!",
                fontSize = 35.sp,
                color = Color.Black,
                fontFamily = titleFont,
                modifier = Modifier.padding(top = 200.dp)
            )
            Button(
                onClick = onRegistrationClicked,
                colors = ButtonDefaults.buttonColors(Color(0xFF08065E)),
                modifier = Modifier
                    .padding(top = 50.dp)
                    .widthIn(320.dp)
                    .heightIn(70.dp)
            ) {
                Text(
                    text = "Register",
                    fontSize = 35.sp,
                    color = Color.White,
                    fontFamily = font
                )
            }
            Button(
                onClick = onLoginClicked,
                colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                modifier = Modifier
                    .padding(top = 15.dp)
                    .widthIn(320.dp)
                    .heightIn(70.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 35.sp,
                    color = Color.Black,
                    fontFamily = font
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ExerciseAppTheme {
        StartingPage({},{})
    }
}