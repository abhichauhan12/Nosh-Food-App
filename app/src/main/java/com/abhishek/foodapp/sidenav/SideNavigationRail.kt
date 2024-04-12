package com.abhishek.foodapp.sidenav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.NavigationRailItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.foodapp.R
import com.abhishek.foodapp.ui.theme.Blue
import com.abhishek.foodapp.ui.theme.Orange


val navigationItem = listOf(
    NavigationItem(
        title = "Cook",
        icon = R.drawable.cooking,
        selected = true
    ),
    NavigationItem(
        title = "Favorite",
        icon = R.drawable.fav_sec,
        selected = false
    ),
    NavigationItem(
        title = "Manual",
        icon = R.drawable.manula_sec,
        selected = false
    ),
    NavigationItem(
        title = "Device",
        icon = R.drawable.devices,
        selected = false
    ),
    NavigationItem(
        title = "Prefer",
        icon = R.drawable.preferences,
        selected = false
    ),
    NavigationItem(
        title = "Settings",
        icon = R.drawable.setting,
        selected = false
    )

)


@Composable
fun NavigationSideBar(
    items : List<NavigationItem>,
    selectedItemIndex : Int,
    onNavigate:(Int) -> Unit

){

    NavigationRail(
        contentColor = Color.White,
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentWidth()
            .padding(start = 16.dp)
        ,
    ) {
        Column(
            modifier =Modifier.fillMaxHeight() ,
            verticalArrangement = Arrangement.SpaceEvenly,
        )
        {

            items.forEachIndexed { index, item ->
                // Orange if selected, else blue
                val iconColor = if (selectedItemIndex == index) Orange else Blue

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){

                    NavigationRailItem(
                        selected = selectedItemIndex == index,
                        onClick = { onNavigate(index) },
                        icon = { NavigationIcon(item ,iconColor ) },
                    )

                    Box (
                        modifier = Modifier
                            .padding(top = 8.dp)
                    ){
                        Text(text = item.title, color = iconColor, fontSize = 16.sp)
                    }

                }


            }
        }
    }
}

@Composable
fun NavigationIcon(
    item : NavigationItem,
    iconColor: Color
){
    Icon(
        painter = painterResource(id = item.icon),
        contentDescription = item.title,
        tint = iconColor,
        modifier = Modifier.size(64.dp)
    )
    

}

