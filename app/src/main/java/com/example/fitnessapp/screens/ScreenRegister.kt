package com.example.fitnessapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fitnessapp.R
import com.example.fitnessapp.backend.model.User
import com.example.fitnessapp.backend.viewmodel.UserViewModel
import com.example.fitnessapp.ui.theme.FitnessAppTheme

@Composable
fun ScreenRegister(navController: NavController, userViewModel: UserViewModel = hiltViewModel()) {
    var name by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var passwordConfirmed by remember { mutableStateOf(TextFieldValue()) }
    var registrationError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF212121)),
        horizontalAlignment = Alignment.CenterHorizontally // Align children horizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "<",
                style = TextStyle(fontSize = 24.sp, color = Color(0xFFEDFF63)),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable(onClick = { /*navController.navigateUp()*/ })
                    .padding(start = 16.dp)
            )
            Text(
                text = "Create Account",
                style = TextStyle(fontSize = 24.sp, color = Color(0xFFEDFF63)),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Text(
            text = "Let's Start!",
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(410.dp)
                .background(color = Color(0xFF9c92f7))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    text = "Full name",
                    style = TextStyle(fontSize = 18.sp, color = Color.Black)
                )

                TextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    placeholder = { Text(text = "John Doe") },
                    textStyle = TextStyle(color = Color.Black)
                )
                Text(
                    text = "Email",
                    style = TextStyle(fontSize = 18.sp, color = Color.Black)
                )

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    placeholder = { Text(text = "example@example.com") },
                    textStyle = TextStyle(color = Color.Black)
                )

                Text(
                    text = "Password",
                    style = TextStyle(fontSize = 18.sp, color = Color.Black)
                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    placeholder = { Text(text = "***********") },
                    textStyle = TextStyle(color = Color.White)
                )
                Text(
                    text = "Confirm Password",
                    style = TextStyle(fontSize = 18.sp, color = Color.Black)
                )

                TextField(
                    value = passwordConfirmed,
                    onValueChange = { passwordConfirmed = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    placeholder = { Text(text = "***********") },
                    textStyle = TextStyle(color = Color.White)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .padding(top = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally // Align children horizontally
            ) {
                Text(
                    text = "By continuing, you agree to",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Row(
                    horizontalArrangement = Arrangement.Center // Align Row content horizontally
                ) {
                    Text(
                        text = "Terms of Use",
                        color = Color(0xFFEDFF63),
                        fontSize = 16.sp,
                        modifier = Modifier.clickable { /* Handle terms of use click */ }
                    )
                    Text(
                        text = " and ",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Privacy Policy",
                        color = Color(0xFFEDFF63),
                        fontSize = 16.sp,
                        modifier = Modifier.clickable { /* Handle privacy policy click */ }
                    )
                }
            }
        }

        Button(
            onClick = {
                if (name.text.isBlank() || email.text.isBlank() || password.text.isBlank() || passwordConfirmed.text.isBlank()) {
                    registrationError = "Sva polja moraju biti popunjena."
                } else if (password.text != passwordConfirmed.text) {
                    registrationError = "Lozinke se ne podudaraju."
                } else {
                    registrationError = null
                    val newUser = User(
                        username =  name.text,
                        fullName = name.text,
                        email = email.text,
                        password = password.text
                    )
                    userViewModel.insertUser(newUser)
                    navController.navigate("LoginScreen")
                }
            },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .width(200.dp)
                .height(60.dp)
                .border(2.dp, Color.White, shape = RoundedCornerShape(28.dp))
                .padding(2.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3d3d3d))
        ) {
            Text(
                text = "Sign Up",
                fontSize = 28.sp,
                color = Color.White
            )
        }

        registrationError?.let {
            Text(
                text = it,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Text(
            text = "or sign up with",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            CircleButtons(imageId = R.drawable.gmail)
            Spacer(modifier = Modifier.width(16.dp))
            CircleButtons(imageId = R.drawable.facebook)
            Spacer(modifier = Modifier.width(16.dp))
            CircleButtons(imageId = R.drawable.apple)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Already have an account? ",
                color = Color.White,
                fontSize = 16.sp
            )
            Text(
                text = "Log in",
                color = Color(0xFFEDFF63),
                fontSize = 16.sp,
                modifier = Modifier.clickable { navController.navigate("LoginScreen") }
            )
        }
    }
}

@Composable
fun CircleButtons(imageId: Int) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.White)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenRegisterPreview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        ScreenRegister(navController)
    }
}