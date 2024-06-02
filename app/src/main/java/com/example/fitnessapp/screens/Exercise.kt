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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.R

@Composable
fun Exercise(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
    ) {
        // Navigation Bar
        CustomTopAppBar(
            title = "Weekly Challenge",
            onBackClick = { /* Handle back button click */ },
            onProfileClick = { /* Handle profile button click */ }
        )

        Image(
            painter = painterResource(id = R.drawable.exedescription),
            contentDescription = "Exercise Description",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 1.dp)
                .height(220.dp)
        )

        ExerciseRound(
            title = "Exercises",
            imageId = R.drawable.exercise
        )


        Button(
            onClick = { navController.navigate("Challenge") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Done")
        }
    }
}


@Composable
fun CustomTopAppBar(
    title: String,
    onBackClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E1E1E))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back Button
            Image(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = "Back",
                modifier = Modifier
                    .size(20.dp)
                    .clickable { onBackClick.invoke() }
            )

            Spacer(modifier = Modifier.width(13.dp))

            // Title
            Text(
                text = title,
                color = Color(0xFF896CFE),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Profile Icon
            val profileTint = ColorFilter.tint(Color(0xFF896CFE))
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onProfileClick.invoke() },
                colorFilter = profileTint
            )
        }
    }
}

@Composable
fun ExerciseRound(title: String, imageId: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Title
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            color = Color.Yellow,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        // Image
        Image(
            painter = painterResource(id = imageId),
            contentDescription = title,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
@Preview
fun PreviewExerciseScreen() {
    val navController = rememberNavController()
    Exercise(navController)
}
