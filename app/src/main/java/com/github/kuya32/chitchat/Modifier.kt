package com.github.kuya32.chitchat

import java.lang.reflect.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

//fun Modifier.mediaQuery(
//    comparator: Dimensions.DimensionComparator,
//    modifier: Modifier
//): Modifier = composed {
//    val screenWidth = LocalContext.current.resources.displayMetrics.widthPixels.dp / LocalDensity.current.density
//    val screenHeight = LocalContext.current.resources.displayMetrics.heightPixels.dp / LocalDensity.current.density
//
//    if (comparator.compare(screenWidth, screenHeight)) {
//        this.then(modifier)
//    } else this
//}