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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruzibekov.mytaxiclone.R
import com.ruzibekov.mytaxiclone.ui.screens.components.MapBoxView
import com.ruzibekov.mytaxiclone.ui.screens.main.state.MainState
import com.ruzibekov.mytaxiclone.ui.theme.Brushes
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiColor
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiIcon

object MainScreenView {

    @Composable
    fun Default(state: MainState) {
        Box(modifier = Modifier.fillMaxSize()) {

            MapBoxView.Default(modifier = Modifier.fillMaxSize())

            /* top content */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 12.dp, end = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TopIcon(
                    iconRes = MyTaxiIcon.Hamburger,
                    onClick = { /*todo*/ },
                    notificationCount = 0
                )

                Spacer(modifier = Modifier.width(28.dp))

                Card(modifier = Modifier.weight(1f)) {
                    Row {
                        TabView(
                            backColor = MyTaxiColor.Green,
                            textRes = R.string.free,
                            textColor = MyTaxiColor.White
                        )

                        TabView(
                            backColor = MyTaxiColor.White,
                            textRes = R.string.busy,
                            textColor = MyTaxiColor.Dark
                        )
                    }
                }

                Spacer(modifier = Modifier.width(28.dp))

                Box(contentAlignment = Alignment.TopEnd) {
                    TopIcon(
                        iconRes = MyTaxiIcon.Notification,
                        onClick = { /*todo*/ },
                        notificationCount = 1
                    )
                }
            }

            /* bottom content */
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomIcon(
                    icon = MyTaxiIcon.Radar,
                    textRes = R.string.orders,
                    count = 1
                )

                BottomIcon(
                    icon = MyTaxiIcon.Border,
                    textRes = R.string.border,
                    count = 0
                )

                BottomIcon(
                    icon = MyTaxiIcon.Rates,
                    textRes = R.string.rates,
                    count = 0
                )
            }
        }
    }

    @Composable
    private fun RowScope.TabView(backColor: Color, textRes: Int, textColor: Color) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(backColor)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = textRes),
                style = MaterialTheme.typography.bodyMedium,
                color = textColor,
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TopIcon(iconRes: Int, onClick: () -> Unit, notificationCount: Int) {
        Card(
            onClick = onClick,
            shape = CircleShape,
            modifier = Modifier.size(40.dp),
            colors = CardDefaults.cardColors(containerColor = MyTaxiColor.White)
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = "topbar icon",
                tint = MyTaxiColor.Black
            )
            NotificationIndicator(count = notificationCount)
        }
    }

    @Composable
    private fun NotificationIndicator(count: Int) {
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

    @Composable
    private fun BottomIcon(
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

                NotificationIndicator(count = count)
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