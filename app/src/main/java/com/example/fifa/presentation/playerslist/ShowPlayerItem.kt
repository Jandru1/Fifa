package com.example.fifa.presentation.playerslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fifa.R
import com.example.fifa.domain.model.PlayerModel
import com.example.fifa.ui.theme.globalElevation
import com.example.fifa.ui.theme.globalPadding
import com.example.fifa.ui.theme.globalRoundedCornerShape

@Composable
fun ShowPlayerItem(
    player: PlayerModel,
    onClick: () -> Unit
) {
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
                placeholder = painterResource(id = R.drawable.barsa),
                error = painterResource(id = R.drawable.barsa),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("photoUrl")
                    .build(), contentDescription = ""
            )
            /*            if(photo?.byteArray?.size != null) {
                            photo?.byteArray?.toBitmap()?.asImageBitmap()?.let { BitmapPainter(it) }?.let {
                                Image(painter = it,
                                    contentDescription = null)
                            }
                        }*/


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = player.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Jugador",
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}