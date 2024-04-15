package com.abhishek.foodapp.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhishek.foodapp.R

@Preview
@Composable
fun OtherScreen(){


    Box(modifier = Modifier,
        contentAlignment = Alignment.Center

    ){

        Image(painter = painterResource(id = R.drawable.ic_circle_white),
            contentDescription = "white circle",
            modifier = Modifier.size(32.dp)
        )

        Image(painter = painterResource(id = R.drawable.ic_circle_orange),
            contentDescription = "Orange circle",
            modifier = Modifier.size(16.dp)
        )
    }


}