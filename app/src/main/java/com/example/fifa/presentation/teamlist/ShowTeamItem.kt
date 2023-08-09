package com.example.fifa.presentation.teamlist

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.fifa.R
import com.example.fifa.TeamTestDataBuilder
import com.example.fifa.data.remote.TOKEN
import com.example.fifa.domain.model.ItemModel
import com.example.fifa.ui.theme.globalElevation
import com.example.fifa.ui.theme.globalPadding
import com.example.fifa.ui.theme.globalRoundedCornerShape
import org.koin.androidx.compose.koinViewModel

@Composable
fun ShowTeamItem(
    team: ItemModel,
    onClick: () -> Unit,
    teamListViewModel: TeamListViewModel = koinViewModel(),
    ){

    val teamList = teamListViewModel.teamList.observeAsState().value
    val photo = teamListViewModel.teamImage.observeAsState().value
    //

    LaunchedEffect(Unit) {
        if (team.escudo.byteArray != null) {
            val url = teamListViewModel.getUrl(team.id)
            if (photo != null) {
                team.escudo = photo
            }
        }
    }

    Card(
        modifier = androidx.compose.ui.Modifier.padding(globalPadding),
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
                    .data("https://futdb.app/api/clubs/${team.id}/image")
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
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = team.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Actual Campeón",
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

fun ByteArray.toBitmap(): android.graphics.Bitmap{
    return android.graphics.BitmapFactory.decodeByteArray(this,0, size)
}

@Preview
@Composable
fun ShowPreview(){
    ShowTeamItem(
        TeamTestDataBuilder()
            .withId(-1)
            .withName("EquipoPrueba")
            .withLeague(-1)
            .builder(),
        fun(){

        }
    )
}
