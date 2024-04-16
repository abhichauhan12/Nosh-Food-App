package com.abhishek.foodapp.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.foodapp.R
import com.abhishek.foodapp.ui.theme.Blue
import com.abhishek.foodapp.ui.theme.Grey
import com.abhishek.foodapp.ui.theme.Orange
import java.util.Calendar

@Preview(
    showSystemUi = true,
    device = Devices.TABLET
)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { TopSearchBar() },
        bottomBar = { BottomButtons() }
    ) {innerPadding ->
        MainContent(modifier = Modifier.padding(innerPadding))
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopSearchBar() {

    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                var textState = rememberTextFieldState()

                BasicTextField2(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(horizontal = 10.dp)
                        .background(Color.White, RoundedCornerShape(50.dp))
                        .border(width = 2.dp, color = Color.Black, RoundedCornerShape(50.dp))
                        .padding(16.dp),
                    state = textState,
                    lineLimits = TextFieldLineLimits.SingleLine,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp ),
                    decorator = {innerTextField ->
                        Row (modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                            ){
                            Icon(imageVector = Icons.Default.Search
                                , contentDescription = "Search")
                            Spacer(modifier = Modifier.width(8.dp))

                            Box(modifier = Modifier.weight(1f)){
                                if (textState.text.isEmpty()){
                                    Text(text = "Search for dish or ingredient",
                                    color = Grey.copy(0.5f)
                                    )
                                }
                                innerTextField()
                            }

                            if (textState.text.isNotEmpty()){
                                Spacer(modifier = Modifier.width(8.dp))

                                Icon(
                                    modifier = Modifier.clickable {
                                        textState.edit {
                                            this.replace(0,textState.text.length,"")

                                        }
                                    },
                                    imageVector = Icons.Default.Clear,
                                    contentDescription ="clear text"
                                )
                            }

                        }

                    }


                )
                    Card(
                        shape = RoundedCornerShape(corner = CornerSize(50.dp)),
                        modifier = Modifier
                            .wrapContentWidth()
                            .border(width = 2.dp, color = Color.Blue, RoundedCornerShape(50.dp))

                        ,
                    ) {
                        Row(
                            modifier = Modifier
                                .background(Blue)
                                .padding(4.dp)
                            ,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.foodsample),
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(corner = CornerSize(100.dp))),
                                contentScale = ContentScale.Crop,
                                contentDescription = "Italian Spagh.."
                            )
                            Column(
                                modifier = Modifier.padding(top = 4.dp, start = 8.dp,  end = 8.dp)
                            ) {
                                Text( text = "Italian Spagh..",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                )
                                Text( text = "Scheduled 6:30 AM",
                                    color = Color.White,
                                    fontSize = 14.sp,
                                )

                            }

                        }
                    }

                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = "Notifications",
                    tint = Blue,
                    modifier = Modifier
                        .size(44.dp)
                        .padding(start = 8.dp)
                )

                Icon(
                    painterResource(id = R.drawable.ic_power),
                    contentDescription = "Power",
                    tint = Red,
                    modifier = Modifier
                        .size(44.dp)
                        .padding(start = 8.dp, end = 8.dp)
                )
            }
        },
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}


@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("What's on your mind?", Modifier.padding(16.dp),
            color = Blue,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        FoodCategoryRow()
        Text("Recommendations", Modifier.padding(16.dp),
            color = Blue,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        DishCardsRow()
    }
}


@Composable
fun FoodCategoryRow() {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 24.dp)
    ) {
        dummyFoodList.forEach { foodList ->
            FoodCard(foodName =foodList.name, imageRes = foodList.imageResId )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun DishCardsRow() {

    val selectedDish = remember { mutableStateOf<String?>(null) }
    val showTimePicker = remember { mutableStateOf(false) }
    val showTimePickerDialog = remember { mutableStateOf(false) }



//    val dishes = listOf("Italian Spaghetti Pasta", "Indian", "Curries", "Soups", "Desserts", "Snacks","Fat Food", "Chinese","Another Dish", "Yet Another Dish")
    val currentTime = remember { mutableStateOf(Calendar.getInstance()) }

    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        dummyDishes.forEach { dish ->
            DishCard(dishName = dish.name,
                rating = dish.rating,
                imageRes = dish.imageResId,
                isSelected = selectedDish.value == dish.name,
                onSelect = {
                    selectedDish.value = it
//                    showTimePicker.value = true
                    showTimePickerDialog.value = true

                }
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }



    if (showTimePickerDialog.value) {
        ScheduleCookingTimeDialog(
            onDismiss = { showTimePickerDialog.value = false },
            onCookNow = { cookingTime ->
                // Handle the cooking time (store it somewhere or trigger an event)
                showTimePickerDialog.value = false
            }
        )
    }

//    // Show time picker dialog
//    if (showTimePicker.value) {
//        TimePickerDialog(
//            currentTime = currentTime.value,
//            onTimeSelected = { hour, minute ->
//                // Update the current time state with the selected time.
//                currentTime.value.set(Calendar.HOUR_OF_DAY, hour)
//                currentTime.value.set(Calendar.MINUTE, minute)
//                // Perform any actions with the selected time here.
//                showTimePicker.value = false // Hide the dialog after selection.
//            },
//            onDismissRequest = { showTimePicker.value = false }
//        )
//    }
}




@Composable
fun BottomButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        ButtonCard(
            buttonName = "Explore all dishes",
            imageResId = R.drawable.expl,
            textAlign = TextAlign.Start
        )
        ButtonCard(
            buttonName = "Confused what to cook?",
            imageResId = R.drawable.confus,
            textAlign = TextAlign.Center
            )

    }
}

@Composable
fun ButtonCard(buttonName: String ,@DrawableRes imageResId: Int , textAlign: TextAlign) {
    Card(
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        modifier = Modifier
            .width(400.dp)
            .height(80.dp)
    ) {
        Box(
//            modifier = Modifier.padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageResId),
                modifier = Modifier
                    .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
                    .matchParentSize()
                    .alpha(0.9f)
                ,
                contentScale = ContentScale.Crop,

                contentDescription = buttonName
            )
            Text(
                text = buttonName,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = textAlign,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            )
        }
    }
}


