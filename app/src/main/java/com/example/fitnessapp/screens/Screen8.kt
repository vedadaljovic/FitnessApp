package com.example.fitnessapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.backend.viewmodel.UserViewModel
import android.util.Log

@Composable
fun Screen8(navController: NavController) {
    val parentEntry = remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry("fitness_app_graph")
    }
    val userViewModel: UserViewModel = hiltViewModel(parentEntry)
    val currentUser by userViewModel.currentUser.collectAsState()

    var fullName by rememberSaveable { mutableStateOf("") }
    var nickname by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var mobileNumber by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(currentUser) {
        currentUser?.let {
            fullName = it.fullName ?: ""
            nickname = it.nickname ?: ""
            email = it.email ?: ""
            mobileNumber = it.mobileNumber ?: ""
            Log.d("Screen8", "Profile fields initialized from currentUser.")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF212121))
    ) {
        // Back button
        Text(
            text = "< Back",
            color = Color(0xFFEDFF63),
            modifier = Modifier
                .clickable { navController.navigateUp() }
                .padding(start = 16.dp, top = 16.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp)
        ) {
            Text(
                text = "Fill Your Profile",
                color = Color.White,
                fontSize = 32.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Complete your profile to get started.",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .padding(bottom = 24.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF9c92f7))
                    .padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.Center)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "Profile Picture",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Gray, CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color(0xFFEDFF63), CircleShape)
                            .align(Alignment.BottomEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(16.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Form fields
            FormField(
                label = "Full name",
                value = fullName,
                onValueChange = { fullName = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            FormField(
                label = "Nickname",
                value = nickname,
                onValueChange = { nickname = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            FormField(
                label = "Email",
                value = email,
                onValueChange = { email = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
            FormField(
                label = "Mobile number",
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done
                )
            )
        }

        // Continue button
        Button(
            onClick = {
                Log.d("Screen8", "Continue button clicked.")
                currentUser?.let { user ->
                    userViewModel.updateUserProfileDetails(
                        userId = user.id,
                        fullName = fullName.takeIf { it.isNotBlank() },
                        nickname = nickname.takeIf { it.isNotBlank() },
                        email = email.takeIf { it.isNotBlank() },
                        mobileNumber = mobileNumber.takeIf { it.isNotBlank() }
                    )
                    userViewModel.updateUserIsSetupComplete(user.id, true)
                    Log.d("Screen8", "Updating profile details for user ID: ${user.id} and setting isSetupComplete to true")
                    navController.navigate("Screen9")
                } ?: run {
                    Log.d("Screen8", "Continue button clicked, but currentUser is null.")
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .width(200.dp)
                .height(60.dp)
                .border(2.dp, Color.White, shape = RoundedCornerShape(28.dp))
                .padding(2.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEDFF63))
        ) {
            Text(
                text = "Continue",
                fontSize = 28.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun FormField(label: String, value: String, onValueChange: (String) -> Unit, keyboardOptions: KeyboardOptions) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = keyboardOptions,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Screen8Preview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        Screen8(navController)
    }
}
