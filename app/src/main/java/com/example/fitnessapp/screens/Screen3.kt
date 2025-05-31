package com.example.fitnessapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.backend.viewmodel.UserViewModel
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import android.util.Log

@Composable
fun Screen3(navController: NavHostController) {
    val parentEntry = remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry("fitness_app_graph")
    }
    val userViewModel: UserViewModel = hiltViewModel(parentEntry)
    val currentUser by userViewModel.currentUser.collectAsState()

    var selectedAge by remember { mutableStateOf(currentUser?.age?.takeIf { it > 0 } ?: 18) }

    LaunchedEffect(currentUser) {
        currentUser?.age?.takeIf { it > 0 }?.let {
            if (selectedAge != it) {
                selectedAge = it
                Log.d("Screen3", "Selected age initialized/updated from currentUser: $it")
            }
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
                .align(Alignment.TopStart) // Poravnaj na vrh-lijevo unutar Box-a
        )

        // Central content
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "How Old Are You?",
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Display selected age above the slider box
            Text(
                text = selectedAge.toString(),
                color = Color(0xFFEDFF63),
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Arrow pointing to the selected age
            Text(
                text = "^",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Box around slider numbers
            Box(
                modifier = Modifier
                    .background(Color(0xFF9c92f7))
                    .padding(14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .pointerInput(Unit) {
                            detectHorizontalDragGestures { change, dragAmount ->
                                change.consume()
                                selectedAge = (selectedAge - dragAmount / 30).toInt().coerceIn(0, 100)
                            }
                        }
                        .padding(bottom = 16.dp)
                ) {
                    val range = (selectedAge - 2)..(selectedAge + 2)
                    range.forEach { age ->
                        Text(
                            text = age.toString(),
                            color = if (age == selectedAge) Color.White else Color(0xFF757575),
                            fontSize = if (age == selectedAge) 35.sp else 25.sp,
                            fontWeight = if (age == selectedAge) FontWeight.Bold else FontWeight.Normal,
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        }

        // Continue button
        Button(
            onClick = {
                Log.d("Screen3", "Continue button clicked.")
                Log.d("Screen3", "Current user: ${currentUser}")
                Log.d("Screen3", "Selected age: $selectedAge")

                currentUser?.let { user ->
                    Log.d("Screen3", "Current user is not null. User ID: ${user.id}")
                    // Provjeri da li su godine validne prije ažuriranja (npr. veće od 0)
                    if (selectedAge > 0) {
                        Log.d("Screen3", "Age selected: $selectedAge. Updating age for user ID: ${user.id}")
                        userViewModel.updateUserAge(user.id, selectedAge)
                        Log.d("Screen3", "Navigating to Screen4.")
                        navController.navigate("Screen4")
                    } else {
                        Log.d("Screen3", "Invalid age selected: $selectedAge. Please select a valid age.")
                    }
                } ?: run {
                    Log.d("Screen3", "Continue button clicked, but currentUser is null.")
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

@Preview( showBackground = true)
@Composable
fun Screen3Preview(){
    val navController = rememberNavController()
    FitnessAppTheme {
        Screen3(navController)
    }
}