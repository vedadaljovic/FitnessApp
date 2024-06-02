package com.example.fitnessapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.ui.theme.FitnessAppTheme

@Composable
fun Screen6(navController: NavController) {
    // State to track the selected option
    var selectedOption by remember { mutableStateOf<String?>(null) }

    // List of options
    val options = listOf("Lose Weight", "Gain Weight", "Muscle Mass Gain", "Shape Body", "Others")

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
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(56.dp))

            Text(
                text = "What is Your Goal?",
                color = Color.White,
                fontSize = 32.sp,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF9c92f7))
                    .padding(25.dp)
            ) {
                Column {
                    options.forEach { option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp)
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .clickable { selectedOption = option }
                        ) {
                            Text(
                                text = option,
                                color = Color.Black,
                                modifier = Modifier.padding(16.dp)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                modifier = Modifier
                                    .padding(end = 16.dp)
                                    .size(24.dp)
                                    .border(2.dp, if (selectedOption == option) Color.Black else Color.Gray, CircleShape)
                                    .background(if (selectedOption == option) Color.Black else Color.Transparent, CircleShape)
                            )
                        }
                    }
                }
            }
        }

        // Continue button
        Button(
            onClick = { navController.navigate("Screen7") },
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
fun Screen6Preview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        Screen6(navController)
    }
}
