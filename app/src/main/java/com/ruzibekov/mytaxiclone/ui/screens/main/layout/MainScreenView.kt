package com.ruzibekov.mytaxiclone.ui.screens.main.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ruzibekov.mytaxiclone.ui.screens.components.MapBoxView
import com.ruzibekov.mytaxiclone.ui.screens.main.components.MainScreenBottomContentView
import com.ruzibekov.mytaxiclone.ui.screens.main.components.MainScreenRightContentView
import com.ruzibekov.mytaxiclone.ui.screens.main.components.MainScreenTopContentView
import com.ruzibekov.mytaxiclone.ui.screens.main.listeners.MainListeners
import com.ruzibekov.mytaxiclone.ui.screens.main.state.MainState
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiColor
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiIcon

object MainScreenView {

    @Composable
    fun Default(state: MainState, listeners: MainListeners) {
        Box(modifier = Modifier.fillMaxSize()) {

            MapBoxView.Default(
                modifier = Modifier.fillMaxSize(),
                state = state
            )

            /* top content */
            MainScreenTopContentView.Default(
                modifier = Modifier.align(Alignment.TopCenter)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(12.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MyTaxiColor.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = MyTaxiIcon.Energy),
                    contentDescription = "energy icon",
                    tint = MyTaxiColor.Blue
                )
            }

            MainScreenRightContentView.Default(
                modifier = Modifier.align(Alignment.CenterEnd),
                listeners = listeners
            )

            MainScreenBottomContentView.Default(
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }

}