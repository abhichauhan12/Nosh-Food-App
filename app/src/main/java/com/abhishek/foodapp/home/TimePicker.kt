package com.abhishek.foodapp.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.abhishek.foodapp.R
import com.abhishek.foodapp.ui.theme.Blue
import com.abhishek.foodapp.ui.theme.BlueGrey
import com.abhishek.foodapp.ui.theme.GreyGrey
import com.abhishek.foodapp.ui.theme.Orange
import java.util.Calendar

@Composable
fun ScheduleCookingTimeDialog(onDismiss: () -> Unit, onCookNow: (Calendar) -> Unit) {
    val calendar = remember { mutableStateOf(Calendar.getInstance()) }
    val amPmState = remember { mutableStateOf(if (calendar.value.get(Calendar.AM_PM) == Calendar.AM) "AM" else "PM") }

    val isAm = remember { mutableStateOf(calendar.value.get(Calendar.AM_PM) == Calendar.AM) }

    Box (modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(16.dp))
    )
    {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White ,  RoundedCornerShape(20.dp))
                    .padding(8.dp)

                ,
//            horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Box(modifier = Modifier.padding(start = 8.dp, top = 8.dp)){
                        Text(
                            text="Schedule cooking time",
                            color = Blue , fontSize = 24.sp, fontWeight = FontWeight.Bold )
                    }
                    Box(modifier = Modifier.padding(start = 110.dp, top = 8.dp)){
                        Icon(painter = painterResource(id = R.drawable.ic_cancel),
                            contentDescription ="cancel",
                            tint = Color.LightGray,
                            modifier = Modifier
                                .size(32.dp)
                                .clickable { onDismiss() }

                        )
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))

                // Custom time picker could go here, but let's just show the current time for now.
                // You'll need to implement a scrolling time selector as per your design.
//            Text("${calendar.value.get(Calendar.HOUR)} : ${calendar.value.get(Calendar.MINUTE)} $amPmState")

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box (
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(GreyGrey)
                            .padding(60.dp)
                    ){
                        Text(text = "${calendar.value.get(Calendar.HOUR).toString().padStart(2, '0')} : ${calendar.value.get(
                            Calendar.MINUTE).toString().padStart(2, '0')} ",
                            fontSize = 56.sp,
                            color = Color.Blue,
                        )
                    }


                    Spacer(modifier = Modifier.height(20.dp))

                    Column(
                        modifier = Modifier
                            .padding(start = 24.dp, top = 40.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Button(onClick = { amPmState.value = "AM"
                            isAm.value = false
                        },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (isAm.value) Blue else Blue)
                        ) {
                            Text("AM" , fontSize = 24.sp , color = Color.White)

                        }

                        Spacer(modifier = Modifier.width(30.dp))

                        Button(onClick = { amPmState.value = "PM" },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (isAm.value) BlueGrey else BlueGrey)
                        ) {
                            Text("PM" , fontSize = 24.sp, color = Blue)
                        }
                    }
                }



                Spacer(modifier = Modifier.height(16.dp))

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Box (
                        modifier = Modifier.padding(start = 8.dp)
                    ){
                        Text(modifier = Modifier.clickable { onDismiss() },
                            text = buildAnnotatedString {
                                withStyle(
                                    SpanStyle(
                                        color = Color.Red,
                                        textDecoration = TextDecoration.Underline,
                                        fontSize = 16.sp,

                                        )
                                ){
                                    append("Delete")

                                }
                            })

                    }

                    Box (
                        modifier = Modifier
                            .background(Color.White, RoundedCornerShape(corner = CornerSize(16.dp)))
                            .then(
                                Modifier.shadow(
                                    elevation = 0.dp,
                                    shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                                    // This creates a subtle shadow that might not be the color you want but is necessary for elevation.
                                )
                            )
                            .border(
                                width = 1.dp,
                                color = Orange,
                                shape = RoundedCornerShape(corner = CornerSize(20.dp))
                            )
                            .padding(8.dp)
//                        .shadow(
//                            elevation = 4.dp,
//                            ambientColor = Orange,
////                            spotColor = Orange,
//                        )


                    ){

                        Text(text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Orange,
                                    fontSize = 18.sp,

                                    )
                            ){
                                append("Re-schedule")
                            }
                        })

                    }


                    Box (
                        modifier = Modifier
                            .background(Orange, RoundedCornerShape(corner = CornerSize(20.dp)))
                            .border(
                                width = 1.dp,
                                color = Orange,
                                shape = RoundedCornerShape(corner = CornerSize(20.dp))
                            )
                            .shadow(
                                elevation = 4.dp,
                                ambientColor = Color.White,
                                spotColor = Orange,
                            )
                            .padding(start = 36.dp, end = 36.dp, top = 16.dp, bottom = 16.dp)


                    ){

                        Text(text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Color.White,
                                    fontSize = 20.sp,

                                    )
                            ){
                                append("Cook Now")
                            }
                        })

                    }

//                Button(onClick = {
//                    // Store the selected time in calendar and call onCookNow
//                    if (amPmState.value == "PM" && calendar.value.get(Calendar.HOUR_OF_DAY) < 12) {
//                        calendar.value.add(Calendar.HOUR, 12)
//                    } else if (amPmState.value == "AM" && calendar.value.get(Calendar.HOUR_OF_DAY) >= 12) {
//                        calendar.value.add(Calendar.HOUR, -12)
//                    }
//                    onCookNow(calendar.value)
//                },
//
//                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)) {
//                    Text("Cook Now")
//                }
                }
            }
        }

    }

}



@Composable
fun TimePickerDialog(currentTime: Calendar, onTimeSelected: (Int, Int) -> Unit, onDismissRequest: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = { Text("Select Time") },
        text = {
            Text("Current Time: ${currentTime.get(Calendar.HOUR_OF_DAY)}:${currentTime.get(Calendar.MINUTE)}")
        },
        confirmButton = {
            Button(onClick = {
                // Simulate time selection
                val hour = currentTime.get(Calendar.HOUR_OF_DAY)
                val minute = currentTime.get(Calendar.MINUTE)
                onTimeSelected(hour, minute)
            }) {
                Text("Select")
            }
        },
        dismissButton = {
            Button(onClick = { onDismissRequest() }) {
                Text("Cancel")
            }
        }
    )
}

@Preview(
    showSystemUi = true,
    device = "spec:width=540dp,height=960dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape"
)
@Composable
fun PreviewScheduleCookingTimeDialog() {
    ScheduleCookingTimeDialog(
        onDismiss = { /* Handle dismiss */ },
        onCookNow = { calendar ->
            // Handle what happens when the cook now button is pressed. For preview, this can be empty.
        }
    )
}
