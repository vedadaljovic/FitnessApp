package com.example.fitnessapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.backend.viewmodel.UserViewModel
import android.util.Log

@Composable
fun Screen7(navController: NavController) {
    val parentEntry = remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry("fitness_app_graph")
    }
    val userViewModel: UserViewModel = hiltViewModel(parentEntry)
    val currentUser by userViewModel.currentUser.collectAsState()

    var selectedButton by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(currentUser) {
        currentUser?.activityLevel?.let {
            if (it.isNotEmpty()) {
                selectedButton = it
                Log.d("Screen7", "Activity level initialized from currentUser: $it")
            }
        }
    }

    // List of button labels
    val buttons = listOf("Beginner", "Intermediate", "Advance")

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

        // Centered content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Physical Activity Level",
                color = Color.White,
                fontSize = 32.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            buttons.forEach { buttonLabel ->
                Button(
                    onClick = { selectedButton = buttonLabel },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 16.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedButton == buttonLabel) Color(0xFFEDFF63) else Color.White
                    ),
                    shape = RoundedCornerShape(36.dp)
                ) {
                    Text(
                        text = buttonLabel,
                        fontSize = 28.sp,
                        color = if (selectedButton == buttonLabel) Color.Black else Color(0xFF9c92f7)
                    )
                }
            }
        }

        // Continue button
        Button(
            onClick = {
                Log.d("Screen7", "Continue button clicked.")
                currentUser?.let { user ->
                    selectedButton?.let { activityLevel ->
                        if (activityLevel.isNotEmpty()) {
                            userViewModel.updateUserActivityLevel(user.id, activityLevel)
                            Log.d("Screen7", "Updating activity level to: $activityLevel for user ID: ${user.id}")
                            navController.navigate("Screen8")
                        } else {
                            Log.d("Screen7", "Selected activity level is empty.")
                        }
                    } ?: run {
                        Log.d("Screen7", "No activity level selected.")
                    }
                } ?: run {
                    Log.d("Screen7", "Continue button clicked, but currentUser is null.")
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .width(200.dp)
                .height(60.dp)
                .border(2.dp, Color.White, shape = RoundedCornerShape(28.dp))
                .padding(2.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3d3d3d))
        ) {
            Text(
                text = "Continue",
                fontSize = 28.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen7Preview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        Screen7(navController)
    }
}
