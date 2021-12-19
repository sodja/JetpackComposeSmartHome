package com.codesodja.modernhomeui.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.codesodja.modernhomeui.R
import com.codesodja.modernhomeui.data.getDetailsItemsByCode
import com.codesodja.modernhomeui.data.listOfDetailContent
import com.codesodja.modernhomeui.model.DetailsContent
import com.codesodja.modernhomeui.model.DetailsParts
import com.codesodja.modernhomeui.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun DetailScreen(navController: NavController) {
    Surface(color = TextWhite, modifier = Modifier.fillMaxSize()) {
        Column {
            TitleSection(navController, title = "Living room")
            BodySection(navController)
        }
    }
}

@Composable
fun TitleSection(navController: NavController, title: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "back",
            tint = FontFamilyColor,
            modifier = Modifier
                .size(35.dp)
                .clickable { navController.popBackStack() }
        )
        Text(text = title, style = MaterialTheme.typography.body2)
    }
}

@Composable
fun BodySection(navController: NavController) {

    Surface(
        color = background,
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
    ) {
        DetailItemSection(
            navController,
            detailsItem = listOfDetailContent
        )
    }
}

@Composable
fun DetailsItemSection(code: String) {

    val detailsContents = getDetailsItemsByCode(code)
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(detailsContents) { index, detailsContent ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (code == "L1") {
                    DetailsLightImage(detailsContent = detailsContent)
                } else {
                    DetailsDeviceImage(detailsContent = detailsContent)
                }
            }
        }
    }
}

@Composable
fun DetailItemSection(
    navController: NavController,
    detailsItem: List<DetailsContent>,
    activeHighlightColor: Color = TextWhite,
    activeTextColor: Color = Color.White,
    inactiveHighlightColor: Color = lightGreen3,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    var selectedItemCode by remember {
        mutableStateOf("L1")
    }
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(50.dp)
                .fillMaxWidth()
        ) {
            detailsItem.forEachIndexed { index, detailsContent ->
                DetailsItem(
                    navController,
                    item = detailsContent,
                    activeHighlightColor = activeHighlightColor,
                    activeTextColor = activeTextColor,
                    inactiveHighlightColor = inactiveHighlightColor,
                    isSelected = index == selectedItemIndex
                ) {
                    selectedItemCode = detailsContent.code
                    selectedItemIndex = index
                }
            }
        }
        DetailsItemSection(selectedItemCode)
    }

}

@Composable
fun DetailsItem(
    navController: NavController,
    item: DetailsContent,
    activeHighlightColor: Color = TextWhite,
    activeTextColor: Color = Color.White,
    inactiveHighlightColor: Color = lightGreen3,
    isSelected: Boolean = false,
    onItemClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { onItemClick() }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(if (isSelected) activeHighlightColor else inactiveHighlightColor)
                .padding(15.dp)
        ) {
            Image(
                painter = painterResource(id = item.iconId),
                contentDescription = "icon",
                modifier = Modifier.size(25.dp)
            )
        }
        Text(
            text = item.title,
            style = MaterialTheme.typography.h5,
            color = if (isSelected) activeTextColor else Color.White
        )
    }
}

@Composable
fun DetailsDeviceImage(detailsContent: DetailsContent) {

    Box {
        Card(
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, bottom = 5.dp)
                .shadow(
                    elevation = 5.dp,
                    RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 90.dp,
                        bottomStart = 25.dp,
                        bottomEnd = 25.dp
                    ),
                    clip = true
                )
                .background(TextWhite)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(TextWhite)
            ) {
                Image(
                    painter = painterResource(id = detailsContent.iconId),
                    contentDescription = "air",
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(190.dp)
                )
                Text(
                    text = "28°C",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                LinearProgressIndicator(
                    color = background,
                    backgroundColor = LightGreen2,
                    progress = 0.6F,
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(background)
                )
                PartsSection(
                    parts = listOf(
                        DetailsParts(code = "code1", R.drawable.ic_sun_green),
                        DetailsParts(code = "code1", R.drawable.ic_star_green),
                        DetailsParts(code = "code1", R.drawable.ic_ventillator_green),
                        DetailsParts(code = "code1", R.drawable.ic_water_droplet_green)
                    ), modifier = Modifier
                        .padding(20.dp)
                        .shadow(elevation = 8.dp, RoundedCornerShape(50.dp), clip = true)
                        .background(if (true) TextWhite else BlurWhite)
                )
                Text(
                    text = detailsContent.title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 25.dp)
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_power_orange),
            contentDescription = "image",
            modifier = Modifier
                .size(50.dp)
                .align(alignment = Alignment.TopEnd)
                .offset(x = (-25).dp)
        )
    }
    StoriesBloc()
}

@Composable
fun DetailsLightImage(detailsContent: DetailsContent) {

    Box {
        Card(
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, bottom = 25.dp)
                .shadow(
                    elevation = 10.dp,
                    RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 90.dp,
                        bottomStart = 25.dp,
                        bottomEnd = 25.dp
                    ),
                    clip = true
                )
                .background(TextWhite)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(TextWhite)
            ) {
                Image(
                    painter = painterResource(id = detailsContent.iconId),
                    contentDescription = "air",
                    modifier = Modifier
                        .padding(bottom = 25.dp)
                        .size(190.dp)
                )
                LinearProgressIndicator(
                    color = background,
                    backgroundColor = LightGreen2,
                    progress = 0.6F,
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(background)
                )
                PartsSection(
                    parts = listOf(
                        DetailsParts(code = "code1", R.drawable.ic_circle_orange),
                        DetailsParts(code = "code1", R.drawable.ic_circle_orange1),
                        DetailsParts(code = "code1", R.drawable.ic_circle_orange2),
                        DetailsParts(code = "code1", R.drawable.ic_circle_orange3),
                        DetailsParts(code = "code1", R.drawable.ic_circle_orange4)
                    ), modifier = Modifier
                        .padding(10.dp)
                )
                Text(
                    text = detailsContent.title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
        }
    }
    StoriesBloc()
}

@Composable
fun PartsSection(
    parts: List<DetailsParts>,
    initialSelectedItemIndex: Int = 0,
    modifier: Modifier
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 20.dp, end = 30.dp, start = 30.dp, bottom = 30.dp)
            .fillMaxWidth()
    ) {
        parts.forEachIndexed { index, detailsContent ->
            PartItemSection(
                item = detailsContent,
                modifier = modifier,
                isSelected = selectedItemIndex == index
            ) {
                selectedItemIndex = index
            }
        }
    }
}


@Composable
fun PartItemSection(
    item: DetailsParts,
    modifier: Modifier,
    isSelected: Boolean = false,
    onItemClick: () -> Unit
) {
    Box(contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable { onItemClick() }
    ) {
        Image(
            painter = painterResource(id = item.iconId),
            contentDescription = "icon",
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun Stories(modifier: Modifier) {
    var progress by remember { mutableStateOf(0.0f) }
    var enabled by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = progress, key2 = enabled) {
        if (progress < 1 && enabled) {
            delay(100L)
            progress += 0.01F
        }
    }
    LinearProgressIndicator(
        color = White,
        backgroundColor = LightGray,
        progress = progress,
        modifier = modifier
    )
}

@Composable
fun StoriesBloc() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(25.dp)
    ) {
        var totalTime = 100L * 1000L

        var currentTime by remember {
            mutableStateOf(totalTime)
        }
        var counter by remember {
            mutableStateOf(1)
        }

        for (i in 1..4) {
            when (i) {
                1 -> {
                    Stories(
                        modifier = Modifier
                            .width(80.dp)
                            .height(6.dp)
                            .clip(RoundedCornerShape(topStart = 10.dp))
                            .padding(end = 2.5.dp)
                    )
                }
                4 -> {
                    Stories(
                        modifier = Modifier
                            .width(80.dp)
                            .height(6.dp)
                            .clip(RoundedCornerShape(topEnd = 10.dp))
                            .padding(start = 2.5.dp)
                    )
                }
                else -> {
                    Stories(
                        modifier = Modifier
                            .width(90.dp)
                            .height(6.dp)
                            .padding(end = 2.5.dp, start = 2.5.dp)
                    )
                }
            }
        }
    }
}