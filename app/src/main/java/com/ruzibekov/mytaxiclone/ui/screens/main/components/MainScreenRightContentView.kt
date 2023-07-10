package com.ruzibekov.mytaxiclone.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ruzibekov.mytaxiclone.ui.screens.main.listeners.MainListeners
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiIcon
import com.ruzibekov.mytaxiclone.utils.simpleClickable

object MainScreenRightContentView {

    @Composable
    fun Default(modifier: Modifier = Modifier, listeners: MainListeners) {
        Column(modifier = modifier.padding(top = 155.dp)) {
            Image(
                painter = painterResource(id = MyTaxiIcon.ZoomIn),
                contentDescription = "zoom in icon",
                modifier = Modifier.simpleClickable { listeners.zoomIn() },
            )

            Image(
                painter = painterResource(id = MyTaxiIcon.ZoomOut),
                contentDescription = "zoom out icon",
                modifier = Modifier.simpleClickable { listeners.zoomOut() },
            )

            Spacer(modifier = Modifier.height(5.dp))

            Image(
                painter = painterResource(id = MyTaxiIcon.MyLocation),
                contentDescription = "my location icon",
                modifier = Modifier.simpleClickable { listeners.findMe() },
            )
        }
    }
}