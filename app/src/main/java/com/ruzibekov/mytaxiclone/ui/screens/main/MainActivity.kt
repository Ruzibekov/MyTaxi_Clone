package com.ruzibekov.mytaxiclone.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.ruzibekov.mytaxiclone.ui.screens.main.layout.MainScreenView
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiCloneTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTaxiCloneTheme {
                MainScreenView.Default(viewModel.state)
            }
        }
    }
}