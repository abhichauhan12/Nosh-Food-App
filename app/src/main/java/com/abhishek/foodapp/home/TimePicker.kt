package com.abhishek.foodapp.home

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
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

    val calendar = Calendar.getInstance()
    val currentHour24 = calendar.get(Calendar.HOUR_OF_DAY)
    val isAm = remember { mutableStateOf(currentHour24 < 12) }
    val currentHour = if (currentHour24 % 12 == 0) 12 else currentHour24 % 12
    val currentMinute = calendar.get(Calendar.MINUTE)

    val hours = (1..12).map { it.toString().padStart(0, '0') }
    val minutes = (0..59).map { it.toString().padStart(0, '0') }

    val selectedHour = remember { mutableStateOf(currentHour.toString().padStart(2, '0')) }
    val selectedMinute = remember { mutableStateOf(currentMinute.toString().padStart(2, '0')) }


    Box (modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(16.dp))
    )
    {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .padding(8.dp),

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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Row (
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(GreyGrey)
                            .padding(20.dp)
                            .padding(start = 60.dp, end = 60.dp)
                    ){

                        InfiniteNumberPicker(
                            modifier = Modifier.width(40.dp),
                            list = hours,
                            firstIndex = currentHour -2,
                            onSelect = { selectedHour.value = it }
                        )

                        InfiniteNumberPicker(
                            modifier = Modifier.width(40.dp),
                            list = minutes,
                            firstIndex = currentMinute,
                            onSelect = { selectedMinute.value = it }
                        )

                    }


                    Spacer(modifier = Modifier.height(20.dp))

                    Column(
                        modifier = Modifier
                            .padding(start = 24.dp, top = 40.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Button(onClick = {  isAm.value = true },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (isAm.value) Color.Blue else Color.LightGray)
                        ) {
                            Text("AM" , fontSize = 24.sp ,
                                color =  if (isAm.value) Color.White else Blue
                            )

                        }

                        Spacer(modifier = Modifier.width(30.dp))

                        Button(onClick = { isAm.value = false },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (!isAm.value) Color.Blue else Color.LightGray)
                        ) {
                            Text("PM" , fontSize = 24.sp,
                                color = if (!isAm.value) Color.White else Blue
                            )
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
                                )
                            )
                            .border(
                                width = 1.dp,
                                color = Orange,
                                shape = RoundedCornerShape(corner = CornerSize(20.dp))
                            )
                            .padding(8.dp)


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

                        val context = LocalContext.current


                        Text(text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Color.White,
                                    fontSize = 20.sp,

                                    )
                            ){
                                append("Cook Now")
                            }
                        }
                        ,Modifier.clickable {
                            //Toast
                                Toast.makeText(context, "Time Selected: ${selectedHour.value}:${selectedMinute.value}", Toast.LENGTH_SHORT).show()
                                onDismiss()
                            }
                        )


                    }

                }
            }
        }

    }

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
