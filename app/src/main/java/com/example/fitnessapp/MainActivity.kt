package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.backend.model.UserRepository
import com.example.fitnessapp.backend.viewmodel.UserViewModel
import com.example.fitnessapp.backend.viewmodel.UserViewModelFactory
import com.example.fitnessapp.screens.*
import com.example.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val userDao = (application as MyApplication).database.userDao()
            val repository = UserRepository(userDao)
            val userViewModel: UserViewModel = viewModel(factory = UserViewModelFactory(repository))

            FitnessApp(userViewModel)
        }
    }
}

@Composable
fun FitnessApp(userViewModel: UserViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ScreenStart1") {
        composable("ScreenStart1") {
            ScreenStart1(navController)
        }
        composable("ScreenStart2") {
            ScreenStart2(navController)
        }
        composable("ScreenStart3") {
            ScreenStart3(navController)
        }
        composable("ScreenStart4") {
            ScreenStart4(navController)
        }
        composable("LoginScreen") {
            LoginScreen(navController, userViewModel)
        }
        composable("ScreenRegister") {
            ScreenRegister(navController)
        }
        composable("Screen1") {
            FitnessAppContent(navController)
        }
        composable("Screen2") {
            Screen2(navController)
        }
        composable("Screen3") {
            Screen3(navController)
        }
        composable("Screen4") {
            Screen4(navController)
        }
        composable("Screen5") {
            Screen5(navController)
        }
        composable("Screen6") {
            Screen6(navController)
        }
        composable("Screen7") {
            Screen7(navController)
        }
        composable("Screen8") {
            Screen8(navController)
        }
        composable("Screen9") {
            Screen9(navController)
        }
        composable("WeeklyOne") {
            WeeklyOne(navController)
        }
        composable("CenterAlignedTopAppBarExample") {
            CenterAlignedTopAppBarExample(navController)
        }
        composable("Articles") {
            Articles(navController)
        }
        composable("Rec2") {
            Rec2(navController)
        }
        composable("Exercise") {
            Exercise(navController)
        }
        composable("Challenge") {
            Challenge(navController)
        }
        composable("BreakfastScreen") {
            BreakfastScreen(navController)
        }
        composable("DinnerScreen") {
            DinnerScreen(navController)
        }
        composable("IntermediateScreen") {
            IntermediateScreen(navController)
        }
        composable("LunchScreen") {
            LunchScreen(navController)
        }
        composable("MealsHomeScreen") {
            MealsHomeScreen(navController)
        }
        composable("BeginnerScreen") {
            BeginnerScreen(navController)
        }
    }
}

@Composable
fun FitnessAppContent(navController: NavController) {
    FitnessAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Screen1(navController)
        }
    }
}
