package com.example.fitnessapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R

import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.backend.dao.UserDao
import com.example.fitnessapp.backend.repository.UserRepository
import com.example.fitnessapp.backend.viewmodel.UserViewModel
import com.example.fitnessapp.backend.viewmodel.UserViewModelFactory

@Composable
fun LoginScreen(navController: NavController, userViewModel: UserViewModel) {
    var username by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var loginError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF212121))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
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
                    .clickable(onClick = { navController.navigateUp() })
                    .padding(start = 16.dp)
            )
            Text(
                text = "Log In",
                style = TextStyle(fontSize = 24.sp, color = Color(0xFFEDFF63)),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Text(
            text = "Welcome",
            color = Color.White,
            fontSize = 32.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Text(
            text = "Let's get moving, together.",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = Color(0xFF9c92f7))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Username or email",
                    style = TextStyle(fontSize = 18.sp, color = Color.Black)
                )

                TextField(
                    value = username,
                    onValueChange = { username = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    placeholder = { Text(text = "example@example.com") },
                    textStyle = TextStyle(color = Color.Black),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
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
                    textStyle = TextStyle(color = Color.Black),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )

                Text(
                    text = "Forgot Password",
                    style = TextStyle(fontSize = 16.sp, color = Color(0xFFEDFF63)),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clickable { /* Handle click action */ }
                        .align(Alignment.End)
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                userViewModel.login(username.text, password.text)
                loginError = userViewModel.currentUser == null
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
                text = "Next",
                fontSize = 28.sp,
                color = Color.White
            )
        }

        if (loginError) {
            Text(
                text = "Login failed. Please try again.",
                color = Color.Red,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        Text(
            text = "or sign up with",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            CircleButton(imageId = R.drawable.gmail)
            Spacer(modifier = Modifier.width(16.dp))
            CircleButton(imageId = R.drawable.facebook)
            Spacer(modifier = Modifier.width(16.dp))
            CircleButton(imageId = R.drawable.apple)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Don't have an account?",
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sign Up",
                color = Color(0xFFEDFF63),
                fontSize = 16.sp,
                modifier = Modifier.clickable {
                    navController.navigate("ScreenRegister")
                }
            )
        }
    }
}

@Composable
fun CircleButton(imageId: Int) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(Color(0xFF3d3d3d))
            .clickable { /* Handle click action */ }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    val mockNavController = rememberNavController()
//    val mockRepository = UserRepository(UserDao()) // Assuming you have a MockUserDao class
//
//    val mockUserViewModel = viewModel<UserViewModel>(factory = UserViewModelFactory(mockRepository))
//
//    FitnessAppTheme {
//        LoginScreen(mockNavController, mockUserViewModel)
//    }
//}
