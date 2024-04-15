package com.abhishek.foodapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.foodapp.R
import com.abhishek.foodapp.ui.theme.Blue
import com.abhishek.foodapp.ui.theme.Orange

data class FoodCart(
    val name : String,
    val imageResId: Int
)



@Composable
fun FoodCard(
    foodName: String,
    imageRes: Int = R.drawable.ic_launcher_background

) {
    Card(
        shape = RoundedCornerShape(corner = CornerSize(50.dp)),
        modifier = Modifier
            .wrapContentWidth()
            .shadow(
                elevation = 8.dp,
                ambientColor = Orange,
                spotColor = Orange,
            )
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(100.dp))),
                contentScale = ContentScale.Crop,
                contentDescription = foodName
            )
            Text(foodName ,
                color = Blue,
                fontSize = 16.sp,
                modifier = Modifier.padding( start = 12.dp, end = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFoodCard() {
    FoodCard(
        foodName = "Indian",
        imageRes = R.drawable.foodsample
    )
}