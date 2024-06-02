package com.example.fitnessapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
fun BreakfastScreen(navController: NavController) {

    var selectedTab by remember { mutableStateOf("Breakfast") }

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



        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB3A0FF))
                .padding(vertical = 20.dp, horizontal = 45.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.breakfast1),
                contentDescription = "Breakfast",
                modifier = Modifier
                    .height(200.dp)
                    .width(500.dp)
                    .clip(RoundedCornerShape(20.dp))
            )


            Row( modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(Alignment.BottomCenter)
            ) {

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(start = 24.dp, bottom=3.dp, top=3.dp),
                        text = "Spinach and Tomato Omelette",
                        color = Color(0xFFE2F163),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 35.dp),
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


                    }


                }

            }
        } //end of box (outside the main column)

        //new column:
        Spacer(modifier = Modifier.height(5.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.Start
        ){
            Text(modifier = Modifier.padding(start=20.dp,bottom = 20.dp),
                text = "Recommended",
                color = Color(0xFFE2F163),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
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
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier=Modifier.padding(3.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.smoothie_pink),
                            contentDescription = "Red Smoothie",
                            modifier = Modifier
                                .height(100.dp), // Set the desired height for the image

                            alignment = Alignment.TopCenter

                        )
                        Text(
                            text = "Fruit Smoothie",
                            color = Color(0xFFE2F163),
                            modifier=Modifier.padding(end=35.dp, bottom=4.dp)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(15.dp)
                                        .padding(top = 5.dp, start = 5.dp),
                                    painter = painterResource(id = R.drawable.ic_clock),
                                    contentDescription = "12 Minutes",
                                    tint = Color(0xFF6650a4)
                                )
                                Text(
                                    text = "12 Minutes",
                                    fontSize = 11.sp,
                                    color = Color.White,
                                    modifier=Modifier.padding(start=3.dp)
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(15.dp)
                                        .padding(top = 5.dp),
                                    painter = painterResource(id = R.drawable.ic_calories),
                                    contentDescription = "120 Cal",
                                    tint = Color(0xFF6650a4)
                                )
                                Text(
                                    text = "120 Cal",
                                    fontSize = 11.sp,
                                    color = Color.White,
                                    modifier=Modifier.padding(end=10.dp)
                                )
                            }
                        }
                    }
                }

                //2nd card in a row
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .background(Color.Unspecified, shape = RoundedCornerShape(8.dp))
                        .border(1.dp, Color(0xFF7668ed), shape = RoundedCornerShape(24.dp))
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier=Modifier.padding(3.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.smoothie_green),
                            contentDescription = "Green Smoothie",
                            modifier = Modifier
                                .height(100.dp), // Set the desired height for the image

                            alignment = Alignment.TopCenter

                        )
                        Text(
                            text = "Green Smoothie",
                            color = Color(0xFFE2F163),
                            modifier=Modifier.padding(end=35.dp, bottom=4.dp)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(15.dp)
                                        .padding(top = 5.dp, start = 5.dp),
                                    painter = painterResource(id = R.drawable.ic_clock),
                                    contentDescription = "12 Minutes",
                                    tint = Color(0xFF6650a4)
                                )
                                Text(
                                    text = "12 Minutes",
                                    fontSize = 11.sp,
                                    color = Color.White,
                                    modifier=Modifier.padding(start=3.dp)
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(15.dp)
                                        .padding(top = 5.dp),
                                    painter = painterResource(id = R.drawable.ic_calories),
                                    contentDescription = "120 Cal",
                                    tint = Color(0xFF6650a4)
                                )
                                Text(
                                    text = "120 Cal",
                                    fontSize = 11.sp,
                                    color = Color.White,
                                    modifier=Modifier.padding(end=10.dp)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier=Modifier.height(20.dp))
            Text(modifier = Modifier.padding(start=20.dp,bottom = 10.dp),
                text = "Recipes For You",
                color = Color(0xFFE2F163),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

            Column(modifier=Modifier.fillMaxWidth()){

            }

            Card(modifier= Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .height(90.dp)
                .clip(RoundedCornerShape(25)))
            {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier
                            .padding(start = 7.dp, top=10.dp)
                    ) {

                        Text(
                            text = "Yogurt Delights",
                            modifier = Modifier.padding(top = 13.dp, start=10.dp),
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            lineHeight = 2.sp,
                            color = Color.Black
                        )

                        Row(
                            modifier = Modifier
                                .padding(start = 3.dp, top = 5.dp),
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
                                        contentDescription = "6 Minutes",
                                        tint = Color.Black
                                    )
                                    Text(
                                        text = "6 Minutes",
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
                                        contentDescription = "200 Cal",
                                        tint = Color.Black
                                    )
                                    Text(
                                        text = "200 Cal",
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        } // row in a column of a card


                    }//column in a card (for texts)
                    Column(modifier = Modifier.fillMaxHeight()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.oatmeal),
                            contentDescription = "Image",
                            modifier = Modifier
                                .weight(1f)
                                .size(300.dp)
                                .padding(start = 80.dp)
                        )
                    }//column for image
                }//row


            }

            Card(modifier= Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp, horizontal = 10.dp)
                .size(90.dp)
                .clip(RoundedCornerShape(25)))
            {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier
                            .padding(start = 7.dp, top=10.dp)
                    ) {

                        Text(
                            text = "Eggs with avocado",
                            modifier = Modifier.padding(top = 13.dp, start=10.dp),
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            lineHeight = 2.sp,
                            color = Color.Black
                        )

                        Row(
                            modifier = Modifier
                                .padding(start = 3.dp, top = 5.dp),
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
                                        contentDescription = "10 Minutes",
                                        tint = Color.Black
                                    )
                                    Text(
                                        text = "10 Minutes",
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
                                        contentDescription = "200 Cal",
                                        tint = Color.Black
                                    )
                                    Text(
                                        text = "150 Cal",
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        } // row in a column of a card


                    }//column in a card (for texts)
                    Column(modifier = Modifier.fillMaxHeight()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.eggs),
                            contentDescription = "Image",
                            modifier = Modifier
                                .weight(1f)
                                .size(400.dp)
                                .padding(start = 85.dp)
                        )
                    }//column for image
                }//row


            }



        }

    }

}


@Preview(showBackground = true)
@Composable
fun BreakfastScreenPreview() {
    val navController = rememberNavController()
    FitnessAppTheme {
        BreakfastScreen(navController)
    }
}