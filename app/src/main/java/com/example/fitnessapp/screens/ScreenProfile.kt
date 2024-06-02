package com.example.fitnessapp.screens

import com.example.fitnessapp.ui.theme.FitnessAppTheme
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessapp.R
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenProfile(navController: NavController) {
    var showLogoutDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF212121))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .background(Color(0xFF9c92f7))
            ) {
                // My Profile button
                Text(
                    text = "< My Profile",
                    color = Color.White,
                    modifier = Modifier
                        .clickable { navController.navigateUp() }
                        .padding(start = 16.dp, top = 16.dp)
                )

                // Profile Picture
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.Center)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "Profile Picture",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Gray, CircleShape)
                    )
                }

                // User Info
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 190.dp)  // Positioning under the picture
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Your Name",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "example@example.com",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Birthday: April 1st",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                // Overlapping Rectangle
                Box(
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp)
                        .background(Color(0xFF7668ed), shape = RoundedCornerShape(16.dp))
                        .align(Alignment.BottomCenter)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "70kg",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Weight",
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .background(Color.White)
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "25",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Years Old",
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .background(Color.White)
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "180cm",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Height",
                                color = Color.White
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp),  // Spacing to move below the overlapping rectangle
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ClickableRowItem(navController, Icons.Default.AccountCircle, "Profile")
                ClickableRowItem(navController, Icons.Default.Lock, "Privacy Policy")
                ClickableRowItem(navController, Icons.Default.Settings, "Settings")
                ClickableRowItem(navController, Icons.Default.ExitToApp, "Logout") {
                    showLogoutDialog = true
                }
            }
        }

        if (showLogoutDialog) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { showLogoutDialog = false }
            ) {}

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)
                    .background(Color(0xFFaca3ff), shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Are you sure you want to log out?",
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { showLogoutDialog = false },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(text = "Cancel", color = Color.Black)
                        }
                        Button(
                            onClick = {
                                showLogoutDialog = false
                                // Handle the logout action here
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(text = "Yes, logout", color = Color.Black)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ClickableRowItem(navController: NavController, icon: ImageVector, text: String, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF7668ed),
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(0xFF7668ed).copy(alpha = 0.2f))
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, color = Color.White, modifier = Modifier.weight(1f))
        Text(text = ">", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenProfilePreview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        ScreenProfile(navController)
    }
}