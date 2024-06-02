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
fun BeginnerScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf("Beginner") }

    val tabColors = mapOf(
        "Beginner" to Color(0xFFEDFF63),
        "Intermediate" to Color(0xFFEDFF63),
        "Advanced" to Color(0xFFEDFF63)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF212121))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //1st row: Workout and icon
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
                    text = "Workout",
                    color = colorResource(id=R.color.purple_headline),
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
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Profile",
                        tint = colorResource(id=R.color.purple_headline),
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                    )
                }
            }

            //2nd row : tabs/buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                listOf("Beginner", "Intermediate", "Advanced").forEach { tab ->
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

            Spacer(modifier = Modifier.height(16.dp))

            //rectangle area with a picture..
            //box for overlapping of elements
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB3A0FF))
                    .padding(vertical = 18.dp, horizontal = 28.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.workout_image),
                    contentDescription = "Workout Image",
                    modifier = Modifier
                        .height(200.dp)
                        .clip(RoundedCornerShape(20.dp))
                )


                Row( modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.BottomCenter)
                ) {

                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(start = 24.dp),
                            text = "Functional training",
                            color = Color(0xFFE2F163),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Icon(
                                        modifier = Modifier
                                            .size(12.dp)
                                            .padding(bottom = 1.dp, end = 4.dp),
                                        painter = painterResource(id = R.drawable.ic_clock),
                                        contentDescription = "45 Minutes",
                                        tint = Color.White
                                    )
                                    Text(
                                        text = "45 Minutes",
                                        color = Color.White,
                                        fontSize = 12.sp
                                    )}
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
                                        contentDescription = "1450 Kcal",
                                        tint = Color.White
                                    )
                                    Text(
                                        text = "1450 Kcal",
                                        color = Color.White,
                                        fontSize = 12.sp
                                    )
                                }
                            }


                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(12.dp)
                                        .padding(bottom = 1.dp, end = 4.dp),
                                    painter = painterResource(id = R.drawable.ic_workout),
                                    contentDescription = "5 Exercises",
                                    tint = Color.White
                                )
                                Text(
                                    text = "5 Exercises",
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                            }
                            }


                        }


                    }

                }
            }



            Spacer(modifier = Modifier.height(24.dp))

            Column(modifier= Modifier
                .fillMaxWidth()
                .padding(start = 22.dp, end = 22.dp)){

                Text(
                    text = "Let's Go Beginner",
                    color = Color(0xFFE2F163),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Explore Different Workout Styles",
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Spacer(modifier=Modifier.height(10.dp))

                Card(modifier= Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(25)))
                {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column(
                            modifier = Modifier
                                .padding(start = 7.dp, top = 4.dp)
                        ) {
                            Text(
                                text = "Upper Body",
                                modifier = Modifier.padding(top = 13.dp),
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp,
                                color = Color.Black
                            )

                            Row(
                                modifier = Modifier
                                    .padding(start = 2.dp, top = 5.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(end = 10.dp)
                                    ) {
                                        Icon(
                                            modifier = Modifier
                                                .size(14.dp)
                                                .padding(end = 4.dp),
                                            painter = painterResource(id = R.drawable.ic_clock),
                                            contentDescription = "30 Minutes",
                                            tint = Color.Black
                                        )
                                        Text(
                                            text = "30 Minutes",
                                            color = Color.Black,
                                            fontSize = 12.sp,
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
                                                .size(14.dp)
                                                .padding(end = 4.dp),
                                            painter = painterResource(id = R.drawable.ic_calories),
                                            contentDescription = "1320 Kcal",
                                            tint = Color.Black
                                        )
                                        Text(
                                            text = "1320 Kcal",
                                            color = Color.Black,
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                            } // row in a column of a card

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,

                                    ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(14.dp)
                                            .padding(end = 4.dp),
                                        painter = painterResource(id = R.drawable.ic_workout),
                                        contentDescription = "15 Exercises",
                                        tint = Color.Black
                                    )
                                    Text(
                                        text = "15 Exercises",
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                }
                            }

                        }//column in a card (for texts)
                        Column(modifier = Modifier.fillMaxHeight()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_upper_body),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .weight(1f)
                                    .size(300.dp)
                                    .padding(start = 10.dp)
                            )
                        }//column for image
                    }//row


                } //card1

                Spacer(modifier=Modifier.height(10.dp))

                Card(modifier= Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(25)))
                {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column(
                            modifier = Modifier
                                .padding(start = 7.dp, top = 4.dp)
                        ) {
                            Text(
                                text = "Full Body\nStretching",
                                modifier = Modifier.padding(top = 7.dp),
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp,
                                color = Color.Black
                            )

                            Row(
                                modifier = Modifier
                                    .padding(start = 3.dp, top = 2.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(end = 10.dp)
                                    ) {
                                        Icon(
                                            modifier = Modifier
                                                .size(14.dp)
                                                .padding(end = 4.dp),
                                            painter = painterResource(id = R.drawable.ic_clock),
                                            contentDescription = "45 Minutes",
                                            tint = Color.Black
                                        )
                                        Text(
                                            text = "45 Minutes",
                                            color = Color.Black,
                                            fontSize = 12.sp,
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
                                                .size(14.dp)
                                                .padding(end = 4.dp),
                                            painter = painterResource(id = R.drawable.ic_calories),
                                            contentDescription = "1450 Kcal",
                                            tint = Color.Black
                                        )
                                        Text(
                                            text = "1450 Kcal",
                                            color = Color.Black,
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                            } // row in a column of a card

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,

                                    ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(14.dp)
                                            .padding(start = 2.dp, end = 2.dp),
                                        painter = painterResource(id = R.drawable.ic_workout),
                                        contentDescription = "20 Exercises",
                                        tint = Color.Black
                                    )
                                    Text(
                                        text = "20 Exercises",
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        modifier=Modifier.padding(start=2.dp)
                                    )
                                }
                            }

                        }//column in a card (for texts)
                        Column(modifier = Modifier.fillMaxHeight()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_full_body_stretching),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .weight(1f)
                                    .size(300.dp)
                                    .padding(start = 9.dp)
                            )
                        }//column for image
                    }//row


                } //card2


                Spacer(modifier=Modifier.height(10.dp))

                Card(modifier= Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(25)))
                {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column(
                            modifier = Modifier
                                .padding(start = 7.dp, top = 4.dp)
                        ) {
                            Text(
                                text = "Glutes & Abs",
                                modifier = Modifier.padding(top = 13.dp),
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp,
                                color = Color.Black
                            )

                            Row(
                                modifier = Modifier
                                    .padding(start = 2.dp, top = 5.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(end = 10.dp)
                                    ) {
                                        Icon(
                                            modifier = Modifier
                                                .size(14.dp)
                                                .padding(end = 4.dp),
                                            painter = painterResource(id = R.drawable.ic_clock),
                                            contentDescription = "12 Minutes",
                                            tint = Color.Black
                                        )
                                        Text(
                                            text = "12 Minutes",
                                            color = Color.Black,
                                            fontSize = 12.sp,
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
                                                .size(14.dp)
                                                .padding(end = 4.dp),
                                            painter = painterResource(id = R.drawable.ic_calories),
                                            contentDescription = "120 Kcal",
                                            tint = Color.Black
                                        )
                                        Text(
                                            text = "120 Kcal",
                                            color = Color.Black,
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                            } // row in a column of a card

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,

                                    ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(14.dp)
                                            .padding(end = 4.dp),
                                        painter = painterResource(id = R.drawable.ic_workout),
                                        contentDescription = "10 Exercises",
                                        tint = Color.Black
                                    )
                                    Text(
                                        text = "10 Exercises",
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                }
                            }

                        }//column in a card (for texts)
                        Column(modifier = Modifier.fillMaxHeight()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_glutes_abs),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .weight(1f)
                                    .size(300.dp)
                                    .padding(start = 18.dp)
                            )
                        }//column for image
                    }//row


                } //card3


            }//whole column from Lets go



        }
    }
}

@Preview(showBackground = true)
@Composable
fun BeginnerScreenPreview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        BeginnerScreen(navController)
    }
}
