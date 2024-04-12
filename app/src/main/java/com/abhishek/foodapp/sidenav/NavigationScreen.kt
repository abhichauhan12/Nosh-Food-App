package com.abhishek.foodapp.sidenav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.foodapp.home.HomeScreen
import com.abhishek.foodapp.other.OtherScreen
import com.abhishek.foodapp.ui.theme.Blue

@Preview
@Composable
fun NavigationScreen() {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold { padding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Side navigation bar with a fixed width
            NavigationSideBar(
                items =  navigationItem,
                selectedItemIndex = selectedItemIndex,
                onNavigate = { selectedItemIndex = it }
            )
            MainContent(
                selectedItemIndex = selectedItemIndex,
                modifier = Modifier.weight(1f)
            )
        }
    }
}



@Composable
fun MainContent(selectedItemIndex: Int, modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        when (selectedItemIndex) {
            0 -> HomeScreen()
            1 -> Text(text = "Favorite Sceen Coming Soon", fontSize = 40.sp, color = Color.Blue )
            2 -> Text(text = "Manual Sceen Coming Soon", fontSize = 40.sp, color = Color.Blue )
            3 -> Text(text = "Device Sceen Coming Soon", fontSize = 40.sp, color = Color.Blue )
            4 -> Text(text = "Preferences Sceen Coming Soon", fontSize = 40.sp, color = Color.Blue )
            5 -> Text(text = "Settings Sceen Coming Soon", fontSize = 40.sp, color = Color.Blue )
            // Add more cases for other screens
            else -> {}
        }
    }
}