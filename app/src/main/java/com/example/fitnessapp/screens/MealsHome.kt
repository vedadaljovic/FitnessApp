package com.example.fitnessapp.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.screens.IntermediateScreen
import com.example.fitnessapp.ui.theme.FitnessAppTheme


@Composable

fun MealsHomeScreen(navController: NavController) {
    Box(
        modifier=Modifier.fillMaxSize()
    ){
        val painter: Painter = painterResource(id = R.drawable.food)
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)) // Adjust transparency here
                .padding(16.dp)
        ){
            Card(
                modifier=Modifier
                    .fillMaxWidth(),
                shape= RoundedCornerShape(20.dp)
            ){
                Column{
                    Image(
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = "Meal Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(Color(0xFF6650a4)),
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Meal Ideas",
                            style = androidx.compose.ui.text.TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            ))
                        Text(
                            text = "Choose the diet plan that is most suitable to your needs and personal fitness goal",
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 16.sp
                            )
                        )
                        Button(
                            onClick = { /* TODO: Handle click */ },
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .graphicsLayer(alpha = 0.9f) // adjusting alpha for transparency
                                .graphicsLayer(
                                    scaleX = 1.1f,
                                    scaleY = 1.1f
                                )
                                .graphicsLayer {
                                    this.clip = true
                                },
                            shape = CircleShape
                        ) {
                            Text("Discover")
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MealsHomeScreenPreview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        MealsHomeScreen(navController)
    }
}