package com.ruzibekov.mytaxiclone.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiColor

object NotificationIndicator {

    @Composable
    fun Default(count: Int) {
        if (count > 0)
            Text(
                text = count.toString(),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .offset(y = (-4).dp)
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(MyTaxiColor.Red)
                    .offset(y = (-2).dp),
                color = MyTaxiColor.White,
                textAlign = TextAlign.Center
            )
    }
}