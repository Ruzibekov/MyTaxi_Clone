package com.ruzibekov.mytaxiclone.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.ruzibekov.mytaxiclone.ui.screens.main.layout.MainScreenView
import com.ruzibekov.mytaxiclone.ui.screens.main.listeners.MainListeners
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiCloneTheme

class MainActivity : ComponentActivity(), MainListeners {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTaxiCloneTheme {
                MainScreenView.Default(
                    state = viewModel.state,
                    listeners = this
                )
            }
        }
    }

    override fun zoomIn() {
//        TODO("Not yet implemented")
    }

    override fun zoomOut() {
//        TODO("Not yet implemented")
    }

    override fun findMe() {
//        TODO("Not yet implemented")
    }
}