package com.example.fitnessapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.R

@Composable
fun WeeklyOne(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB3A0FF))
    ) {

        Image(
            painter = painterResource(id = R.drawable.weekly),
            contentDescription = "Weekly",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Image(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .padding(16.dp)
                .size(20.dp)
                .align(Alignment.TopStart)
                .clickable(onClick = { /* Handle arrow button click */ })
        )


        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1.8f))

                Button(
                    onClick = { navController.navigate("Exercise") },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Start Now")
                }

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
@Preview
fun View() {
    val navController = rememberNavController()
    WeeklyOne(navController)
}
