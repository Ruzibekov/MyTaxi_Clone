package com.ruzibekov.mytaxiclone.ui.screens.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.graphics.drawable.toBitmap
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.animation.flyTo
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import com.ruzibekov.mytaxiclone.R
import com.ruzibekov.mytaxiclone.ui.screens.main.state.MainState

object MapBoxView {

    @Composable
    fun Default(modifier: Modifier, state: MainState) {
        val context = LocalContext.current
        val marker = remember(context) {
            context.getDrawable(R.drawable.ic_taxi)!!.toBitmap()
        }
        AndroidView(
            modifier = modifier,
            factory = {
                MapView(it).also { mapView ->
                    mapView.getMapboxMap().loadStyleUri(Style.TRAFFIC_DAY)
                    state.pointAnnotationManager.value =
                        mapView.annotations.createPointAnnotationManager()
                }
            },
            update = { mapView ->
                if (state.point.value != null) {
                    state.pointAnnotationManager.value?.let {
                        it.deleteAll()
                        val pointAnnotationOptions = PointAnnotationOptions()
                            .withPoint(state.point.value!!)
                            .withIconImage(marker)

                        it.create(pointAnnotationOptions)
                        mapView.getMapboxMap()
                            .flyTo(
                                CameraOptions.Builder()
                                    .zoom(16.0)
                                    .center(state.point.value).build()
                            )
                    }
                }
            }
        )
    }
}