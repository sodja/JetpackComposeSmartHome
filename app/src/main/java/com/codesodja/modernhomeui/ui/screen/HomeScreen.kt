package com.codesodja.modernhomeui.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.codesodja.modernhomeui.R
import com.codesodja.modernhomeui.data.listOfFeatures
import com.codesodja.modernhomeui.model.BottomMenuContent
import com.codesodja.modernhomeui.model.Feature
import com.codesodja.modernhomeui.ui.theme.TextWhite
import com.codesodja.modernhomeui.ui.theme.background
import com.codesodja.modernhomeui.ui.theme.lightGreen3

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController) {
    Surface(color = background) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                ConnFixSection(name = "Conns Fix 2306")
                AlarmSection()
                HelloSection(name = "Sodja")
                FeatureSection(
                    navController,
                    features = listOfFeatures
                )
            }
            BottomMenuSection(
                items = listOf(
                    BottomMenuContent("Smart", R.drawable.ic_smart_green),
                    BottomMenuContent("Home", R.drawable.ic_home_green),
                    BottomMenuContent("Sleep", R.drawable.ic_double_bed_bottom_green),
                    BottomMenuContent("Party", R.drawable.ic_party_green)
                ), modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun ConnFixSection(name: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu_24),
            contentDescription = "Menu",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "$name",
            style = MaterialTheme.typography.h2
        )
    }
}

@Composable
fun AlarmSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(start = 25.dp, top = 25.dp)
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(TextWhite)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.alarm_clock),
                contentDescription = "alarm",
                modifier = Modifier.size(35.dp)
            )
        }
    }
}

@Composable
fun HelloSection(name: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Text(
            text = stringResource(id = R.string.hello) + ", $name",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(
            text = stringResource(id = R.string.home_message),
            style = MaterialTheme.typography.h3
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun FeatureSection(
    navController: NavController,
    features: List<Feature>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.menu_title),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 25.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 20.5.dp,
                end = 20.5.dp,
                bottom = 25.dp,
                top = 10.dp
            ),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it], navController)
            }
        }
    }
}

@Composable
fun FeatureItem(feature: Feature, navController: NavController) {
    Box(
        modifier = Modifier
            .padding(bottom = 20.dp, top = 12.dp, start = 7.5.dp, end = 12.dp)
            .shadow(
                elevation = 12.dp,
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 80.dp,
                    bottomEnd = 20.dp,
                    bottomStart = 20.dp
                ),
                clip = true
            )
            .background(TextWhite)
            .clickable { navController.navigate("detail") }
    ) {
        Column(
            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    top = 25.dp,
                    bottom = 15.dp,
                    end = 40.dp
                )
        ) {
            Image(
                painter = painterResource(id = feature.image),
                contentDescription = "image", modifier = Modifier.size(65.dp)
            )
            Text(
                text = feature.title,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
}

@Composable
fun BottomMenuSection(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = TextWhite,
    activeTextColor: Color = Color.White,
    inactiveHighlightColor: Color = lightGreen3,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(item = item,  isSelected = index == selectedItemIndex, activeHighlightColor = activeHighlightColor, activeTextColor = activeTextColor, inactiveHighlightColor = inactiveHighlightColor){
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = TextWhite,
    activeTextColor: Color = Color.White,
    inactiveHighlightColor: Color = lightGreen3,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable { onItemClick() }) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(if (isSelected) activeHighlightColor else inactiveHighlightColor)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = item.iconId),
                contentDescription = "icon",
                modifier = Modifier.size(30.dp)
            )
        }
        Text(text = item.title, color = if (isSelected) activeTextColor else Color.White, style = MaterialTheme.typography.h4)
    }
}