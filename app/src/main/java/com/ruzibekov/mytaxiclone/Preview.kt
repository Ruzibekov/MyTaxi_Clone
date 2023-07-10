package com.ruzibekov.mytaxiclone

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ruzibekov.mytaxiclone.ui.screens.main.layout.MainScreenView
import com.ruzibekov.mytaxiclone.ui.screens.main.state.MainState


@Preview
@Composable
fun Preview() {
    MainPreview()
}

@Composable
fun MainPreview() {
    MainScreenView.Default(MainState())
}