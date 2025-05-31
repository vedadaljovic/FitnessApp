package com.example.fitnessapp.screens

import android.annotation.SuppressLint
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
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.backend.viewmodel.UserViewModel
import android.util.Log

@SuppressLint("DefaultLocale")
@Composable
fun Screen4(navController: NavHostController) {
    val parentEntry = remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry("fitness_app_graph")
    }
    val userViewModel: UserViewModel = hiltViewModel(parentEntry)
    val currentUser by userViewModel.currentUser.collectAsState()

    var selectedWeight by remember { mutableDoubleStateOf(50.0) } // Default to 50.0
    var isKg by remember { mutableStateOf(true) } // Default to KG

    LaunchedEffect(currentUser, isKg) {
        currentUser?.weight?.let {
            val weightInKg = it
            selectedWeight = if (isKg) {
                weightInKg
            } else {
                weightInKg * 2.20462
            }
            Log.d("Screen4", "Selected weight initialized/updated from currentUser: $selectedWeight ${if (isKg) "KG" else "LB"}")
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

        // Central content
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "What Is Your Weight?",
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Button(
                    onClick = { isKg = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isKg) Color(0xFFEDFF63) else Color(0xFF3d3d3d),
                        contentColor = Color(0xFF9c92f7)
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(text = "KG")
                }
                Button(
                    onClick = { isKg = false },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!isKg) Color(0xFFEDFF63) else Color(0xFF3d3d3d),
                        contentColor = Color(0xFF9c92f7)
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(text = "LB")
                }
            }

            // Box around slider lines
            Box(
                modifier = Modifier
                    .background(Color(0xFF9c92f7))
                    .padding(18.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .pointerInput(Unit) {
                            detectHorizontalDragGestures { change, dragAmount ->
                                change.consume()
                                // Adjust sensitivity by dividing dragAmount by a larger number
                                val unitRangeEnd = if (isKg) 250.0 else 551.0 // Max KG or LB
                                val newWeight = selectedWeight - dragAmount / 30.0
                                selectedWeight = newWeight.coerceIn(0.0, unitRangeEnd)
                            }
                        }
                        .padding(bottom = 8.dp)
                ) {
                    val unitRangeStart = 0
                    val unitRangeEnd = if (isKg) 250 else 551 // For display ticks
                    val displayedWeights = (selectedWeight.toInt() - 2)..(selectedWeight.toInt() + 2)

                    displayedWeights.forEach { weight ->
                        if (weight in unitRangeStart..unitRangeEnd) {
                            val isMainTick = weight % 5 == 0
                            Text(
                                text = if (isMainTick) "│" else "│", // Same symbol for now, differentiation by size/weight
                                color = Color.White,
                                fontSize = if (isMainTick) 24.sp else 16.sp,
                                fontWeight = if (isMainTick) FontWeight.Bold else FontWeight.Normal,
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                            )
                        }
                    }
                }
            }

            // Display selected weight
            Text(
                text = String.format("%.1f %s", selectedWeight, if (isKg) "KG" else "LB"),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
        }

        // Continue button
        Button(
            onClick = {
                Log.d("Screen4", "Continue button clicked.")
                currentUser?.let { user ->
                    val weightToStore = if (isKg) {
                        selectedWeight
                    } else {
                        selectedWeight / 2.20462 // Convert lbs to kg for storing
                    }
                    userViewModel.updateUserWeight(user.id, weightToStore)
                    Log.d("Screen4", "Updating weight to: $weightToStore KG for user ID: ${user.id}")
                    navController.navigate("Screen5")
                } ?: run {
                    Log.d("Screen4", "Continue button clicked, but currentUser is null.")
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
fun Screen4Preview(){
    val navController = rememberNavController()
    FitnessAppTheme {
        Screen4(navController)
    }
}
