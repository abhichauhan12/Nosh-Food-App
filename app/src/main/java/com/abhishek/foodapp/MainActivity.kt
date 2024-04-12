package com.abhishek.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.abhishek.foodapp.sidenav.NavigationScreen
import com.abhishek.foodapp.ui.theme.FoodAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                }

                NavigationScreen()

//                DishCard(dishName = "Itakian Saghetti pasta", rating = 4.2f)

            }
        }
    }
}

