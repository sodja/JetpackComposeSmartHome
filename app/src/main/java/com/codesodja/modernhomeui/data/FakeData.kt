package com.codesodja.modernhomeui.data

import com.codesodja.modernhomeui.R
import com.codesodja.modernhomeui.model.DetailsContent
import com.codesodja.modernhomeui.model.Feature
import com.codesodja.modernhomeui.ui.screen.DetailsDeviceImage

val listOfFeatures = listOf<Feature>(
    Feature(
        title = "Living room",
        code = "living",
        image = R.drawable.ic_living_green
    ),
    Feature(
        title = "Bedroom",
        code = "bed",
        image = R.drawable.ic_double_bed_green
    ),
    Feature(
        title = "Kitchen",
        code = "kitchen",
        image = R.drawable.ic_kitchen_green
    ),
    Feature(
        title = "Bathroom",
        code = "bath",
        image = R.drawable.ic_bathroom_green
    )
)

val listOfDetailContent = listOf(
    DetailsContent("Light", "L1", R.drawable.ic_light_green),
    DetailsContent("Device", "D1", R.drawable.ic_device_green),
    DetailsContent("Power", "d1", R.drawable.ic_power_green),
    DetailsContent("All", "d1", R.drawable.ic_all_green)
)

val itemsListOfDetailsContent = listOf(
    DetailsContent("Conn Light", "L1", R.drawable.light),
    DetailsContent("Conn Air", "D1", R.drawable.ic_air_conditioner),
    DetailsContent("Conn Air2", "D1", R.drawable.ic_air_conditioner)
)

fun getDetailsItemsByCode(code: String):List<DetailsContent>{
    return itemsListOfDetailsContent.filter { item -> item.code == code }
}