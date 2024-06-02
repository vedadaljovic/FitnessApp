package com.example.fitnessapp.screens

import androidx.compose.foundation.Image
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
fun IntermediateScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF212121))
    ) {
        Column(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //1st row: Workout and icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
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
                    text = "Intermediate",
                    color = colorResource(id = R.color.purple_headline),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 8.dp, bottom = 16.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                //profile button
                IconButton(
                    onClick = { /* Navigate to profile */ },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Profile",
                        tint = colorResource(id = R.color.purple_headline),
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .padding(bottom = 5.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //rectangle area with a picture..
        //box for overlapping of elements
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB3A0FF))
                .padding(vertical = 15.dp, horizontal = 28.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.intermediate),
                contentDescription = "Workout Image",
                modifier = Modifier
                    .height(200.dp)
                    .width(400.dp)
                    .clip(RoundedCornerShape(20.dp))
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(12.dp)
                                        .padding(bottom = 1.dp, end = 4.dp),
                                    painter = painterResource(id = R.drawable.ic_clock),
                                    contentDescription = "60 Minutes",
                                    tint = Color.White
                                )
                                Text(
                                    text = "60 Minutes",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(12.dp)
                                        .padding(bottom = 1.dp, end = 4.dp),
                                    painter = painterResource(id = R.drawable.ic_calories),
                                    contentDescription = "2500 Kcal",
                                    tint = Color.White
                                )
                                Text(
                                    text = "2500 Kcal",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }


                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(15.dp)
                                        .padding(bottom = 1.dp, end = 4.dp),
                                    painter = painterResource(id = R.drawable.ic_workout),
                                    contentDescription = "30 Exercises",
                                    tint = Color.White
                                )
                                Text(
                                    text = "30 Exercises",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }


                    }


                }

            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
        ) {
            Text(
                text = "Round1",
                color = Color(0xFFE2F163),
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(18.dp))

            //card1
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(70))
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp)
                            .clickable {
                                // Handle click event here
                            },
                        painter = painterResource(id = R.drawable.play_video),
                        contentDescription = "play",
                        tint = Color(0xFFE2F163)
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp, end = 5.dp)){

                        Text(
                            text = "Kettlebell Swing",
                            fontWeight = FontWeight.Medium
                        )
                        Row(
                            modifier = Modifier.padding(bottom = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(end = 6.dp),
                                painter = painterResource(id = R.drawable.ic_clock),
                                contentDescription = "clock",
                                tint = Color(0xFFB3A0FF)
                            )
                            Text(
                                text = "00:30"
                            )
                        }
                    }

                    Text(
                        text="Repetition 3x",
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .align(Alignment.Top),
                        color = Color(0xFF6650a4)
                    )
                }

            }
            //card2:

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(70))
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp),
                        painter = painterResource(id = R.drawable.play_video),
                        contentDescription = "play",
                        tint = Color(0xFFE2F163)
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp, end = 5.dp)){

                        Text(
                            text = "Shoulder Press",
                            fontWeight = FontWeight.Medium
                        )
                        Row(
                            modifier = Modifier.padding(bottom = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(end = 6.dp),
                                painter = painterResource(id = R.drawable.ic_clock),
                                contentDescription = "clock",
                                tint = Color(0xFFB3A0FF)
                            )
                            Text(
                                text = "00:15"
                            )
                        }
                    }

                    Text(
                        text="Repetition 3x",
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .align(Alignment.Top),
                        color = Color(0xFF6650a4)
                    )
                }

            }

            //card3:

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(70))
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp),
                        painter = painterResource(id = R.drawable.play_video),
                        contentDescription = "play",
                        tint = Color(0xFF6650a4)
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp, end = 5.dp)){

                        Text(
                            text = "Hamstring Curls",
                            fontWeight = FontWeight.Medium
                        )
                        Row(
                            modifier = Modifier.padding(bottom = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(end = 6.dp),
                                painter = painterResource(id = R.drawable.ic_clock),
                                contentDescription = "clock",
                                tint = Color(0xFFB3A0FF)
                            )
                            Text(
                                text = "00:30"
                            )
                        }
                    }

                    Text(
                        text="Repetition 4x",
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .align(Alignment.Top),
                        color = Color(0xFF6650a4)
                    )
                }

            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Round2",
                color = Color(0xFFE2F163),
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(18.dp))

            //card4

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(70))
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp),
                        painter = painterResource(id = R.drawable.play_video),
                        contentDescription = "play",
                        tint = Color(0xFF6650a4)
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp, end = 5.dp)){

                        Text(
                            text = "Bicep Curls",
                            fontWeight = FontWeight.Medium
                        )
                        Row(
                            modifier = Modifier.padding(bottom = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(end = 6.dp),
                                painter = painterResource(id = R.drawable.ic_clock),
                                contentDescription = "clock",
                                tint = Color(0xFFB3A0FF)
                            )
                            Text(
                                text = "00:10"
                            )
                        }
                    }

                    Text(
                        text="Repetition 3x",
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .align(Alignment.Top),
                        color = Color(0xFF6650a4)
                    )
                }

            }

            //card 5

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(70))
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp),
                        painter = painterResource(id = R.drawable.play_video),
                        contentDescription = "play",
                        tint = Color(0xFF6650a4)
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp, end = 5.dp)){

                        Text(
                            text = "Barbell Deadlift",
                            fontWeight = FontWeight.Medium
                        )
                        Row(
                            modifier = Modifier.padding(bottom = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(end = 6.dp),
                                painter = painterResource(id = R.drawable.ic_clock),
                                contentDescription = "clock",
                                tint = Color(0xFFB3A0FF)
                            )
                            Text(
                                text = "00:15"
                            )
                        }
                    }

                    Text(
                        text="Repetition 4x",
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .align(Alignment.Top),
                        color = Color(0xFF6650a4)
                    )
                }

            }

        }




    }
}

@Preview(showBackground = true)
@Composable
fun IntermediateScreenPreview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        IntermediateScreen(navController)
    }
}
