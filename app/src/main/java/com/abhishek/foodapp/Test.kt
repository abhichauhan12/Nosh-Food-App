package com.abhishek.foodapp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun DoubleCircle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Canvas(modifier = Modifier.size(100.dp)) {
            val canvasSize = size
            val circleRadius = canvasSize.width.coerceAtMost(canvasSize.height) / 2

            // Draw the white circle
            drawCircle(
                color = Color.White,
                center = Offset(circleRadius, circleRadius),
                radius = circleRadius
            )

            // Draw the red circle on top
            drawCircle(
                color = Color.Red,
                center = Offset(circleRadius, circleRadius),
                radius = circleRadius * 0.8f // slightly smaller than the white circle
            )
        }
    }
}
