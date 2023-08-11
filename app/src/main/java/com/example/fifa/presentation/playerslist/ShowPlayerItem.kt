package com.example.fifa.presentation.playerslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fifa.R
import com.example.fifa.data.remote.TOKEN
import com.example.fifa.di.baseUrl
import com.example.fifa.domain.model.PlayerModel
import com.example.fifa.ui.theme.globalElevation
import com.example.fifa.ui.theme.globalPadding
import com.example.fifa.ui.theme.globalRoundedCornerShape

@Composable
fun ShowPlayerItem(
    player: PlayerModel,
    onClick: () -> Unit
) {

    val colorVerde = colorResource(id = R.color.verdeFIFAclaro)
    val laligaFont = FontFamily(Font(R.font.laligafuente))

    Card(
        modifier = Modifier.padding(globalPadding),
        elevation = globalElevation,
        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    onClick.invoke()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(50.dp),
                placeholder = painterResource(id = R.drawable.loading_icon),
                error = painterResource(id = R.drawable.loading_icon),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(baseUrl + "players/${player.id}/image")
                    .setHeader("X-AUTH-TOKEN", "$TOKEN")
                    .build(), contentDescription = ""
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = player.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = laligaFont,

                    )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                )
                {
                    Text(
                        modifier = Modifier
                            .width(200.dp)
                            .drawBehind {
                                drawCircle(
                                    color = colorVerde,
                                    radius = 20.dp.toPx()
                                )
                                drawCircle(
                                    color = Color.Black,
                                    style = Stroke(width = 2.dp.toPx()), // Borde del círculo con ancho de 4dp
                                    radius = 20.dp.toPx()
                                )
                            },
                        fontFamily = laligaFont,
                        text = "${player.rating}",
                        textAlign = TextAlign.Center,
                    )
                }

            }
        }
    }
}