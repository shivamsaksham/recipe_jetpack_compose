@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.shivam.recipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow.Companion.Clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shivam.recipe.components.HeadingBold
import com.shivam.recipe.components.HeadingNormal
import com.shivam.recipe.ui.theme.RecipeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    GreetingPreview()
                }
            }
        }
    }
}


@Composable
fun TopBar(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.recipe),
            contentScale = ContentScale.Crop,
            contentDescription = "Pofile",
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
        )
        Box(
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
                .background(color = Color(R.color.background_grey))

        ) {
            Image(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "menu button",
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun Greeting(){
    Text(
        text = stringResource(id = R.string.home_greeting),
        style = MaterialTheme.typography.titleLarge

    )
}

@Composable
fun SearchBox(){
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        placeholder = { Text(text = stringResource(id = R.string.searchLabel))},
        modifier = Modifier
            .fillMaxWidth()
        ,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "search")},
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            textColor = Color.Black
        )
    )
}

@Composable
fun Chip(text:String){
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(text)
        },
        selected = selected,
        shape = RoundedCornerShape(50.dp)
    )


}
val categories :List<String> = listOf(
    "All",
    "Main Course",
    "Breakfast",
    "Soup",
    "Desert",
    "Snacks"
)
@Composable
fun CategoryChip(){
    LazyRow() {
        items(categories) {category ->
            Chip(text = category)
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}



@Composable
fun HomePage(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)

    ) {
        TopBar()
        Spacer(modifier = Modifier.height(15.dp))
        Greeting()
        Spacer(modifier = Modifier.height(15.dp))
        SearchBox()
        Spacer(modifier = Modifier.height(15.dp))
        CategoryChip()
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    RecipeTheme(darkTheme = false) {
        HomePage()
    }
}