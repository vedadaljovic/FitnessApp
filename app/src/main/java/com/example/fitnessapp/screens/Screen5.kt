package com.example.fitnessapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
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
fun Screen5(navController: NavHostController) {
    var selectedHeightCm by remember { mutableStateOf(150f) } // Default to 150 cm
    var selectedHeightInches by remember { mutableStateOf(60f) } // Default to 5 feet (60 inches)
    var isCm by remember { mutableStateOf(true) } // Default to CM

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
                text = "What Is Your Height?",
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Button(
                    onClick = { isCm = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isCm) Color(0xFFEDFF63) else Color(0xFF3d3d3d),
                        contentColor = Color(0xFF9c92f7)
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(text = "CM")
                }
                Button(
                    onClick = { isCm = false },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!isCm) Color(0xFFEDFF63) else Color(0xFF3d3d3d),
                        contentColor = Color(0xFF9c92f7)
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(text = "Ft & In")
                }
            }

            if (isCm) {
                HeightSelectorCm(
                    selectedHeight = selectedHeightCm,
                    onHeightChange = { selectedHeightCm = it }
                )
            } else {
                HeightSelectorInches(
                    selectedHeight = selectedHeightInches,
                    onHeightChange = { selectedHeightInches = it }
                )
            }

            // Display selected height
            Text(
                text = if (isCm) String.format("%.1f CM", selectedHeightCm) else convertInchesToFeetAndInches(selectedHeightInches),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
        }

        // Continue button
        Button(
            onClick = { navController.navigate("Screen6") },
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

@Composable
fun HeightSelectorCm(selectedHeight: Float, onHeightChange: (Float) -> Unit) {
    Box(
        modifier = Modifier
            .background(Color(0xFF9c92f7))
            .padding(8.dp)
            .size(50.dp, 350.dp) // Set the size to control the slider dimensions
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .pointerInput(Unit) {
                    detectVerticalDragGestures(
                        onVerticalDrag = { change, dragAmount ->
                            change.consume()
                            val adjustedDrag = dragAmount / 10f // Adjust sensitivity (optional)
                            val newHeight = (selectedHeight - adjustedDrag).coerceIn(0f, 250f)
                            onHeightChange(newHeight)
                        }
                    )
                }
        ) {
            val displayedHeights = selectedHeight.toInt() - 2..selectedHeight.toInt() + 2
            displayedHeights.forEach { height ->
                if (height in 0..250) {
                    val isMainTick = height % 10 == 0
                    val isMiddleTick = height == selectedHeight.toInt()
                    Text(
                        text = "⎯",
                        color = if (isMiddleTick) Color.Yellow else Color.White,
                        fontSize = if (isMainTick) 35.sp else 27.sp,
                        fontWeight = if (isMainTick) FontWeight.Bold else FontWeight.Normal,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth()
                    )
                }
            }

        }
    }
}

@Composable
fun HeightSelectorInches(selectedHeight: Float, onHeightChange: (Float) -> Unit) {
    Box(
        modifier = Modifier
            .background(Color(0xFF9c92f7))
            .padding(8.dp)
            .size(50.dp, 350.dp) // Set the size to control the slider dimensions
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .pointerInput(Unit) {
                    detectVerticalDragGestures(
                        onVerticalDrag = { change, dragAmount ->
                            change.consume()
                            val adjustedDrag = dragAmount / 10f // Adjust sensitivity (optional)
                            val newHeight = (selectedHeight - adjustedDrag).coerceIn(0f, (8 * 12 + 11).toFloat())
                            onHeightChange(newHeight)
                        }
                    )
                }
        ) {
            val displayedHeights = selectedHeight.toInt() - 2..selectedHeight.toInt() + 2
            displayedHeights.forEach { height ->
                if (height in 0..(8 * 12 + 11)) {
                    val isMainTick = height % 12 == 0
                    Text(
                        text = if (isMainTick) "⎯" else "⎯",
                        color = Color.White,
                        fontSize = if (isMainTick) 35.sp else 27.sp,
                        fontWeight = if (isMainTick) FontWeight.Bold else FontWeight.Normal,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

fun convertInchesToFeetAndInches(inches: Float): String {
    val feet = (inches / 12).toInt()
    val remainingInches = (inches % 12).toInt()
    return "$feet' $remainingInches\""
}

@Preview(showBackground = true)
@Composable
fun Screen5Preview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        Screen5(navController)
    }
}
