package com.ruzibekov.mytaxiclone.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.Modifier


fun Modifier.simpleClickable(onClick: () -> Unit): Modifier {
    return clickable(
        interactionSource = MutableInteractionSource(),
        indication = null
    ) {
        onClick.invoke()
    }
}