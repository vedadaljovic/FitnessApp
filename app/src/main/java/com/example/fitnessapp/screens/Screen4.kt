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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.ui.theme.FitnessAppTheme

@SuppressLint("DefaultLocale")
@Composable
fun Screen4(navController: NavHostController) {
    var selectedWeight by remember { mutableFloatStateOf(50f) } // Default to 50
    var isKg by remember { mutableStateOf(true) } // Default to KG

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
                                val unitRange = if (isKg) 0..250 else 0..551
                                selectedWeight = (selectedWeight - dragAmount / 30).coerceIn(unitRange.first.toFloat(), unitRange.last.toFloat())
                            }
                        }
                        .padding(bottom = 8.dp)
                ) {
                    val unitRange = if (isKg) 0..250 else 0..551
                    val displayedWeights = (selectedWeight - 2).toInt()..(selectedWeight + 2).toInt()

                    displayedWeights.forEach { weight ->
                        if (weight in unitRange) {
                            val isMainTick = weight % 5 == 0
                            Text(
                                text = if (isMainTick) "│" else "│",
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
            onClick = { navController.navigate("Screen5") },
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
