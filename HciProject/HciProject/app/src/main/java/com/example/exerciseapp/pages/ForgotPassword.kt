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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exerciseapp.R
import com.example.exerciseapp.ui.theme.ExerciseAppTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ForgotPassword(
    onCancelClicked: () -> Unit,
    onChangeClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val font = FontFamily(Font(R.font.open_sans))
    val titleFont = FontFamily(Font(R.font.roboto))

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
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
            Image(
                painter = logo,
                contentDescription = null,
                modifier = Modifier.padding(50.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email",
                    fontFamily = font) },
                modifier = Modifier
                    .padding(top = 200.dp)
                    .widthIn(280.dp),
                placeholder = {
                    Text(text = "E-mail",
                        fontFamily = font)
                },
                leadingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = null
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                    FocusDirection.Down) }),
                singleLine = true,
                colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("New Password",
                    fontFamily = font) },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .widthIn(280.dp),
                placeholder = {
                    Text(text = "New Password",
                        fontFamily = font)
                },
                leadingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = null
                        )
                    }
                },
                trailingIcon = {
                    val visibilityIcon = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                    IconButton(
                        onClick = { passwordVisible = !passwordVisible },
                        content = {
                            Icon(
                                imageVector = visibilityIcon,
                                contentDescription = null
                            )
                        }
                    )
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    onChangeClicked()
                    keyboardController?.hide()
                }),
                singleLine = true,
                colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
            )
            Button(
                onClick = onChangeClicked,
                colors = ButtonDefaults.buttonColors(Color(0xFF08065E)),
                modifier = Modifier
                    .padding(top = 200.dp)
                    .widthIn(250.dp)
                    .heightIn(50.dp)
            ) {
                Text(
                    text = "Change Password",
                    fontSize = 20.sp,
                    fontFamily = font
                )
            }
            Button(
                onClick = onCancelClicked,
                colors = ButtonDefaults.buttonColors(Color(0xFF8CF0F0)),
                modifier = Modifier
                    .widthIn(200.dp)
                    .heightIn(50.dp)
            ) {
                Text(
                    text = "Cancel",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = font
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview12() {
    ExerciseAppTheme {
        ForgotPassword({},{})
    }
}