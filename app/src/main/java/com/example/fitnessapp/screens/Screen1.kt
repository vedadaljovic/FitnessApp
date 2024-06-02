package com.example.fitnessapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.ui.theme.FitnessAppTheme

@Composable
fun Screen1(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF212121))
    ) {
        // Image taking up 55-60% of the screen
        Image(
            painter = painterResource(id = R.drawable.girl_working_out), // Replace with your image resource
            contentDescription = "Girl Working Out",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.6f)
        )

        // Motivational quote
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Consistency Is",
                fontSize = 26.sp,
                color = Color(0xFFEDFF63),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "The Key To Progress",
                fontSize = 26.sp,
                color = Color(0xFFEDFF63),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Don't Give Up",
                fontSize = 26.sp,
                color = Color(0xFFEDFF63),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        // Placeholder for additional text
        Box(
            modifier = Modifier
                .background(color = Color(0xFF9c92f7)) // Purple color
                .padding(16.dp),
            contentAlignment = Alignment.Center // Center content inside the Box
        ) {
            Text(
                text = "Explore meal plans, use the BMI calculator, access gym memberships, and more in our fitness app.",
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center, // Center the text horizontally
                modifier = Modifier
                    .align(Alignment.Center) // Align the text content to center
            )
        }

        Spacer(modifier = Modifier.weight(0.2f))

        // Next button
            Button(
                onClick = { navController.navigate("Screen2") },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
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
    }
}
@Preview(showBackground = true)
@Composable
fun Screen1Preview() {
    val navController = rememberNavController() // Create a mock NavController for preview
    FitnessAppTheme {
        Screen1(navController)
    }
}
