package com.example.fitnessapp.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.fitnessapp.backend.viewmodel.UserViewModel
import kotlin.math.floor

private const val CM_TO_INCH = 0.393701

@SuppressLint("DefaultLocale")
@Composable
fun Screen5(navController: NavHostController) {
    // 1) Obtain the shared ViewModel (scoped to your navigation graph)
    val parentEntry = remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry("fitness_app_graph")
    }
    val userViewModel: UserViewModel = hiltViewModel(parentEntry)
    val currentUser by userViewModel.currentUser.collectAsState()

    // 2) Keep two separate Double states: one in cm (0.0..250.0), one in inches (0.0..107.0)
    var selectedHeightCm by remember { mutableStateOf(150.0) }
    var selectedHeightInches by remember { mutableStateOf(150.0 * CM_TO_INCH) }
    var isCm by remember { mutableStateOf(true) }

    // 3) When the user object loads (or changes), initialize both states:
    LaunchedEffect(currentUser) {
        currentUser?.height?.let { dbHeightCm ->
            if (dbHeightCm > 0.0) {
                val cm = dbHeightCm.coerceIn(0.0, 250.0)
                selectedHeightCm = cm
                selectedHeightInches = (cm * CM_TO_INCH).coerceIn(0.0, (8 * 12 + 11).toDouble())
                Log.d("Screen5", "Loaded from DB → $cm cm / ${selectedHeightInches} in")
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF212121))
    ) {
        // ← Back button
        Text(
            text = "< Back",
            color = Color(0xFFEDFF63),
            modifier = Modifier
                .clickable { navController.navigateUp() }
                .padding(start = 16.dp, top = 16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Title
            Text(
                text = "What Is Your Height?",
                color = Color.White,
                fontSize = 35.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Unit toggle buttons: CM vs Ft & In
            Row(modifier = Modifier.padding(bottom = 16.dp)) {
                Button(
                    onClick = {
                        if (!isCm) {
                            // Convert from inches → cm when switching back
                            selectedHeightCm = (selectedHeightInches / CM_TO_INCH).coerceIn(0.0, 250.0)
                        }
                        isCm = true
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isCm) Color(0xFFEDFF63) else Color(0xFF3D3D3D),
                        contentColor = Color(0xFF9C92F7)
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text("CM")
                }

                Button(
                    onClick = {
                        if (isCm) {
                            // Convert from cm → inches when switching
                            selectedHeightInches = (selectedHeightCm * CM_TO_INCH).coerceIn(
                                0.0,
                                (8 * 12 + 11).toDouble()
                            )
                        }
                        isCm = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!isCm) Color(0xFFEDFF63) else Color(0xFF3D3D3D),
                        contentColor = Color(0xFF9C92F7)
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text("Ft & In")
                }
            }

            // 4) Show a Slider in the chosen unit
            if (isCm) {
                // CM slider: range 0.0..250.0
                Text(
                    text = String.format("%.1f CM", selectedHeightCm),
                    color = Color.White,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Slider(
                    value = selectedHeightCm.toFloat(),
                    onValueChange = { newValue ->
                        selectedHeightCm = newValue.toDouble().coerceIn(0.0, 250.0)
                    },
                    valueRange = 0f..250f,
                    steps = 249, // each step ≈ 1 cm
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
            } else {
                // Inches slider: range 0.0..107.0 (max 8 ft 11 in)
                Text(
                    text = convertInchesToFeetAndInches(selectedHeightInches),
                    color = Color.White,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Slider(
                    value = selectedHeightInches.toFloat(),
                    onValueChange = { newValue ->
                        selectedHeightInches =
                            newValue.toDouble().coerceIn(0.0, (8 * 12 + 11).toDouble())
                    },
                    valueRange = 0f..((8 * 12 + 11).toFloat()),
                    steps = (8 * 12 + 11) - 1, // each step ≈ 1 inch
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
            }
        }

        // 5) Continue button at bottom
        Button(
            onClick = {
                Log.d("Screen5", "Continue pressed.")
                currentUser?.let { user ->
                    // Decide which value to store (always store cm in DB)
                    val heightToStoreCm = if (isCm) {
                        selectedHeightCm
                    } else {
                        (selectedHeightInches / CM_TO_INCH)
                    }
                    userViewModel.updateUserHeight(user.id, heightToStoreCm)
                    Log.d(
                        "Screen5",
                        "Updating user (${user.id}) height → $heightToStoreCm cm in DB"
                    )
                    navController.navigate("Screen6")
                } ?: run {
                    Log.d("Screen5", "No currentUser found on Continue.")
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
                .width(200.dp)
                .height(56.dp)
                .border(2.dp, Color.White, shape = RoundedCornerShape(28.dp))
                .padding(2.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3D3D3D))
        ) {
            Text(
                text = "Continue",
                fontSize = 24.sp,
                color = Color.White
            )
        }
    }
}

/** Helper: Convert a Double‐value in inches to a string "X' Y\"" */
private fun convertInchesToFeetAndInches(inches: Double): String {
    val total = inches.coerceAtLeast(0.0)
    val feet = floor(total / 12).toInt()
    val remInches = floor(total % 12).toInt()
    return "${feet}' ${remInches}\""
}
