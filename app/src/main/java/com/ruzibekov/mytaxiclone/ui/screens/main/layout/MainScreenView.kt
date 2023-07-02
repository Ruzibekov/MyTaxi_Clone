package com.ruzibekov.mytaxiclone.ui.screens.main.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.ruzibekov.mytaxiclone.R
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiColor
import com.ruzibekov.mytaxiclone.ui.theme.MyTaxiIcon

object MainScreenView {

    @Composable
    fun Default() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MyTaxiColor.Black)
        ) {

            /* top content */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 12.dp, end = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TopIcon(
                    iconRes = MyTaxiIcon.Gamburger,
                    onClick = { /*todo*/ }
                )

                Spacer(modifier = Modifier.width(28.dp))

                Card(modifier = Modifier.weight(1f)) {
                    Row {
                        TaBView(
                            backColor = MyTaxiColor.Green,
                            textRes = R.string.free,
                            textColor = MyTaxiColor.White
                        )

                        TaBView(
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
                        onClick = { /*todo*/ }
                    )
                    Text(
                        text = "1", //todo
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
        }
    }

    @Composable
    fun RowScope.TaBView(backColor: Color, textRes: Int, textColor: Color) {
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
    fun TopIcon(iconRes: Int, onClick: () -> Unit) {
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
        }

    }

    @Composable
    fun Preview() {
        Default()
    }
}