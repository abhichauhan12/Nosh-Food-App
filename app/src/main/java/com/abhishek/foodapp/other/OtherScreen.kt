package com.abhishek.foodapp.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.abhishek.foodapp.R

@Preview
@Composable
fun OtherScreen(){

    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(id = R.drawable.soon),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            contentScale = ContentScale.Crop,
        )
    }

}