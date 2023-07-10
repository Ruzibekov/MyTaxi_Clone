package com.ruzibekov.mytaxiclone.ui.screens.main.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.mapbox.geojson.Point
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager


data class MainState(
    val point: MutableState<Point?> = mutableStateOf(null),
    val pointAnnotationManager: MutableState<PointAnnotationManager?> = mutableStateOf(null)
)
