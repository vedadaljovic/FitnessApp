package com.example.fitnessapp.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.ui.theme.FitnessAppTheme

@Composable
fun Screen9(navController: NavController) {
    var selectedButton by remember { mutableStateOf("") }

    val defaultColor = Color(0xFF9c92f7)
    val pressedColor = Color(0xFFEDFF63)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF212121))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = "Hi, Your Name",
                        color = Color(0xFF7668ed),
                        fontSize = 24.sp
                    )
                    Text(
                        text = "It's time to challenge your limits.",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                IconButton(
                    onClick = { /* Navigate to profile */ },
                    modifier = Modifier.background(Color(0xFF7668ed), shape = CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Profile",
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable {
                            selectedButton = "Workout"
                        }
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_dumbbell),
                        contentDescription = "Workout",
                        tint = if (selectedButton == "Workout") pressedColor else defaultColor
                    )
                    Text(
                        text = "Workout",
                        color = if (selectedButton == "Workout") pressedColor else defaultColor
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable {
                            selectedButton = "Progress Tracking"
                        }
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_note),
                        contentDescription = "Progress Tracking",
                        tint = if (selectedButton == "Progress Tracking") pressedColor else defaultColor
                    )
                    Text(
                        text = "Progress Tracking",
                        color = if (selectedButton == "Progress Tracking") pressedColor else defaultColor
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable {
                            selectedButton = "Nutrition"
                        }
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_apple),
                        contentDescription = "Nutrition",
                        tint = if (selectedButton == "Nutrition") pressedColor else defaultColor
                    )
                    Text(
                        text = "Nutrition",
                        color = if (selectedButton == "Nutrition") pressedColor else defaultColor
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Recommendations",
                color = pressedColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .background(Color.Unspecified, shape = RoundedCornerShape(8.dp))
                        .border(1.dp, Color(0xFF7668ed), shape = RoundedCornerShape(24.dp))
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.party_workout),
                            contentDescription = "Squat Exercise",
                            modifier = Modifier
                                .size(100.dp)
                                .clickable { navController.navigate("CenterAlignedTopAppBarExample") }
                        )
                        Text(
                            text = "Squat Exercise",
                            color = pressedColor,
                            modifier = Modifier
                                .clickable { navController.navigate("CenterAlignedTopAppBarExample") }

                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .padding(top = 5.dp),
                                    painter = painterResource(id = R.drawable.ic_clock),
                                    contentDescription = "12 Minutes",
                                    tint = defaultColor
                                )
                                Text(
                                    text = "12 Minutes",
                                    fontSize = 14.sp,
                                    color = defaultColor
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .padding(top = 5.dp),
                                    painter = painterResource(id = R.drawable.ic_fire),
                                    contentDescription = "120 Kcal",
                                    tint = defaultColor
                                )
                                Text(
                                    text = "120 Kcal",
                                    fontSize = 14.sp,
                                    color = defaultColor
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                        .background(Color.Unspecified, shape = RoundedCornerShape(8.dp))
                        .border(1.dp, Color(0xFF7668ed), shape = RoundedCornerShape(24.dp))
                ) {
                    // Similar content as the first box, just duplicated for your modification
                    Column(
                        modifier = Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.woman_stretch),
                            contentDescription = "Squat Exercise",
                            modifier = Modifier
                                .size(100.dp)
                                .clickable { navController.navigate("Rec2") }
                        )
                        Text(
                            text = "Full Body Stretch",
                            color = pressedColor,
                            modifier = Modifier
                                .clickable { navController.navigate("Rec2") }
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .padding(top = 5.dp),
                                    painter = painterResource(id = R.drawable.ic_clock),
                                    contentDescription = "12 Minutes",
                                    tint = defaultColor
                                )
                                Text(
                                    text = "12 Minutes",
                                    fontSize = 14.sp,
                                    color = defaultColor
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .padding(top = 5.dp),
                                    painter = painterResource(id = R.drawable.ic_fire),
                                    contentDescription = "120 Kcal",
                                    tint = defaultColor
                                )
                                Text(
                                    text = "120 Kcal",
                                    fontSize = 14.sp,
                                    color = defaultColor
                                )
                            }
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(defaultColor)
                    .padding(vertical = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Weekly Challenge",
                            color = pressedColor,
                            fontSize = 24.sp
                        )
                        Text(
                            text = "Plank With Hip Twist",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.woman_plank),
                        contentDescription = "Plank",
                        modifier = Modifier
                            .weight(1f)
                            .size(105.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Articles & Tips",
                color = defaultColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .background(Color.Unspecified)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.woman_carrots),
                            contentDescription = "Supplement Guide",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(RoundedCornerShape(20))
                                .clickable { navController.navigate("Articles") }
                        )
                        Text(
                            text = "Supplement Guide",
                            fontSize = 12.sp,
                            color = defaultColor,
                            modifier = Modifier
                                .clickable { navController.navigate("Articles") }
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .background(Color.Unspecified)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.man_squat),
                            contentDescription = "15 Quick & Effective Daily Routines",
                            modifier = Modifier
                                .size(150.dp)
                                .clickable { navController.navigate("Articles") }
                        )
                        Text(
                            text = "15 Quick Daily Routines",
                            fontSize = 12.sp,
                            color = defaultColor,
                            modifier = Modifier
                                .clickable { navController.navigate("Articles") }
                        )
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Screen9Preview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        Screen9(navController)
    }
}