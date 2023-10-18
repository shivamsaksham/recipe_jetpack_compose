package com.shivam.recipe.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun HeadingNormal(text : String , color : Color = Color.Black , modifier: Modifier = Modifier){
    Text(
        text = text,
        color = color,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge
        )
}

@Composable
fun HeadingBold(text : String){
    Text(
        text = text,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        )
}
