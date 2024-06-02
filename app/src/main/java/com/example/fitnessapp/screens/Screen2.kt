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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.R
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Screen2(navController: NavController) {
    var selectedGender by remember { mutableStateOf(Gender.None) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF212121))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Back button
            Text(
                text = "< Back",
                color = Color(0xFFEDFF63),
                modifier = Modifier
                    .clickable { navController.navigateUp() }
                    .padding(vertical = 16.dp)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Start) // Align to the start to keep it at the top left
            )

            // "What's Your Gender" text
            Text(
                text = "What's Your Gender",
                color = Color.White,
                fontSize = 28.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )

            // Purple box with text about picking gender
            Box(
                modifier = Modifier
                    .fillMaxWidth() // Fill the entire width
                    .background(color = Color(0xFF9c92f7)) // Purple color
                    .padding(vertical = 16.dp), // Vertical padding only
                contentAlignment = Alignment.Center // Center content inside the Box
            ) {
                Text(
                    text = "Pick your gender to create a personalized plan",
                    fontSize = 16.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center, // Center the text horizontally
                )
            }


            Spacer(modifier = Modifier.height(60.dp))

            // Gender selection circles stacked vertically
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GenderCircle(
                    gender = Gender.Male,
                    selectedGender = selectedGender,
                    onClick = { selectedGender = Gender.Male }
                )
                Text(
                    text = "Male",
                    fontSize = 25.sp,
                    color = Color(0xFFEDFF63),
                    textAlign = TextAlign.Center // Center the text horizontally
                )
                Spacer(modifier = Modifier.height(25.dp))
                GenderCircle(
                    gender = Gender.Female,
                    selectedGender = selectedGender,
                    onClick = { selectedGender = Gender.Female }
                )
                Text(
                    text = "Female",
                    fontSize = 25.sp,
                    color = Color(0xFFEDFF63),
                    textAlign = TextAlign.Center // Center the text horizontally
                )
            }
        }

        // Continue button fixed at the bottom
        Button(
            onClick = { navController.navigate("Screen3") },
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
fun GenderCircle(
    gender: Gender,
    selectedGender: Gender,
    onClick: () -> Unit
) {
    val circleColor = if (selectedGender == gender) Color(0xFFEDFF63) else Color.White
    val icon = if (gender == Gender.Male) painterResource(id = R.drawable.male_gender) else painterResource(id = R.drawable.female_gender)

    Box(
        modifier = Modifier
            .size(150.dp)
            .background(circleColor, shape = CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center
        )
    }
}

enum class Gender {
    None,
    Male,
    Female
}

@Preview(showBackground = true)
@Composable
fun Screen2Preview(){
    val navController = rememberNavController()
    FitnessAppTheme {
        Screen2(navController)
    }
}
