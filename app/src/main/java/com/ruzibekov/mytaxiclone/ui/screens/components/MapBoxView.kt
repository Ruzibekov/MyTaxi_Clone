package com.ruzibekov.mytaxiclone.ui.screens.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.maps.MapView

object MapBoxView {

    @Composable
    fun Default(modifier: Modifier) {
        AndroidView(
            modifier = modifier,
            factory = {
                MapView(it).also {

                }
            }
        )
    }
}