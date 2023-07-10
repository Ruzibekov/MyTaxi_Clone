package com.ruzibekov.mytaxiclone.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruzibekov.mytaxiclone.R
import com.ruzibekov.mytaxiclone.ui.screens.components.NotificationIndicator
import com.ruzibekov.mytaxiclone.ui.theme.Brushes
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiColor
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiIcon

object MainScreenBottomContentView {

    @Composable
    fun Default(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                icon = MyTaxiIcon.Radar,
                textRes = R.string.orders,
                count = 1
            )

            Icon(
                icon = MyTaxiIcon.Border,
                textRes = R.string.border,
                count = 0
            )

            Icon(
                icon = MyTaxiIcon.Rates,
                textRes = R.string.rates,
                count = 0
            )
        }
    }

    @Composable
    private fun Icon(
        modifier: Modifier = Modifier,
        icon: Int,
        textRes: Int,
        count: Int
    ) {
        Column(
            modifier = modifier.width(56.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.TopEnd) {
                Icon(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Brushes.linearGradientBlackLight)
                        .padding(15.dp),
                    painter = painterResource(id = icon),
                    contentDescription = "icon",
                    tint = MyTaxiColor.White
                )

                NotificationIndicator.Default(count = count)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = textRes),
                style = MaterialTheme.typography.displayMedium,
                fontSize = 14.sp,
                color = MyTaxiColor.Font,
            )
        }
    }
}