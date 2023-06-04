package com.example.exerciseapp.pages

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exerciseapp.R
import com.example.exerciseapp.ui.theme.ExerciseAppTheme

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DescriptionPage(
    onCancelClicked: () -> Unit,
    onSubmitClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val font = FontFamily(Font(R.font.open_sans))
    val titleFont = FontFamily(Font(R.font.roboto))

    val manIcon = painterResource(R.drawable.man_icon)

    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current
    val weightFocusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    Box (
        modifier = Modifier.background(color = Color(0xFF8CF0F0))
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Describe Yourself!",
                modifier = Modifier
                    .padding(top = 90.dp),
                fontSize = 30.sp,
                fontFamily = titleFont
            )
            Image(
                painter = manIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(width = 300.dp, height = 300.dp)
                    .padding(top = 40.dp)
            )
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = height,
                    onValueChange = { height = it },
                    label = { Text("Height (CM)",
                        fontFamily = font) },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .widthIn(100.dp),
                    placeholder = {
                        Text(text = "Height",
                            fontFamily = font)
                    },
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Right) }),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
                )
                OutlinedTextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Weight (KG)",
                        fontFamily = font) },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(start = 16.dp)
                        .widthIn(100.dp),
                    placeholder = {
                        Text(text = "Weight",
                            fontFamily = font)
                    },
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { weightFocusRequester.requestFocus() }),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
                )
            }
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = age,
                    onValueChange = { age = it },
                    label = { Text("Age",
                        fontFamily = font) },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .widthIn(100.dp)
                        .focusRequester(weightFocusRequester),
                    placeholder = {
                        Text(text = "Age",
                            fontFamily = font)
                    },
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Right) }),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
                )
                OutlinedTextField(
                    value = gender,
                    onValueChange = { gender = it },
                    label = { Text("Gender",
                        fontFamily = font) },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(start = 16.dp)
                        .widthIn(100.dp),
                    placeholder = {
                        Text(text = "Gender",
                            fontFamily = font)
                    },
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        onSubmitClicked()
                        keyboardController?.hide()
                    }),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
                )
            }
            Row (
                modifier = Modifier
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = onCancelClicked,
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .widthIn(150.dp)
                        .heightIn(50.dp)
                        .padding(end = 8.dp)
                ) {
                    Text(
                        text = "Go Back",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = font
                    )
                }
                Button(
                    onClick = onSubmitClicked,
                    colors = ButtonDefaults.buttonColors(Color(0xFF08065E)),
                    modifier = Modifier
                        .widthIn(150.dp)
                        .heightIn(50.dp)
                        .padding(start = 8.dp),
                ) {
                    Text(
                        text = "Submit",
                        fontSize = 20.sp,
                        fontFamily = font
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview5() {
    ExerciseAppTheme {
        DescriptionPage({},{})
    }
}