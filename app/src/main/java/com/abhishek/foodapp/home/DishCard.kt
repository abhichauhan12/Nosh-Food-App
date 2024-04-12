package com.abhishek.foodapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.foodapp.R
import com.abhishek.foodapp.ui.theme.Blue
import com.abhishek.foodapp.ui.theme.Orange
import com.abhishek.foodapp.ui.theme.White

data class Dish(
    val name: String,
    val rating: Float,
    val imageResId: Int
){
    fun matchSearch(query: String): Boolean {
        return name.contains(query, ignoreCase = true)
    }
}



@Composable
fun DishCard(
    dishName: String,
    rating: Float,
    isSelected: Boolean,
    onSelect: (String) -> Unit,
    modifier: Modifier = Modifier,
    imageRes: Int = R.drawable.ic_launcher_background
) {
    Card(
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        backgroundColor = if (isSelected) Blue else Color.White,
        modifier = modifier
            .padding(8.dp)
            .wrapContentWidth()
            .wrapContentHeight()
            .clickable { onSelect(dishName) }
            .shadow(
                elevation = 16.dp,
                ambientColor = Orange,
                spotColor = Orange,
                shape = RoundedCornerShape(corner = CornerSize(16.dp))
            )
        ,
    ) {
        Column(
            modifier = Modifier
//                .background(Blue)
                .background(if (isSelected) Blue else Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .padding(8.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                // Dish Image
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = dishName,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(18.dp)),
                    contentScale = ContentScale.Crop
                )
                //  Icon veg , non-veg
                Icon(
                    painter = painterResource(id = R.drawable.nonveg),
                    contentDescription = "veg , non-veg",
                    tint = Color.Red,
                    modifier = Modifier.padding(end = 8.dp, top = 8.dp)
                        .size(16.dp)
                )


                //rating
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 12.dp)
                    .background(
                        color = Orange.copy(alpha = 0.75f),
                        shape = RoundedCornerShape( 16.dp),
                    )
                    .padding(horizontal = 6.dp, vertical = 4.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "Rating",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = " " + rating.toString(),
                        fontSize = 14.sp,
                        color = Color.White

                        )
                    }
                }

            }



            // Dish Name
            Text(
                text = dishName,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = if (isSelected) White else Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .widthIn(max = 160.dp)
                    .padding(8.dp)
            )

            // Rating and Prep Time
            Row(
                modifier= Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.cook),
                    contentDescription = "Rating",
                    tint = if (isSelected) White else Color.Black,
                    modifier = Modifier.size(20.dp).alpha(0.7f)
                )
                Text(
                    text = "30 min · Medium prep",
                    color = if (isSelected) White else Color.Black,
                    modifier = Modifier.padding(start = 4.dp).alpha(0.7f)
                )
//                Text(
//                    text = "·Medium prep",
//                    color = Color.White,
//                    modifier = Modifier.padding(start = 8.dp).alpha(0.7f)
//                )
            }
        }
    }
}

