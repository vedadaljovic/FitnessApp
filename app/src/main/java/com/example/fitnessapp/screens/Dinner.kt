package com.example.fitnessapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
fun DinnerScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf("Dinner") }

    val tabColors = mapOf(
        "Breakfast" to Color(0xFFEDFF63),
        "Lunch" to Color(0xFFEDFF63),
        "Dinner" to Color(0xFFEDFF63)
    )

    //general column: screen size
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF212121))

    ){
        //1st Column with two rows - nav bars

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            //1st row: headline and icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ){
                //back triangle button
                IconButton(
                    onClick = { /* Handle back navigation */ },
                    modifier = Modifier.size(24.dp) // Adjust the size as needed
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back_arrow),
                        contentDescription = "Back",
                        tint = colorResource(id = R.color.lime),
                        modifier = Modifier.size(16.dp) // Adjust the size as needed
                    )
                }

                //headline
                Text(
                    text = "Meal Ideas",
                    color = colorResource(id= R.color.purple_headline),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start=8.dp, bottom = 16.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                //profile button
                IconButton(
                    onClick = { /* Navigate to profile */ },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.login),
                        contentDescription = "Profile",
                        tint = colorResource(id= R.color.purple_headline),
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                    )
                }
            }

            //2nd nav row: tabs/buttons

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                listOf("Breakfast", "Lunch", "Dinner").forEach { tab ->
                    Button(
                        onClick = { selectedTab = tab },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedTab == tab) tabColors[tab]!! else Color.White,
                            contentColor = if (selectedTab == tab) Color.Black else Color(0XFF896CFE)
                        ),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .padding(4.dp)
                            .weight(1f) // Equal width for all buttons
                            .height(30.dp) // Set a fixed height
                    ) {
                        Text(
                            text = tab,
                            fontWeight = if (selectedTab == tab) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 11.sp

                        )
                    }
                }
            }

            //still inside the inner column:

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
            ) {

                Text(
                    modifier = Modifier.padding(end = 30.dp),
                    text = "Chickpea salad",
                    color = Color(0xFFE2F163),
                    fontWeight = FontWeight.Normal,
                    fontSize=20.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            modifier = Modifier
                                .size(12.dp)
                                .padding(bottom = 1.dp, end = 4.dp),
                            painter = painterResource(id = R.drawable.ic_clock),
                            contentDescription = "25 Minutes",
                            tint = Color(0xFF6650a4)
                        )
                        Text(
                            text = "25 Minutes",
                            color = Color.White,
                            fontSize = 12.sp
                        )}
                }

                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier=Modifier.padding(start=12.dp, end=10.dp)
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(12.dp)
                                .padding(bottom = 1.dp, end = 3.dp),
                            painter = painterResource(id = R.drawable.ic_calories),
                            contentDescription = "300 Cal",
                            tint = Color(0xFF6650a4)
                        )
                        Text(
                            text = "300 Cal",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }


            }

            Spacer(modifier = Modifier.height(10.dp))

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB3A0FF))
                .padding(vertical = 20.dp, horizontal = 20.dp)
                .height(350.dp)
                .clip(RoundedCornerShape(40.dp))

        ) {

            Image(
                painter = painterResource(id = R.drawable.salad),
                contentDescription = "Salad",
                modifier = Modifier
                    .height(350.dp)
                    .width(500.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Ingredients",
                color = Color(0xFFE2F163),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "- 1 cup cooked chickpeas",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                )

                Text(
                    text = "- 1 tomato cut into cubes",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                )

                Text(
                    text = "- sliced cucumber",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                )

                Text(
                    text = "- chopped red onion",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                )

                Text(
                    text = "- chopped fresh parsley",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                )

                Text(
                    text = "- 1 tablespoon balsamic vinegar",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                )

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DinnerScreenPreview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        DinnerScreen(navController)
    }
}